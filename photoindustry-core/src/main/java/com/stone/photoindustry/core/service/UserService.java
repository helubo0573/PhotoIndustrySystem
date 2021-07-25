package com.stone.photoindustry.core.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stone.photoindustry.core.common.service.BaseService;
import com.stone.photoindustry.core.domain.User;
import com.stone.photoindustry.core.model.UserModel;

/**
 * 用户表Service
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-03 20:54:21
 */
public interface UserService extends BaseService<User, Long>{

	void editUserLoginInfo(User op);

	User getUserByUserName(String userName);

	void editUserPassWord(User op);

	UserModel getUserModelByUserName(String userName);

	void applyJoinCompany(Long userid,Long companyId);
	
	void joinCompany(Long userid,Long companyId);
	
	HashMap<String, Object> Auth(String username,String password,HttpServletRequest request, HttpServletResponse response, HttpSession session);
}
