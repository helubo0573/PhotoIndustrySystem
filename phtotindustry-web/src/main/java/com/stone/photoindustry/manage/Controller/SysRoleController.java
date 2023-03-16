package com.stone.photoindustry.manage.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stone.photoindustry.core.common.constant.PathConstant;
import com.stone.photoindustry.core.service.TempWjService;

@Controller
public class SysRoleController {
	
	@Resource
	private TempWjService tempWjService;

	/*
	 * @RequestMapping("system/temprun") public String RolePage(HttpServletResponse
	 * response, HttpServletRequest request) {
	 * 
	 * return PathConstant.RoleManagePage; }
	 */

	@RequestMapping("system/RoleManage")
	public String temprun(HttpServletResponse response, HttpServletRequest request) {
		
		return PathConstant.RoleManagePage;
	}
}
