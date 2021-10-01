package com.stone.photoindustry.core.common.constant;

public class PathConstant {

	/**登录成功后进入主页面**/
	public static final String FrameMainPage="forward:/WEB-INF/jsp/Frame/Main.jsp";					//主页面
	/**工作台**/
	public static final String FrameWorkbenchPage="forward:/WEB-INF/jsp/Frame/Workbench.jsp";								//首页
	
	
	public static final String RoleManagePage="/WEB-INF/jsp/SystemManage/RoleManage/Manage.jsp";	//角色管理
	/***异常页面**/
	public static final String ErrorPage="forward:/404.jsp";										//请求错误页面
	public static final String DetailInfoPage="forward:/WEB-INF/jsp/OtherFlow/DetailInfo.jsp";			//检测到没有详细信息，进入详细信息完善页面
	public static final String InitCompanyPage="forward:/WEB-INF/jsp/OtherFlow/InitCompany.jsp";		//所属摄影机构选择界面
}
