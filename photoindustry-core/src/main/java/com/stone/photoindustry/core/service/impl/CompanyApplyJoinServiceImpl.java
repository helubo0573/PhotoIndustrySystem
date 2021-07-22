package com.stone.photoindustry.core.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.common.util.DBService;
import com.stone.photoindustry.core.common.util.SqlUtil;
import com.stone.photoindustry.core.mapper.CompanyApplyJoinMapper;
import com.stone.photoindustry.core.mapper.UserMapper;
import com.stone.photoindustry.core.domain.CompanyApplyJoin;
import com.stone.photoindustry.core.domain.User;
import com.stone.photoindustry.core.service.CompanyApplyJoinService;


/**
 * 门店申请加入表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-07-22 20:33:10
 */
 
@Service("companyApplyJoinService")
public class CompanyApplyJoinServiceImpl extends BaseServiceImpl<CompanyApplyJoin, Long> implements CompanyApplyJoinService {
	
    private static final Logger logger = LoggerFactory.getLogger(CompanyApplyJoinServiceImpl.class);
   
    @Resource
	protected DBService dbService;
    
    @Resource
    private CompanyApplyJoinMapper companyApplyJoinMapper;

    @Resource
	private  UserMapper userMapper;
    
	@Override
	public BaseMapper<CompanyApplyJoin, Long> getMapper() {
		return companyApplyJoinMapper;
	}

	@Override
	public Long applyJoinCompany(Long userId, Long companyId) {
		Long id=dbService.insert(SqlUtil.buildInsertSqlMap("company_apply_join",
				new Object[][] { 
			{ "company_id", companyId },
			{ "user_id", userId },
			{ "apply_date", new Date() }, 
			{ "apply_status", 0 }
		}));
		return id;
	}

	@Override
	public boolean checkJoinCompany(Long id, Long companyId,Long userId,int applyStatus) {
		try {
			CompanyApplyJoin data=companyApplyJoinMapper.findByPrimary(id);
			data.setApplyStatus(applyStatus);
			companyApplyJoinMapper.update(data);
			if(applyStatus==1) {
				User user=userMapper.findByPrimary(userId);
				user.setCompanyId(companyId);
				userMapper.update(user);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}