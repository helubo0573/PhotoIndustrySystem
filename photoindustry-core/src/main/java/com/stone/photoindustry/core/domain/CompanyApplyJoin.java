package com.stone.photoindustry.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 门店申请加入表实体
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-07-22 20:33:10
 */
 public class CompanyApplyJoin implements Serializable {

    private static final long serialVersionUID = 1L;

    /*** 主键Id*/
    private Long id;

    /*** 店门id*/
    private Long companyId;

    /*** 申请用户id*/
    private Long userId;

    /*** 申请时间*/
    private Date applyDate;

    /*** 申请状态 0：新申请 1：通过 2：未通过*/
    private Integer applyStatus;


    public CompanyApplyJoin() {
    	
    }
    public CompanyApplyJoin(Long id,Long companyid,Long userid,Date applyDate,int applystatus) {
    	if(id!=null) this.setId(id);
    	if(companyid!=null) this.setCompanyId(companyid);
    	if(userid!=null) this.setUserId(userid);
    	if(applyDate!=null) this.setApplyDate(applyDate);
    	if(applystatus>0) this.setApplyStatus(applyStatus);
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

    /*** 获取店门id
    *
    * @return 店门id
    */
    public Long getCompanyId(){
        return companyId;
    }

    /*** 设置店门id
    * 
    * @param companyId 要设置的店门id
    */
    public void setCompanyId(Long companyId){
        this.companyId = companyId;
    }

    /*** 获取申请用户id
    *
    * @return 申请用户id
    */
    public Long getUserId(){
        return userId;
    }

    /*** 设置申请用户id
    * 
    * @param userId 要设置的申请用户id
    */
    public void setUserId(Long userId){
        this.userId = userId;
    }

    /*** 获取申请时间
    *
    * @return 申请时间
    */
    public Date getApplyDate(){
        return applyDate;
    }

    /*** 设置申请时间
    * 
    * @param applyDate 要设置的申请时间
    */
    public void setApplyDate(Date applyDate){
        this.applyDate = applyDate;
    }

    /*** 获取申请状态 0：新申请 1：通过 2：未通过
    *
    * @return 申请状态 0：新申请 1：通过 2：未通过
    */
    public Integer getApplyStatus(){
        return applyStatus;
    }

    /*** 设置申请状态 0：新申请 1：通过 2：未通过
    * 
    * @param applyStatus 要设置的申请状态 0：新申请 1：通过 2：未通过
    */
    public void setApplyStatus(Integer applyStatus){
        this.applyStatus = applyStatus;
    }

}