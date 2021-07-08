package com.stone.photoindustry.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户详细信息表实体
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-07-08 10:52:16
 */
 public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /*** 主键Id*/
    private Long id;

    /*** */
    private Long userId;

    /*** 性别 0 女 1 男*/
    private Integer userSex;

    /*** 用户的真实姓名*/
    private String userName;

    /*** 所在地*/
    private String userLocation;

    /*** 身份证号码*/
    private String userIdNumber;


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

    /*** 获取
    *
    * @return 
    */
    public Long getUserId(){
        return userId;
    }

    /*** 设置
    * 
    * @param userId 要设置的
    */
    public void setUserId(Long userId){
        this.userId = userId;
    }

    /*** 获取性别 0 女 1 男
    *
    * @return 性别 0 女 1 男
    */
    public Integer getUserSex(){
        return userSex;
    }

    /*** 设置性别 0 女 1 男
    * 
    * @param userSex 要设置的性别 0 女 1 男
    */
    public void setUserSex(Integer userSex){
        this.userSex = userSex;
    }

    /*** 获取用户的真实姓名
    *
    * @return 用户的真实姓名
    */
    public String getUserName(){
        return userName;
    }

    /*** 设置用户的真实姓名
    * 
    * @param userName 要设置的用户的真实姓名
    */
    public void setUserName(String userName){
        this.userName = userName;
    }

    /*** 获取所在地
    *
    * @return 所在地
    */
    public String getUserLocation(){
        return userLocation;
    }

    /*** 设置所在地
    * 
    * @param userLocation 要设置的所在地
    */
    public void setUserLocation(String userLocation){
        this.userLocation = userLocation;
    }

    /*** 获取身份证号码
    *
    * @return 身份证号码
    */
    public String getUserIdNumber(){
        return userIdNumber;
    }

    /*** 设置身份证号码
    * 
    * @param userIdNumber 要设置的身份证号码
    */
    public void setUserIdNumber(String userIdNumber){
        this.userIdNumber = userIdNumber;
    }

}