package com.stone.photoindustry.core.mapper;

import java.util.HashMap;
import java.util.List;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.mapper.RDBatisDao;
import com.stone.photoindustry.core.domain.CompanyInfo;

/**
 * 门店(公司)信息表Dao
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-07-16 21:45:32
 */
@RDBatisDao
public interface CompanyInfoMapper extends BaseMapper<CompanyInfo, Long> {

    int checkCompanyName(HashMap<String, Object> param);

    List<CompanyInfo> ListMoreSelective(HashMap<String, Object> param);
    
    /**
     * 	校验用户是否为公司下的管理员权限
     * @param param	id:公司id  originatorId:用户id
     * @return
     */
    boolean checkAdmin(HashMap<String, Object> param);
}
