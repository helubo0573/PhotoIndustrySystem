package com.stone.photoindustry.manage.Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stone.photoindustry.core.common.util.ServletUtils;
import com.stone.photoindustry.core.domain.SysMenu;
import com.stone.photoindustry.core.model.UserModel;
import com.stone.photoindustry.core.service.SysMenuService;

@Controller
public class SysMenuController {

	@Resource
	private SysMenuService sysMenuService;
	
	@RequestMapping("menu/getmenu")
	public void getmenu(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		UserModel user = (UserModel) request.getSession().getAttribute("user");
		List<SysMenu> menu=sysMenuService.getMunuByUser(user);
		ServletUtils.writeToResponse(response, menu);
	}
}
