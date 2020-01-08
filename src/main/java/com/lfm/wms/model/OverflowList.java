package com.lfm.wms.model;
import java.util.Date;

/**
 * 报溢单
 * @author java1234_小锋 老师
 *
 */

public class OverflowList {
	private Integer id; // 编号
	private String overflowNumber; // 报溢单号
	private Date overflowDate; // 报溢日期
	private Date bOverflowDate; // 起始时间 搜索用到
	private Date eOverflowDate; // 结束时间 搜索用到
	private Integer userId;
	private UserInfo user; // 操作用户
	private String remarks; // 备注

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOverflowNumber() {
		return overflowNumber;
	}

	public void setOverflowNumber(String overflowNumber) {
		this.overflowNumber = overflowNumber;
	}

	public Date getOverflowDate() {
		return overflowDate;
	}

	public void setOverflowDate(Date overflowDate) {
		this.overflowDate = overflowDate;
	}

	public Date getbOverflowDate() {
		return bOverflowDate;
	}

	public void setbOverflowDate(Date bOverflowDate) {
		this.bOverflowDate = bOverflowDate;
	}

	public Date geteOverflowDate() {
		return eOverflowDate;
	}

	public void seteOverflowDate(Date eOverflowDate) {
		this.eOverflowDate = eOverflowDate;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "OverflowList{" +
				"id=" + id +
				", overflowNumber='" + overflowNumber + '\'' +
				", overflowDate=" + overflowDate +
				", bOverflowDate=" + bOverflowDate +
				", eOverflowDate=" + eOverflowDate +
				", userId=" + userId +
				", user=" + user +
				", remarks='" + remarks + '\'' +
				'}';
	}
}
