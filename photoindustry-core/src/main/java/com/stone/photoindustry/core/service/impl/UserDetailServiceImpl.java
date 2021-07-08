package com.stone.photoindustry.core.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.UserDetailMapper;
import com.stone.photoindustry.core.domain.UserDetail;
import com.stone.photoindustry.core.service.UserDetailService;


/**
 * 用户详细信息表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-07-08 10:52:16
 */
 
@Service("userDetailService")
public class UserDetailServiceImpl extends BaseServiceImpl<UserDetail, Long> implements UserDetailService {
	
    private static final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);
   
    @Resource
    private UserDetailMapper userDetailMapper;

	@Override
	public BaseMapper<UserDetail, Long> getMapper() {
		return userDetailMapper;
	}

	@Override
	public UserDetail getDetailByUserId(Long id) {
		HashMap<String, Object> param=new HashMap<String, Object>();
		param.put("userId", id);
		return userDetailMapper.findSelective(param);
	}
	
}