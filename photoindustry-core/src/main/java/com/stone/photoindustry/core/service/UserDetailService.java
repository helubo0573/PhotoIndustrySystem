package com.stone.photoindustry.core.service;

import com.stone.photoindustry.core.common.service.BaseService;
import com.stone.photoindustry.core.domain.UserDetail;

/**
 * 用户详细信息表Service
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-07-08 10:52:16
 */
public interface UserDetailService extends BaseService<UserDetail, Long>{

	public UserDetail getDetailByUserId(Long id); 
}
