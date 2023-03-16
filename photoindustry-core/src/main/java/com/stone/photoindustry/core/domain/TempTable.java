package com.stone.photoindustry.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 门店申请加入表实体
 * 
 * @author stone
 * @version 1.0.0
 * @date 2021-10-24 14:14:36
 */
 public class TempTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /*** 主键Id*/
    private Long id;

    /*** 代码*/
    private String code;

    /*** 名称*/
    private String typename;

    /*** */
    private Integer dtail;

    /*** 物料全名*/
    private String goodsRename;

    /*** 助记码*/
    private String helpCode;

    /*** 规格型号*/
    private String size;

    /*** 物料属性*/
    private String opName;

    /*** 计量单位*/
    private String unit;

    /***  库存数量*/
    private String stock;

    /*** 来源*/
    private String supplier;

    /*** */
    private String goodsStroe;


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

    /*** 获取代码
    *
    * @return 代码
    */
    public String getCode(){
        return code;
    }

    /*** 设置代码
    * 
    * @param code 要设置的代码
    */
    public void setCode(String code){
        this.code = code;
    }

    /*** 获取名称
    *
    * @return 名称
    */
    public String getTypename(){
        return typename;
    }

    /*** 设置名称
    * 
    * @param typename 要设置的名称
    */
    public void setTypename(String typename){
        this.typename = typename;
    }

    /*** 获取
    *
    * @return 
    */
    public Integer getDtail(){
        return dtail;
    }

    /*** 设置
    * 
    * @param dtail 要设置的
    */
    public void setDtail(Integer dtail){
        this.dtail = dtail;
    }

    /*** 获取物料全名
    *
    * @return 物料全名
    */
    public String getGoodsRename(){
        return goodsRename;
    }

    /*** 设置物料全名
    * 
    * @param goodsRename 要设置的物料全名
    */
    public void setGoodsRename(String goodsRename){
        this.goodsRename = goodsRename;
    }

    /*** 获取助记码
    *
    * @return 助记码
    */
    public String getHelpCode(){
        return helpCode;
    }

    /*** 设置助记码
    * 
    * @param helpCode 要设置的助记码
    */
    public void setHelpCode(String helpCode){
        this.helpCode = helpCode;
    }

    /*** 获取规格型号
    *
    * @return 规格型号
    */
    public String getSize(){
        return size;
    }

    /*** 设置规格型号
    * 
    * @param size 要设置的规格型号
    */
    public void setSize(String size){
        this.size = size;
    }

    /*** 获取物料属性
    *
    * @return 物料属性
    */
    public String getOpName(){
        return opName;
    }

    /*** 设置物料属性
    * 
    * @param opName 要设置的物料属性
    */
    public void setOpName(String opName){
        this.opName = opName;
    }

    /*** 获取计量单位
    *
    * @return 计量单位
    */
    public String getUnit(){
        return unit;
    }

    /*** 设置计量单位
    * 
    * @param unit 要设置的计量单位
    */
    public void setUnit(String unit){
        this.unit = unit;
    }

    /*** 获取 库存数量
    *
    * @return  库存数量
    */
    public String getStock(){
        return stock;
    }

    /*** 设置 库存数量
    * 
    * @param stock 要设置的 库存数量
    */
    public void setStock(String stock){
        this.stock = stock;
    }

    /*** 获取来源
    *
    * @return 来源
    */
    public String getSupplier(){
        return supplier;
    }

    /*** 设置来源
    * 
    * @param supplier 要设置的来源
    */
    public void setSupplier(String supplier){
        this.supplier = supplier;
    }

    /*** 获取
    *
    * @return 
    */
    public String getGoodsStroe(){
        return goodsStroe;
    }

    /*** 设置
    * 
    * @param goodsStroe 要设置的
    */
    public void setGoodsStroe(String goodsStroe){
        this.goodsStroe = goodsStroe;
    }

}