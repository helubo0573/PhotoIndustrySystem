package com.stone.photoindustry.core.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.CompanyInfoMapper;
import com.stone.photoindustry.core.domain.CompanyInfo;
import com.stone.photoindustry.core.service.CompanyInfoService;


/**
 * 门店(公司)信息表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-07-16 21:45:32
 */
 
@Service("companyInfoService")
public class CompanyInfoServiceImpl extends BaseServiceImpl<CompanyInfo, Long> implements CompanyInfoService {
	
    private static final Logger logger = LoggerFactory.getLogger(CompanyInfoServiceImpl.class);
   
    @Resource
    private CompanyInfoMapper companyInfoMapper;

	@Override
	public BaseMapper<CompanyInfo, Long> getMapper() {
		return companyInfoMapper;
	}

	@Override
	public boolean checkCompanyNameExist(String cname, String clocation) {
		HashMap<String, Object> param=new HashMap<String, Object>();
		param.put("companyName", cname);
		param.put("companyLocation", clocation);
		int num=companyInfoMapper.checkCompanyName(param);
		System.out.println("testcom");
		return num>0?true:false;
	}
	
}