package com.stone.photoindustry.manage.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stone.photoindustry.core.common.constant.PathConstant;
import com.stone.photoindustry.core.model.UserModel;
import com.stone.photoindustry.core.service.UserDetailService;

@Controller
@RequestMapping("main")
public class MainPageController {

	@Resource
	private UserDetailService userDetailService;
	
	@RequestMapping("/homepage")
	public String MainPage(HttpServletRequest request,HttpServletResponse response) {
		UserModel userinfo=(UserModel) request.getSession().getAttribute("user");
		System.out.println(userinfo+"----test");
		if(userDetailService.getDetailByUserId(userinfo.getId())!=null) {
			return PathConstant.FrameMainPage;
		}else {
			return PathConstant.DetailInfoPage;
		}
		
	}
}
