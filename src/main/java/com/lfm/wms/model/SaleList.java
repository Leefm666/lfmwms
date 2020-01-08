package com.lfm.wms.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import java.beans.Transient;
import java.util.Date;
import java.util.List;


public class SaleList {
	private Integer id; // 编号
	private String saleNumber; // 销售单号
	private Integer customerId;
	private Customer customer; // 客户
	private Date saleDate; // 销售日期
	private Date bSaleDate; // 起始时间 搜索用到
	private Date eSaleDate; // 结束时间 搜索用到
	private float amountPayable; // 应付金额
	private float amountPaid; // 实付金额
	private Integer state; // 交易状态 1 已付  2 未付
	private List<SaleListGoods> saleListGoodsList=null; // 销售单商品集合
	private Integer userId;
	private UserInfo user; // 操作用户
	private String remarks; // 备注

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSaleNumber() {
		return saleNumber;
	}

	public void setSaleNumber(String saleNumber) {
		this.saleNumber = saleNumber;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Date getbSaleDate() {
		return bSaleDate;
	}

	public void setbSaleDate(Date bSaleDate) {
		this.bSaleDate = bSaleDate;
	}

	public Date geteSaleDate() {
		return eSaleDate;
	}

	public void seteSaleDate(Date eSaleDate) {
		this.eSaleDate = eSaleDate;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public List<SaleListGoods> getSaleListGoodsList() {
		return saleListGoodsList;
	}

	public void setSaleListGoodsList(List<SaleListGoods> saleListGoodsList) {
		this.saleListGoodsList = saleListGoodsList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "SaleList{" +
				"id=" + id +
				", saleNumber='" + saleNumber + '\'' +
				", customerId=" + customerId +
				", customer=" + customer +
				", saleDate=" + saleDate +
				", bSaleDate=" + bSaleDate +
				", eSaleDate=" + eSaleDate +
				", amountPayable=" + amountPayable +
				", amountPaid=" + amountPaid +
				", state=" + state +
				", saleListGoodsList=" + saleListGoodsList +
				", userId=" + userId +
				", user=" + user +
				", remarks='" + remarks + '\'' +
				'}';
	}
}
