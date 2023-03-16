package com.stone.photoindustry.core.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.TempTableMapper;
import com.stone.photoindustry.core.domain.TempTable;
import com.stone.photoindustry.core.service.TempTableService;


/**
 * 门店申请加入表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-10-24 14:12:47
 */
 
@Service("tempTableService")
public class TempTableServiceImpl extends BaseServiceImpl<TempTable, Long> implements TempTableService {
	
    private static final Logger logger = LoggerFactory.getLogger(TempTableServiceImpl.class);
   
    @Resource
    private TempTableMapper tempTableMapper;

	@Override
	public BaseMapper<TempTable, Long> getMapper() {
		return tempTableMapper;
	}
	
}