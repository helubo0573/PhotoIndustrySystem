package com.stone.photoindustry.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.MenuMapper;
import com.stone.photoindustry.core.model.MenuModel;
import com.stone.photoindustry.core.domain.Menu;
import com.stone.photoindustry.core.service.MenuService;


/**
 * 菜单表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:26:23
 */
 
@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu, Long> implements MenuService {
	
    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
   
    @Resource
    private MenuMapper menuMapper;

	@Override
	public BaseMapper<Menu, Long> getMapper() {
		return menuMapper;
	}

	@Override
	public List<MenuModel> getMenuListByRoleIds(List<Long> roleIdList) {
		// TODO Auto-generated method stub
		return null;
	}
	
}