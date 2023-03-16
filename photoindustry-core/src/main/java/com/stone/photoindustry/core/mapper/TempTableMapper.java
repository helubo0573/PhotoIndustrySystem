package com.stone.photoindustry.core.mapper;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.mapper.RDBatisDao;
import com.stone.photoindustry.core.domain.TempTable;

/**
 * 门店申请加入表Dao
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-10-23 22:53:11
 */
@RDBatisDao
public interface TempTableMapper extends BaseMapper<TempTable, Long> {

    int getCount(String code);

}
