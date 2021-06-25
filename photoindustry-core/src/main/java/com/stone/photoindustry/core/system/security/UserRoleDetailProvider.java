package com.stone.photoindustry.core.system.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.stone.photoindustry.core.common.constant.SystemConstant;
import com.stone.photoindustry.core.common.exception.ServiceException;
import com.stone.photoindustry.core.domain.Role;
import com.stone.photoindustry.core.domain.User;
import com.stone.photoindustry.core.model.MenuModel;
import com.stone.photoindustry.core.service.MenuService;
import com.stone.photoindustry.core.service.RoleService;
import com.stone.photoindustry.core.service.UserService;
import tool.util.StringUtil;


@SuppressWarnings("deprecation")
@Service
public class UserRoleDetailProvider implements UserDetailsService{

	public static final Logger logger = LoggerFactory.getLogger(UserRoleDetailProvider.class);

	@Autowired
	private UserService UserService;

	@Autowired
	private RoleService RoleService;

	@Autowired
	private MenuService MenuService;

	private PasswordEncoder passwordEncoder;

	private String systemPasswordInitialization;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException
	{
		User user = UserService.getUserByUserName(userName);	// 根据登陆用户名获得用户信息
		if (user == null)	throw new UsernameNotFoundException("用户名:"+userName + ",不存在!");
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();		// 用户授权集合
		Map<String, UserFunction> functionMap = new HashMap<String, UserFunction>();// 用户资源映射<资源名称, 资源属性集合>
		List<Role> roleList = RoleService.getRoleListByUserId(user.getId());	// 根据用户Id获得用户角色列表
		auths.add(new MGrantedAuthority(SystemConstant.ROLE_DEFAULT));			// 设置默认权限
		if (roleList != null && !roleList.isEmpty()){
			List<Long> roleIdList = new ArrayList<Long>();
			roleList.forEach(role->{
				auths.add(new MGrantedAuthority(role.getId().toString()));
				roleIdList.add(role.getId());
			});
			List<MenuModel> menuList = MenuService.getMenuListByRoleIds(roleIdList);		// 根据用户角色Id列表获得该角色拥有的系统功能列表
			if (menuList != null && !menuList.isEmpty()){
				menuList.forEach(menu->{	// 转换系统功能为用户资源
					String href = menu.getUrl();
					if (StringUtil.isNotBlank(href)){
						String[] urls = StringUtils.commaDelimitedListToStringArray(href);
						for (String url : urls){
							url = StringUtil.trim(url);
							if (StringUtil.isNotBlank(url)){
								
								if (!functionMap.containsKey(url)){	// 设置用户资源映射, key为资源对应的名称 (即系统功能url), value为资源属性集合 (即拥有该系统功能的角色)
									UserFunction userFunction = new UserFunction(menu.getId());
									ConfigAttribute ca = new SecurityConfig(menu.getRoleIDtostr());
									userFunction.add(ca);
									functionMap.put(url, userFunction);
								} else{
									functionMap.get(url).add(new SecurityConfig(menu.getRoleIDtostr()));
								}
							}
						}
					}
				});
			}
		}
		return new UserRole(userName, user.getUserPassword(), auths,functionMap);
	}

	private String getPassword(User op) throws ServiceException
	{
		String password = op.getUserPassword();
		if (SystemConstant.SYSTEM_LOGIN_NAME.equals(op.getUserName()) && op.getLoginTime() == null)
		{
			if (StringUtil.isNotBlank(systemPasswordInitialization))
			{
				password = passwordEncoder.encodePassword(systemPasswordInitialization);
			} else
			{
				password = passwordEncoder.encodePassword(SystemConstant.SYSTEM_PASSWORD_DEFAULT);
			}
			op.setUserPassword(password);
			UserService.editUserPassWord(op);
		}
		return password;
	}

	
	public UserService getSysUserService() { 
		return UserService; 
	}
	
	public void setSysUserService(UserService UserService) { 
		this.UserService =UserService; 
	}
	 
	public RoleService getSysRoleService() { 
		return RoleService; 
	}
	
	public void setSysRoleService(RoleService sysRoleService) {
		this.RoleService = sysRoleService; 
	}
	
	public MenuService getSysMenuService() { 
		return MenuService; 
	}
	
	public void setSysMenuService(MenuService sysMenuService) {
		this.MenuService = sysMenuService; 
	}
	
	public String getSystemPasswordInitialization() { 
		return systemPasswordInitialization; 
	}
	 
	public void setSystemPasswordInitialization(String systemPasswordInitialization) { 
		this.systemPasswordInitialization =systemPasswordInitialization; 
	}

}
