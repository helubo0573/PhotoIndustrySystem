package com.stone.photoindustry.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表实体
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-06-23 22:26:47
 */
 public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /*** 主键Id*/
    private Long id;

    /*** */
    private String companyId;

    /*** 所属部门id*/
    private Integer deptId;

    /*** 角色名称*/
    private String roleName;

    /*** */
    private String remarks;


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

    /*** 获取所属部门id
    *
    * @return 所属部门id
    */
    public Integer getDeptId(){
        return deptId;
    }

    /*** 设置所属部门id
    * 
    * @param deptId 要设置的所属部门id
    */
    public void setDeptId(Integer deptId){
        this.deptId = deptId;
    }

    /*** 获取角色名称
    *
    * @return 角色名称
    */
    public String getRoleName(){
        return roleName;
    }

    /*** 设置角色名称
    * 
    * @param roleName 要设置的角色名称
    */
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    /*** 获取
    *
    * @return 
    */
    public String getRemarks(){
        return remarks;
    }

    /*** 设置
    * 
    * @param remarks 要设置的
    */
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

}