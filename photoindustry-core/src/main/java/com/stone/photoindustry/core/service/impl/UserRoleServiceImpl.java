package com.stone.photoindustry.core.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.UserRoleMapper;
import com.stone.photoindustry.core.domain.UserRole;
import com.stone.photoindustry.core.service.UserRoleService;


/**
 * 用户角色映射表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:31:39
 */
 
@Service("userRoleService")
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, Long> implements UserRoleService {
	
    private static final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);
   
    @Resource
    private UserRoleMapper userRoleMapper;

	@Override
	public BaseMapper<UserRole, Long> getMapper() {
		return userRoleMapper;
	}
	
}