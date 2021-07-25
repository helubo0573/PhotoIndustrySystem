package com.stone.photoindustry.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表实体
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-03 20:54:21
 */
 public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /*** 主键Id*/
    private Long id;

    /*** 用户名*/
    private String userName;

    /*** 用户密码*/
    private String userPassword;

    /*** 电话号码*/
    private String userMobile;

    /*** 用户邮箱*/
    private String userEmail;

    /*** 用户昵称*/
    private String userRename;
    
    /*** 所属公司ID*/
    private Long companyId;
    /*** */
    private Date registerDate;

    /*** */
    private Date loginTime;

    /*** 用户状态*/
    private Integer status;

    public User() {	}
    
    /**
     * 	用于新用户注册的实例
     * @param username
     * @param password
     * @param mobile
     * @param email
     */
    public User(String username,String password,String mobile,String email,String rename) {	
    	setUserName(username);
    	setUserPassword(password);
    	setUserMobile(mobile);
    	setUserEmail(email);
    	setUserName(rename);
    }

    /*** 获取主键Id
    *
    * @return id
    */
    public Long getId(){
        return id;
    }

    /*** 设置主键Id
    * 
    * @param 要设置的主键Id
    */
    public void setId(Long id){
        this.id = id;
    }

    /*** 获取用户名
    *
    * @return 用户名
    */
    public String getUserName(){
        return userName;
    }

    /*** 设置用户名
    * 
    * @param userName 要设置的用户名
    */
    public void setUserName(String userName){
        this.userName = userName;
    }

    /*** 获取用户密码
    *
    * @return 用户密码
    */
    public String getUserPassword(){
        return userPassword;
    }

    /*** 设置用户密码
    * 
    * @param userPassword 要设置的用户密码
    */
    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }

    /*** 获取电话号码
    *
    * @return 电话号码
    */
    public String getUserMobile(){
        return userMobile;
    }

    /*** 设置电话号码
    * 
    * @param userMobile 要设置的电话号码
    */
    public void setUserMobile(String userMobile){
        this.userMobile = userMobile;
    }

    /*** 获取用户邮箱
    *
    * @return 用户邮箱
    */
    public String getUserEmail(){
        return userEmail;
    }

    /*** 设置用户邮箱
    * 
    * @param userEmail 要设置的用户邮箱
    */
    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }

    /*** 获取
    *
    * @return 
    */
    public Date getRegisterDate(){
        return registerDate;
    }

    /*** 设置
    * 
    * @param registerDate 要设置的
    */
    public void setRegisterDate(Date registerDate){
        this.registerDate = registerDate;
    }

    /*** 获取
    *
    * @return 
    */
    public Date getLoginTime(){
        return loginTime;
    }

    /*** 设置
    * 
    * @param loginTime 要设置的
    */
    public void setLoginTime(Date loginTime){
        this.loginTime = loginTime;
    }

    /*** 获取用户状态
    *
    * @return 用户状态
    */
    public Integer getStatus(){
        return status;
    }

    /*** 设置用户状态
    * 
    * @param status 要设置的用户状态
    */
    public void setStatus(Integer status){
        this.status = status;
    }

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getUserRename() {
		return userRename;
	}

	public void setUserRename(String userRename) {
		this.userRename = userRename;
	}

}