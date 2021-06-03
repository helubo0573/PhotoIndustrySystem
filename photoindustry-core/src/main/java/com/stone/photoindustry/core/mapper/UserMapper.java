package com.stone.photoindustry.core.mapper;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.mapper.RDBatisDao;
import com.stone.photoindustry.core.domain.User;

/**
 * 用户表Dao
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-03 20:54:21
 */
@RDBatisDao
public interface UserMapper extends BaseMapper<User, Long> {

    

}
