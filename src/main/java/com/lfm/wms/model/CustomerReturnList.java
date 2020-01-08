package com.lfm.wms.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import java.beans.Transient;
import java.util.Date;
import java.util.List;



public class CustomerReturnList {
	private Integer id; // 编号
	private String customerReturnNumber; // 客户退货单号
	private Integer customerId;
	private Customer customer; // 客户
	private Date customerReturnDate; // 客户退货日期
	private Date bCustomerReturnDate; // 起始时间 搜索用到
	private Date eCustomerReturnDate; // 结束时间 搜索用到
	private float amountPayable; // 应付金额
	private float amountPaid; // 实付金额
	private Integer state; // 交易状态 1 已付  2 未付
	private Integer userId;
	private UserInfo user; // 操作用户
	private String remarks; // 备注
	private Integer customerReturnListGoodsId;
	private List<CustomerReturnListGoods> customerReturnListGoodsList=null; // 客户退货单商品集合

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerReturnNumber() {
		return customerReturnNumber;
	}

	public void setCustomerReturnNumber(String customerReturnNumber) {
		this.customerReturnNumber = customerReturnNumber;
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

	public Date getCustomerReturnDate() {
		return customerReturnDate;
	}

	public void setCustomerReturnDate(Date customerReturnDate) {
		this.customerReturnDate = customerReturnDate;
	}

	public Date getbCustomerReturnDate() {
		return bCustomerReturnDate;
	}

	public void setbCustomerReturnDate(Date bCustomerReturnDate) {
		this.bCustomerReturnDate = bCustomerReturnDate;
	}

	public Date geteCustomerReturnDate() {
		return eCustomerReturnDate;
	}

	public void seteCustomerReturnDate(Date eCustomerReturnDate) {
		this.eCustomerReturnDate = eCustomerReturnDate;
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

	public Integer getCustomerReturnListGoodsId() {
		return customerReturnListGoodsId;
	}

	public void setCustomerReturnListGoodsId(Integer customerReturnListGoodsId) {
		this.customerReturnListGoodsId = customerReturnListGoodsId;
	}

	public List<CustomerReturnListGoods> getCustomerReturnListGoodsList() {
		return customerReturnListGoodsList;
	}

	public void setCustomerReturnListGoodsList(List<CustomerReturnListGoods> customerReturnListGoodsList) {
		this.customerReturnListGoodsList = customerReturnListGoodsList;
	}

	@Override
	public String toString() {
		return "CustomerReturnList{" +
				"id=" + id +
				", customerReturnNumber='" + customerReturnNumber + '\'' +
				", customerId=" + customerId +
				", customer=" + customer +
				", customerReturnDate=" + customerReturnDate +
				", bCustomerReturnDate=" + bCustomerReturnDate +
				", eCustomerReturnDate=" + eCustomerReturnDate +
				", amountPayable=" + amountPayable +
				", amountPaid=" + amountPaid +
				", state=" + state +
				", userId=" + userId +
				", user=" + user +
				", remarks='" + remarks + '\'' +
				", customerReturnListGoodsId=" + customerReturnListGoodsId +
				", customerReturnListGoodsList=" + customerReturnListGoodsList +
				'}';
	}
}
