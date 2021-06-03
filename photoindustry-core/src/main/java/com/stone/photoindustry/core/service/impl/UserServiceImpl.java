package com.stone.photoindustry.core.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.UserMapper;
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
	
}