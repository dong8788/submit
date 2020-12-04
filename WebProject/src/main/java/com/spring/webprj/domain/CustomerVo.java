package com.spring.webprj.domain;

import java.sql.Date;

public class CustomerVo {

	/*
	 * "CUSSEQ" number primary key, "CUSID" varchar2(50) NOT NULL, "PASSWORD" NUMBER
	 * NOT NULL, "NAME" varchar2(50) NOT NULL, "EMAIL" varchar2(50) NOT NULL,
	 * "PHONE" varchar2(50) NOT NULL, "JOINDATE" DATE DEFAULT SYSDATE
	 */
	
	private int cusSeq;
	private String cusId;
	private String password;
	private String name;
	private String email;
	private String phone;
	private Date joinDate;
	
	public int getCusSeq() {
		return cusSeq;
	}
	public void setCusSeq(int cusSeq) {
		this.cusSeq = cusSeq;
	}
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		return "CustomerVo [cusSeq=" + cusSeq + ", cusId=" + cusId + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", phone=" + phone + ", joinDate=" + joinDate + "]";
	}
	
	
}
