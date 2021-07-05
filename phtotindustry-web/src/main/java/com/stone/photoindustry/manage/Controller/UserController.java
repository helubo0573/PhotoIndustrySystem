package com.stone.photoindustry.manage.Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stone.photoindustry.core.common.util.ServletUtils;
import com.stone.photoindustry.core.service.UserService;



@Controller
public class UserController {

	@Resource
	private UserService userservice;
	
	@RequestMapping("user/register")
	public void RegisterUser(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(name = "account")String account,
			@RequestParam(name="password")String password,
			@RequestParam(name="email")String email,
			@RequestParam(name="mobile")String mobile,
			@RequestParam(name="rename")String rename) throws UnsupportedEncodingException, IOException {
		userservice.insert(record)
		ServletUtils.writeToResponse(response, 1);
	}
}
