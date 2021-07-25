package com.stone.photoindustry.core.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.constant.Constant;
import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.common.util.DBService;
import com.stone.photoindustry.core.common.util.MD5;
import com.stone.photoindustry.core.common.util.SqlUtil;
import com.stone.photoindustry.core.mapper.UserMapper;
import com.stone.photoindustry.core.model.UserModel;
import com.stone.photoindustry.core.domain.User;
import com.stone.photoindustry.core.service.UserService;
import com.stone.photoindustry.core.system.security.PasswordEncoder;


/**
 * 用户表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-03 20:54:21
 */
 
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
	
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    
    @Resource
	private AuthenticationManager authenticationManager;
    
    @Resource
	private PasswordEncoder passwordEncoder;// 密码加密
    
    @Resource
	protected DBService dbService;
    
    @Resource
    private UserMapper userMapper;

	@Override
	public BaseMapper<User, Long> getMapper() {
		return userMapper;
	}

	@Override
	public void editUserLoginInfo(User op) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public User getUserByUserName(String username) {
		HashMap<String, Object> param=new HashMap<String, Object>();
		param.put("userName", username);
		User user=userMapper.findSelective(param);
		return user;
	}
	@Override
	public UserModel getUserModelByUserName(String userName) {
		UserModel user=userMapper.getUserModelByUserName(userName);
		return user;
	}

	@Override
	public void editUserPassWord(User op) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void applyJoinCompany(Long userid, Long companyId) {
		dbService.insert(SqlUtil.buildInsertSqlMap("company_apply_join",
			new Object[][] { { "company_id", companyId },
					{ "user_id", userid },
					{ "apply_date",  new Date() }, 
					{ "apply_status", 0 } }));
	}

	@Override
	public void joinCompany(Long userid,Long companyId) {
		HashMap<String, Object> param=new HashMap<String, Object>();
		param.put("id", userid);
		param.put("companyId", companyId);
		userMapper.updateSelective(param);
		
	}

	@Override
	public HashMap<String, Object> Auth(String username, String password, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		try {
			Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			Subject user = SecurityUtils.getSubject();
			// 获取加密后的密码字符串
			password = passwordEncoder.encodePassword(String.valueOf(password));
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			// token.setRememberMe(true);
			user.login(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			// 还需要研究这一条
			session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
			UserModel userinfo = (UserModel) user.getSession().getAttribute("user");
			session.setAttribute("SysUser", userinfo);
			res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
			res.put(Constant.RESPONSE_CODE_MSG, "登录成功");
		} catch (IncorrectCredentialsException ex) {
			logger.error("密码错误", ex);
			res.put(Constant.RESPONSE_CODE, Constant.OTHER_CODE_VALUE);
			res.put(Constant.RESPONSE_CODE_MSG, "密码错误请重新输入");
		} catch (LockedAccountException ex) {
			logger.error("该用户已锁定", ex);
			res.put(Constant.RESPONSE_CODE, Constant.OTHER_CODE_VALUE);
			res.put(Constant.RESPONSE_CODE_MSG, "该用户已锁定，请联系管理员！");
		} catch (AuthenticationException ex) {
			logger.error("登录失败", ex);
			res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
			res.put(Constant.RESPONSE_CODE_MSG, "用户名或密码错误");
		} catch (ExpiredCredentialsException ex) {
			logger.error(ex.getMessage(), ex);
			res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
			res.put(Constant.RESPONSE_CODE_MSG, ex.getMessage());
		} catch (UnknownAccountException ex) {
			logger.error(ex.getMessage(), ex);
			res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
			res.put(Constant.RESPONSE_CODE_MSG, "账号不存在请核对后重新输入");
		}
		return res;
	}
	
}