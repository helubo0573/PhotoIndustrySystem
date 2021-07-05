package com.stone.photoindustry.manage.Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stone.photoindustry.core.common.util.ServletUtils;



@Controller
public class UserController {

	@RequestMapping("user/register")
	public void RegisterUser(HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException, IOException {
		
		ServletUtils.writeToResponse(response, 1);
	}
}
