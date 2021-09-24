package com.stone.photoindustry.core.mapper;

import java.util.HashMap;
import java.util.List;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.mapper.RDBatisDao;
import com.stone.photoindustry.core.domain.SysMenu;

/**
 * 菜单表Dao
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:26:23
 */
@RDBatisDao
public interface SysMenuMapper extends BaseMapper<SysMenu, Long> {

	List<SysMenu> getMenuByUserName(HashMap<String, Object> param);

}
