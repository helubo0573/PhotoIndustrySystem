package com.stone.photoindustry.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 门店申请加入表实体
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-10-23 22:52:25
 */
 public class TempWj implements Serializable {

    private static final long serialVersionUID = 1L;

    /*** 主键Id*/
    private Long id;

    /*** */
    private String typeName;

    /*** */
    private String stone;

    /*** */
    private String supplier;

    /*** */
    private String goodsName;

    /*** */
    private String goodsSize;

    /*** */
    private String unit;

    /*** */
    private String price;

    /*** */
    private String amount;


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
    public String getTypeName(){
        return typeName;
    }

    /*** 设置
    * 
    * @param typeName 要设置的
    */
    public void setTypeName(String typeName){
        this.typeName = typeName;
    }

    /*** 获取
    *
    * @return 
    */
    public String getStone(){
        return stone;
    }

    /*** 设置
    * 
    * @param stone 要设置的
    */
    public void setStone(String stone){
        this.stone = stone;
    }

    /*** 获取
    *
    * @return 
    */
    public String getSupplier(){
        return supplier;
    }

    /*** 设置
    * 
    * @param supplier 要设置的
    */
    public void setSupplier(String supplier){
        this.supplier = supplier;
    }

    /*** 获取
    *
    * @return 
    */
    public String getGoodsName(){
        return goodsName;
    }

    /*** 设置
    * 
    * @param goodsName 要设置的
    */
    public void setGoodsName(String goodsName){
        this.goodsName = goodsName;
    }

    /*** 获取
    *
    * @return 
    */
    public String getGoodsSize(){
        return goodsSize;
    }

    /*** 设置
    * 
    * @param goodsSize 要设置的
    */
    public void setGoodsSize(String goodsSize){
        this.goodsSize = goodsSize;
    }

    /*** 获取
    *
    * @return 
    */
    public String getUnit(){
        return unit;
    }

    /*** 设置
    * 
    * @param unit 要设置的
    */
    public void setUnit(String unit){
        this.unit = unit;
    }

    /*** 获取
    *
    * @return 
    */
    public String getPrice(){
        return price;
    }

    /*** 设置
    * 
    * @param price 要设置的
    */
    public void setPrice(String price){
        this.price = price;
    }

    /*** 获取
    *
    * @return 
    */
    public String getAmount(){
        return amount;
    }

    /*** 设置
    * 
    * @param amount 要设置的
    */
    public void setAmount(String amount){
        this.amount = amount;
    }

}