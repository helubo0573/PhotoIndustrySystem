package com.stone.photoindustry.core.service;

import java.util.List;

import com.stone.photoindustry.core.common.service.BaseService;
import com.stone.photoindustry.core.domain.SysMenu;
import com.stone.photoindustry.core.domain.User;
import com.stone.photoindustry.core.model.SysMenuModel;

/**
 * 菜单表Service
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:26:23
 */
public interface SysMenuService extends BaseService<SysMenu, Long>{

	List<SysMenuModel> getMenuListByRoleIds(List<Long> roleIdList);

	List<SysMenu> getPermsByUser(User user);

}
