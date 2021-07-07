package com.stone.photoindustry.manage.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main")
public class MainPageController {

	@RequestMapping("/homepage")
	public String MainPage(HttpServletRequest request,HttpServletResponse response) {
		
		return null;
		
	}
}
