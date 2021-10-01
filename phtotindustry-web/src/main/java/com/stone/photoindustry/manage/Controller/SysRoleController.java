package com.stone.photoindustry.manage.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stone.photoindustry.core.common.constant.PathConstant;

@Controller
public class SysRoleController {
	
	@RequestMapping("system/RoleManage")
	public String RolePage(HttpServletResponse response, HttpServletRequest request) {
		
		return PathConstant.RoleManagePage;
	}

}
