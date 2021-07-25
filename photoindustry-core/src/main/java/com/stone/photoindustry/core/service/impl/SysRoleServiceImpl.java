package com.stone.photoindustry.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.SysRoleMapper;
import com.stone.photoindustry.core.domain.SysRole;
import com.stone.photoindustry.core.service.SysRoleService;


/**
 * 角色表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:26:47
 */
 
@Service("roleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole, Long> implements SysRoleService {
	
    private static final Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);
   
    @Resource
    private SysRoleMapper roleMapper;

	@Override
	public BaseMapper<SysRole, Long> getMapper() {
		return roleMapper;
	}

	@Override
	public List<SysRole> getRoleListByUserId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}