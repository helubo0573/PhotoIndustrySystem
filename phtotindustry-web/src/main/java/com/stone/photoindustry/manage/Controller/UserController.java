package com.stone.photoindustry.manage.Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stone.photoindustry.core.common.constant.Constant;
import com.stone.photoindustry.core.common.util.DBService;
import com.stone.photoindustry.core.common.util.MD5;
import com.stone.photoindustry.core.common.util.ServletUtils;
import com.stone.photoindustry.core.common.util.SqlUtil;
import com.stone.photoindustry.core.domain.User;
import com.stone.photoindustry.core.service.UserService;
import com.stone.photoindustry.core.system.security.PasswordEncoder;

@Controller
@RequestMapping("user")
public class UserController {

	@Resource
	protected DBService dbService;

	@Resource
	private UserService userservice;

	@Resource
	private PasswordEncoder passwordEncoder;// 密码加密

	@RequestMapping("/register")
	public void RegisterUser(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(name = "account") String account, @RequestParam(name = "password") String password,
			@RequestParam(name = "email") String email, @RequestParam(name = "mobile") String mobile,
			@RequestParam(name = "rename") String rename) throws UnsupportedEncodingException, IOException {
		Long userid = dbService.insert(SqlUtil.buildInsertSqlMap("User",
				new Object[][] { { "user_name", account },
						{ "user_password", passwordEncoder.encodePassword(String.valueOf(MD5.MD5Encode(password))) },
						{ "user_mobile", mobile }, { "user_email", email }, { "user_rename", rename },
						{ "register_date", new Date() } }));
		HashMap<String, Object> res = new HashMap<String, Object>();
		if (userid != null) {
			res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
			res.put(Constant.RESPONSE_CODE_MSG, "注册成功");
		}
		ServletUtils.writeToResponse(response, res);
	}
	
	@RequestMapping("/detail")
	public void UserDetail(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(name="sex")boolean sex,
			@RequestParam(name="autonym")String autonym,
			@RequestParam(name="location")String location,
			@RequestParam(name="idNumber")String idNumber) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		try {
			User user=(User) request.getSession().getAttribute("user");
			dbService.insert(SqlUtil.buildInsertSqlMap("user_detail",
					new Object[][] { { "user_id", user.getId() },{ "user_sex", sex },{ "user_name", autonym }, { "user_location", location }, { "user_id_number", idNumber }}));
			res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
			res.put(Constant.RESPONSE_CODE_MSG, "信息保存成功");
		} catch (Exception e) {
			res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
			res.put(Constant.RESPONSE_CODE_MSG, "信息保存失败");
		}
		ServletUtils.writeToResponse(response, res);
	}
}
