package com.stone.photoindustry.core.service;

import java.util.List;

import com.stone.photoindustry.core.common.service.BaseService;
import com.stone.photoindustry.core.domain.Role;

/**
 * 角色表Service
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:26:47
 */
public interface RoleService extends BaseService<Role, Long>{

	List<Role> getRoleListByUserId(Long id);

}
