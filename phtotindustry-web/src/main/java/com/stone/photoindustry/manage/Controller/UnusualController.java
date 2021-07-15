package com.stone.photoindustry.manage.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnusualController {

	@RequestMapping("404")
	public String ErrorPage(HttpServletResponse response, HttpServletRequest request) {

		System.out.println("404");
		return null;

	}
}
