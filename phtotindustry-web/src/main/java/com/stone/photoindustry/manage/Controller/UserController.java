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



@Controller
public class UserController {

	@Resource
    protected DBService dbService;
	
	@Resource
	private UserService userservice;
	
	@RequestMapping("user/register")
	public void RegisterUser(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(name = "account")String account,
			@RequestParam(name="password")String password,
			@RequestParam(name="email")String email,
			@RequestParam(name="mobile")String mobile,
			@RequestParam(name="rename")String rename) throws UnsupportedEncodingException, IOException {
		Long userid=dbService.insert(SqlUtil.buildInsertSqlMap("User", new Object[][] {
			{"user_name",account},
			{"user_password",MD5.MD5Encode(password)},
			{"user_mobile",mobile},
			{"user_email",email},
			{"use_rename",rename},
			{"register_date",new Date()}
		}));
		HashMap<String, Object> res=new HashMap<String, Object>();
		if(userid!=null) {
			res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
			res.put(Constant.RESPONSE_CODE_MSG, "注册成功");
		}
		ServletUtils.writeToResponse(response, res);
	}
}
