package com.lfm.wms.model;
import java.util.Date;
public class DamageList {
	private Integer id; // 编号
	private String damageNumber; // 报损单号
	private Date damageDate; // 报损日期
	private Date bDamageDate; // 起始时间 搜索用到
	private Date eDamageDate; // 结束时间 搜索用到
	private Integer userId;
	private UserInfo user; // 操作用户
	private String remarks; // 备注

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDamageNumber() {
		return damageNumber;
	}

	public void setDamageNumber(String damageNumber) {
		this.damageNumber = damageNumber;
	}

	public Date getDamageDate() {
		return damageDate;
	}

	public void setDamageDate(Date damageDate) {
		this.damageDate = damageDate;
	}

	public Date getbDamageDate() {
		return bDamageDate;
	}

	public void setbDamageDate(Date bDamageDate) {
		this.bDamageDate = bDamageDate;
	}

	public Date geteDamageDate() {
		return eDamageDate;
	}

	public void seteDamageDate(Date eDamageDate) {
		this.eDamageDate = eDamageDate;
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
		return "DamageList{" +
				"id=" + id +
				", damageNumber='" + damageNumber + '\'' +
				", damageDate=" + damageDate +
				", bDamageDate=" + bDamageDate +
				", eDamageDate=" + eDamageDate +
				", userId=" + userId +
				", user=" + user +
				", remarks='" + remarks + '\'' +
				'}';
	}
}
