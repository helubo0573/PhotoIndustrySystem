package com.stone.photoindustry.core.service;

import com.stone.photoindustry.core.common.service.BaseService;
import com.stone.photoindustry.core.domain.TempWj;

/**
 * 门店申请加入表Service
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-10-23 22:52:25
 */
public interface TempWjService extends BaseService<TempWj, Long>{
	void temprun();
}
