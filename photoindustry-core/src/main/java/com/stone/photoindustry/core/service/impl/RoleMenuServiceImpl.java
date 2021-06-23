package com.stone.photoindustry.core.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.RoleMenuMapper;
import com.stone.photoindustry.core.domain.RoleMenu;
import com.stone.photoindustry.core.service.RoleMenuService;


/**
 * 角色菜单映射表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:30:59
 */
 
@Service("roleMenuService")
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu, Long> implements RoleMenuService {
	
    private static final Logger logger = LoggerFactory.getLogger(RoleMenuServiceImpl.class);
   
    @Resource
    private RoleMenuMapper roleMenuMapper;

	@Override
	public BaseMapper<RoleMenu, Long> getMapper() {
		return roleMenuMapper;
	}
	
}