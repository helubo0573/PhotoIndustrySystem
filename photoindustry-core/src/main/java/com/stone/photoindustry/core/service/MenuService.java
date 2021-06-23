package com.stone.photoindustry.core.service;

import java.util.List;

import com.stone.photoindustry.core.common.service.BaseService;
import com.stone.photoindustry.core.domain.Menu;
import com.stone.photoindustry.core.model.MenuModel;

/**
 * 菜单表Service
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:26:23
 */
public interface MenuService extends BaseService<Menu, Long>{

	List<MenuModel> getMenuListByRoleIds(List<Long> roleIdList);

}
