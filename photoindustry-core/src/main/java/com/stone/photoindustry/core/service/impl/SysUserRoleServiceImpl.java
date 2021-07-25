package com.stone.photoindustry.core.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.SysUserRoleMapper;
import com.stone.photoindustry.core.domain.SysUserRole;
import com.stone.photoindustry.core.service.SysUserRoleService;


/**
 * 用户角色映射表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:31:39
 */
 
@Service("userRoleService")
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRole, Long> implements SysUserRoleService {
	
    private static final Logger logger = LoggerFactory.getLogger(SysUserRoleServiceImpl.class);
   
    @Resource
    private SysUserRoleMapper userRoleMapper;

	@Override
	public BaseMapper<SysUserRole, Long> getMapper() {
		return userRoleMapper;
	}
	
}