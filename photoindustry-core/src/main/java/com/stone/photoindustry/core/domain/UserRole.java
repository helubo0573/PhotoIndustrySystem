package com.stone.photoindustry.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色映射表实体
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:31:39
 */
 public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /*** 主键Id*/
    private Long id;

    /*** 用户ID*/
    private Integer userId;

    /*** 角色ID*/
    private Integer roleId;

    /*** 公司ID*/
    private String companyId;


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

    /*** 获取用户ID
    *
    * @return 用户ID
    */
    public Integer getUserId(){
        return userId;
    }

    /*** 设置用户ID
    * 
    * @param userId 要设置的用户ID
    */
    public void setUserId(Integer userId){
        this.userId = userId;
    }

    /*** 获取角色ID
    *
    * @return 角色ID
    */
    public Integer getRoleId(){
        return roleId;
    }

    /*** 设置角色ID
    * 
    * @param roleId 要设置的角色ID
    */
    public void setRoleId(Integer roleId){
        this.roleId = roleId;
    }

    /*** 获取公司ID
    *
    * @return 公司ID
    */
    public String getCompanyId(){
        return companyId;
    }

    /*** 设置公司ID
    * 
    * @param companyId 要设置的公司ID
    */
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

}