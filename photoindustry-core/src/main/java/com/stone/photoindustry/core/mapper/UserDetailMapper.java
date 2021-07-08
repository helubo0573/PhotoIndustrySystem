package com.stone.photoindustry.core.mapper;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.mapper.RDBatisDao;
import com.stone.photoindustry.core.domain.UserDetail;

/**
 * 用户详细信息表Dao
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-07-08 10:52:16
 */
@RDBatisDao
public interface UserDetailMapper extends BaseMapper<UserDetail, Long> {

    

}
