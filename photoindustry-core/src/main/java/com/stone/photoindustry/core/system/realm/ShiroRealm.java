package com.stone.photoindustry.core.system.realm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.stone.photoindustry.core.domain.SysMenu;
import com.stone.photoindustry.core.domain.User;
import com.stone.photoindustry.core.model.UserModel;
import com.stone.photoindustry.core.service.UserService;
import com.stone.photoindustry.core.service.CompanyInfoService;
import com.stone.photoindustry.core.service.SysMenuService;


public class ShiroRealm extends AuthorizingRealm{

	private static final Logger logger = Logger.getLogger(ShiroRealm.class);

	@Resource
	private CompanyInfoService companyInfoService;
	@Resource
	private UserService UserService;
	@Resource	
	private SysMenuService MenuService;
	@Override
	/**
	 * 	授权
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
		User user=(User) principals.oneByType(User.class);
		logger.info("test-----"+user.getId()+"----"+companyInfoService.getAdminId(user.getCompanyId()));
		logger.info("授权认证：" + principals.getRealmNames());
		// (关闭浏览器，或超时)非正常退出，即没有显式调用 SecurityUtils.getSubject().logout()
		if (!SecurityUtils.getSubject().isAuthenticated()){
			logger.info("over");
			doClearCache(principals);
			SecurityUtils.getSubject().logout();
			return null;
		}
		List<SysMenu> perms;
		if(companyInfoService.getAdminId(user.getCompanyId())==user.getId()) {
			perms=MenuService.getAllperms(user.getCompanyId());
		}else{
			perms=MenuService.getPermsByUser(user);
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for (SysMenu perm : perms){
			info.addStringPermission(perm.getPerms());		//遍历所有获取的权限字串
		}
		return info;
	}

	/**
	 * 	验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException
	{
		logger.info("验证用户");
		// 获取基于用户名和密码的令牌
		// user.login(token) 间接调用
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		// 从数据库中查询用户用信息
		UserModel user=UserService.getUserModelByUserName(token.getUsername());
		if (user == null){
			throw new UnknownAccountException();// 没找到帐号
		} else if (user.getStatus() == 2){
			throw new LockedAccountException(); // 帐号锁定
		} else{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			session.setAttribute("user", user);
			List<Object> principals = new ArrayList<Object>();//用一个MAP对象将用户类和名称直接传到SimpleAuthenticationInfo类的第一个参数中
			principals.add(user.getUserName());
			principals.add(user);
			//return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
			return new SimpleAuthenticationInfo(principals, user.getUserPassword(), getName());
		}

	}

}
