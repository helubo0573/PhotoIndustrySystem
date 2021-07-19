package com.stone.photoindustry.core.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.UserMapper;
import com.stone.photoindustry.core.model.UserModel;
import com.stone.photoindustry.core.domain.User;
import com.stone.photoindustry.core.service.UserService;


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
	public void joinCompany(Long userid,Long companyId) {
		HashMap<String, Object> param=new HashMap<String, Object>();
		param.put("id", userid);
		param.put("companyId", companyId);
		userMapper.updateSelective(param);
		
	}
	
}