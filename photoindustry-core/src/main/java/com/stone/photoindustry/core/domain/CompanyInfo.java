package com.stone.photoindustry.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 门店(公司)信息表实体
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-07-16 21:45:32
 */
 public class CompanyInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /*** 主键Id*/
    private Long id;

    /*** 门店名称*/
    private String companyName;

    /*** 机构统一社会信用代码*/
    private String companyId;

    /*** 创始人(法人)用户id*/
    private Long originatorId;

    /*** 创建日期(系统内)*/
    private Date createdDate;

    /*** 在所地*/
    private String companyLocation;

    /*** 详细地址*/
    private String detailAddress;

    /*** 员工人数*/
    private Integer numberEmployee;


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

    /*** 获取门店名称
    *
    * @return 门店名称
    */
    public String getCompanyName(){
        return companyName;
    }

    /*** 设置门店名称
    * 
    * @param companyName 要设置的门店名称
    */
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    /*** 获取机构统一社会信用代码
    *
    * @return 机构统一社会信用代码
    */
    public String getCompanyId(){
        return companyId;
    }

    /*** 设置机构统一社会信用代码
    * 
    * @param companyId 要设置的机构统一社会信用代码
    */
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

    /*** 获取创始人(法人)用户id
    *
    * @return 创始人(法人)用户id
    */
    public Long getOriginatorId(){
        return originatorId;
    }

    /*** 设置创始人(法人)用户id
    * 
    * @param originatorId 要设置的创始人(法人)用户id
    */
    public void setOriginatorId(Long originatorId){
        this.originatorId = originatorId;
    }

    /*** 获取创建日期(系统内)
    *
    * @return 创建日期(系统内)
    */
    public Date getCreatedDate(){
        return createdDate;
    }

    /*** 设置创建日期(系统内)
    * 
    * @param createdDate 要设置的创建日期(系统内)
    */
    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }

    /*** 获取在所地
    *
    * @return 在所地
    */
    public String getCompanyLocation(){
        return companyLocation;
    }

    /*** 设置在所地
    * 
    * @param companyLocation 要设置的在所地
    */
    public void setCompanyLocation(String companyLocation){
        this.companyLocation = companyLocation;
    }

    /*** 获取详细地址
    *
    * @return 详细地址
    */
    public String getDetailAddress(){
        return detailAddress;
    }

    /*** 设置详细地址
    * 
    * @param detailAddress 要设置的详细地址
    */
    public void setDetailAddress(String detailAddress){
        this.detailAddress = detailAddress;
    }

    /*** 获取员工人数
    *
    * @return 员工人数
    */
    public Integer getNumberEmployee(){
        return numberEmployee;
    }

    /*** 设置员工人数
    * 
    * @param numberEmployee 要设置的员工人数
    */
    public void setNumberEmployee(Integer numberEmployee){
        this.numberEmployee = numberEmployee;
    }

}