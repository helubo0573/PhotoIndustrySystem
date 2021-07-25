package com.stone.photoindustry.core.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.SysRoleMenuMapper;
import com.stone.photoindustry.core.domain.SysRoleMenu;
import com.stone.photoindustry.core.service.SysRoleMenuService;


/**
 * 角色菜单映射表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:30:59
 */
 
@Service("roleMenuService")
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenu, Long> implements SysRoleMenuService {
	
    private static final Logger logger = LoggerFactory.getLogger(SysRoleMenuServiceImpl.class);
   
    @Resource
    private SysRoleMenuMapper roleMenuMapper;

	@Override
	public BaseMapper<SysRoleMenu, Long> getMapper() {
		return roleMenuMapper;
	}
	
}