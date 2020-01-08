package com.lfm.wms.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author lfm
 * @date 2019/12/31 - 21:33
 */
public class PurchaseList2 {
    private Integer id; // 编号
    private String purchaseNumber; // 进货单号
    private String supplierId;
    private Supplier supplier; // 供应商
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate; // 进货日期
    private Date bPurchaseDate; // 起始时间 搜索用到
    private Date ePurchaseDate; // 结束时间 搜索用到
    private float amountPayable; // 应付金额
    private float amountPaid; // 实付金额
    private String remarks; // 备注
    private Integer state; // 交易状态 1 已付  2 未付
    private UserInfo user; // 操作用户
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplier() {
        return supplier.getName();
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getbPurchaseDate() {
        return bPurchaseDate;
    }

    public void setbPurchaseDate(Date bPurchaseDate) {
        this.bPurchaseDate = bPurchaseDate;
    }

    public Date getePurchaseDate() {
        return ePurchaseDate;
    }

    public void setePurchaseDate(Date ePurchaseDate) {
        this.ePurchaseDate = ePurchaseDate;
    }

    public float getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(float amountPayable) {
        this.amountPayable = amountPayable;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
