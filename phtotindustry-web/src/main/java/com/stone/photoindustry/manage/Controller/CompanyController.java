package com.stone.photoindustry.manage.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stone.photoindustry.core.common.constant.Constant;
import com.stone.photoindustry.core.common.util.DBService;
import com.stone.photoindustry.core.common.util.ServletUtils;
import com.stone.photoindustry.core.common.util.SqlUtil;
import com.stone.photoindustry.core.domain.CompanyInfo;
import com.stone.photoindustry.core.domain.User;
import com.stone.photoindustry.core.mapper.CompanyInfoMapper;
import com.stone.photoindustry.core.service.CompanyInfoService;
import com.stone.photoindustry.core.service.UserService;

@Controller
@RequestMapping("company")
public class CompanyController {

	@Resource
	protected DBService dbService;
	@Resource
	private UserService userService;
	@Resource
	private CompanyInfoService companyInfoService;
	@Resource
	private CompanyInfoMapper companyInfoMapper;
	@RequestMapping("/createcompany")
	public void createCompany(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(name="companyName")String companyName,
			@RequestParam(name="companyId")String companyId,
			@RequestParam(name="location")String companyLocation,
			@RequestParam(name="detailAddress")String detailAddress,
			@RequestParam(name="numberEmployee")int numberEmployee) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		try {
			if(!companyInfoService.checkCompanyNameExist(companyName, companyLocation)) {
				User user=(User) request.getSession().getAttribute("user");
				Long id=dbService.insert(SqlUtil.buildInsertSqlMap("company_info",
						new Object[][] { 
					{ "company_name", companyName },
					{ "company_id", companyId },
					{ "originator_id", user.getId() }, 
					{ "created_date", new Date() }, 
					{ "company_location", companyLocation },
					{ "detail_address", detailAddress },
					{"number_employee", numberEmployee }
				}));
				userService.joinCompany(user.getId(), id);
				res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
				res.put(Constant.RESPONSE_CODE_MSG, "，恭喜！创建门店成功");
			}else {
				res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
				res.put(Constant.RESPONSE_CODE_MSG, "很遗憾！创建门店失败，本地已存在同名门店，如有疑问可联系客服");
			}
		} catch (Exception e) {
			res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
			res.put(Constant.RESPONSE_CODE_MSG, "很遗憾！创建门店失败");
		}
		ServletUtils.writeToResponse(response, res);
	}
	
	@RequestMapping("/joincompany")
	public void joinCompany(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(name="joinCompanyId")Long companyId) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		try {
			User user=(User) request.getSession().getAttribute("user");
			userService.applyJoinCompany(user.getId(), companyId);
			res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
			res.put(Constant.RESPONSE_CODE_MSG, "，提交加入门店申请成功，请等待通过");
		} catch (Exception e) {
			res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
			res.put(Constant.RESPONSE_CODE_MSG, "申请失败，如有疑问请联系客服");
		}
		ServletUtils.writeToResponse(response, res);
	}
	@RequestMapping("/searchcompany")
	public void searchCompany(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(name="companyname")String companyname,
			@RequestParam(name="companylocation")String companylocation) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		try {
			HashMap<String, Object> param=new HashMap<String, Object>();
			param.put("companyName", companyname);
			param.put("companyLocation",companylocation);
			List<CompanyInfo> companylist=companyInfoMapper.ListMoreSelective(param);
			res.put(Constant.RESPONSE_CODE_MSG, Constant.SUCCEED_CODE_VALUE);
			res.put("size", companylist.size());
			res.put("data", companylist);
			
		} catch (Exception e) {
			res.put(Constant.RESPONSE_CODE_MSG, Constant.FAIL_CODE_VALUE);
		}
		ServletUtils.writeToResponse(response, res);
	}
}
