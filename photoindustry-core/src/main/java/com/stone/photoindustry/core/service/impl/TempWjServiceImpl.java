package com.stone.photoindustry.core.service.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stone.photoindustry.core.common.mapper.BaseMapper;
import com.stone.photoindustry.core.common.service.impl.BaseServiceImpl;
import com.stone.photoindustry.core.mapper.TempTableMapper;
import com.stone.photoindustry.core.mapper.TempWjMapper;
import com.stone.photoindustry.core.domain.TempTable;
import com.stone.photoindustry.core.domain.TempWj;
import com.stone.photoindustry.core.service.TempWjService;


/**
 * 门店申请加入表ServiceImpl
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-10-23 22:52:25
 */
 
@Service("tempWjService")
public class TempWjServiceImpl extends BaseServiceImpl<TempWj, Long> implements TempWjService {
	
    private static final Logger logger = LoggerFactory.getLogger(TempWjServiceImpl.class);
   
    @Resource
    private TempWjMapper tempWjMapper;

    @Resource
    private TempTableMapper tempTableMapper;
    
	@Override
	public BaseMapper<TempWj, Long> getMapper() {
		return tempWjMapper;
	}

	@Override
	public void temprun() {
		List<TempWj> data=tempWjMapper.listSelective(null);
		for(TempWj e:data) {
			TempTable table=new TempTable();
			table.setCode(formatcode(e.getTypeName()));
			table.setTypename(e.getGoodsName());
			table.setDtail(1);
			table.setGoodsRename(e.getGoodsName());
			table.setHelpCode(e.getTypeName());
			if(e.getGoodsSize()!=null) table.setSize(e.getGoodsSize().length()>0?e.getGoodsSize():""); else table.setSize("");
			table.setOpName("外购");
			if(e.getUnit()!=null) table.setUnit(e.getUnit().length()>0?e.getUnit():""); else table.setUnit("");
			if(e.getAmount()!=null) table.setStock(e.getAmount().length()>0?e.getAmount():""); else table.setStock("");
			if(e.getSupplier()!=null) table.setSupplier(e.getSupplier().length()>0?e.getSupplier():""); else table.setSupplier("");
			if(e.getStone()!=null) table.setGoodsStroe(e.getStone());
			tempTableMapper.save(table);
		}
	}
	
	public String formatcode(String typename) {
		HashMap<String, Object> param=new HashMap<String, Object>();
		param.put("typename", typename);
		String code=tempTableMapper.findSelective(param).getCode();
		int n=tempTableMapper.getCount(code);
		String codes=new DecimalFormat("000").format(n);
		return code+"."+codes;
	}
}