package com.stone.photoindustry.manage.Action;

import javax.annotation.Resource;

import com.stone.photoindustry.core.domain.User;
import com.stone.photoindustry.core.mapper.UserMapper;

public class CompanyAction {

	@Resource
	private  UserMapper userMapper;
	
	public  void joinCompany(Long userId,Long CompanyId) {
		User user=userMapper.findByPrimary(userId);
		user.setCompanyId(CompanyId);
		userMapper.update(user);
	}
}
