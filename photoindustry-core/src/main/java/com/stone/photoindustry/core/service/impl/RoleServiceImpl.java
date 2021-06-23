package com.stone.photoindustry.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.RoleMapper;
import com.stone.photoindustry.core.domain.Role;
import com.stone.photoindustry.core.service.RoleService;


/**
 * 角色表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:26:47
 */
 
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService {
	
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
   
    @Resource
    private RoleMapper roleMapper;

	@Override
	public BaseMapper<Role, Long> getMapper() {
		return roleMapper;
	}

	@Override
	public List<Role> getRoleListByUserId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}