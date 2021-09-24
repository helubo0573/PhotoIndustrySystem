package com.stone.photoindustry.core.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.SysMenuMapper;
import com.stone.photoindustry.core.model.SysMenuModel;
import com.stone.photoindustry.core.model.UserModel;
import com.stone.photoindustry.core.domain.SysMenu;
import com.stone.photoindustry.core.domain.User;
import com.stone.photoindustry.core.service.CompanyInfoService;
import com.stone.photoindustry.core.service.SysMenuService;


/**
 * 菜单表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:26:23
 */
 
@Service("menuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu, Long> implements SysMenuService {
	
    private static final Logger logger = LoggerFactory.getLogger(SysMenuServiceImpl.class);
   
    @Resource
    private SysMenuMapper menuMapper;
    
    @Resource
    private CompanyInfoService companyInfoService;
	@Override
	public BaseMapper<SysMenu, Long> getMapper() {
		return menuMapper;
	}

	@Override
	public List<SysMenuModel> getMenuListByRoleIds(List<Long> roleIdList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysMenu> getPermsByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysMenu> getMunuByUser(UserModel user) {
		if(companyInfoService.getAdminId(user.getCompanyId())==user.getId()) {	//判断是否为管理员
			return menuMapper.listSelective(null);
		}else {
			HashMap<String, Object> param=new HashMap<String,Object>();
			param.put("user", user.getUserName());
			param.put("companyid", user.getCompanyId());
			return menuMapper.getMenuByUserName(param);
		}
	}
	
}