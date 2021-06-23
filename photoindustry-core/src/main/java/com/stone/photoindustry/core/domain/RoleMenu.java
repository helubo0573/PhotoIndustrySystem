package com.stone.photoindustry.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色菜单映射表实体
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:30:59
 */
 public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /*** 主键Id*/
    private Long id;

    /*** 角色ID*/
    private Integer roleId;

    /*** 单菜ID*/
    private Integer menuId;

    /*** */
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

    /*** 获取单菜ID
    *
    * @return 单菜ID
    */
    public Integer getMenuId(){
        return menuId;
    }

    /*** 设置单菜ID
    * 
    * @param menuId 要设置的单菜ID
    */
    public void setMenuId(Integer menuId){
        this.menuId = menuId;
    }

    /*** 获取
    *
    * @return 
    */
    public String getCompanyId(){
        return companyId;
    }

    /*** 设置
    * 
    * @param companyId 要设置的
    */
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

}