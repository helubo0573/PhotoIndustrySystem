package com.stone.photoindustry.core.service;

import com.stone.photoindustry.core.common.service.BaseService;
import com.stone.photoindustry.core.domain.CompanyApplyJoin;

/**
 * 门店申请加入表Service
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-07-22 20:33:10
 */
public interface CompanyApplyJoinService extends BaseService<CompanyApplyJoin, Long>{

	public Long applyJoinCompany(Long userId,Long companyId);
	
	public boolean checkJoinCompany(Long Id,Long companyId,Long userId,int applyStatus);
}
