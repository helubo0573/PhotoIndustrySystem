package com.stone.photoindustry.core.service;

import com.stone.photoindustry.core.common.service.BaseService;
import com.stone.photoindustry.core.domain.CompanyInfo;

/**
 * 门店(公司)信息表Service
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-07-16 21:45:32
 */
public interface CompanyInfoService extends BaseService<CompanyInfo, Long>{

	boolean checkCompanyNameExist(String cname,String clocation);
	
	Long getAdminId(Long id);
}
