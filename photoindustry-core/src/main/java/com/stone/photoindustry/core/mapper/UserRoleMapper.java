package com.stone.photoindustry.core.mapper;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.mapper.RDBatisDao;
import com.stone.photoindustry.core.domain.UserRole;

/**
 * 用户角色映射表Dao
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:31:39
 */
@RDBatisDao
public interface UserRoleMapper extends BaseMapper<UserRole, Long> {

    

}
