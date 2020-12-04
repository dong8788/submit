package com.spring.webprj.domain;

import java.sql.Date;

public class SellerVo {
	   
	
	private int sellerSeq;
	private String businessName;
	private String name;
	private String phone;
	private String addr;
	private String email;
	private String id;
	private String password;
	private Date joinDate;
	private String businessNum;
	public int getSellerSeq() {
		return sellerSeq;
	}
	public void setSellerSeq(int sellerSeq) {
		this.sellerSeq = sellerSeq;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getBusinessNum() {
		return businessNum;
	}
	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}
	@Override
	public String toString() {
		return "SellerVo [sellerSeq=" + sellerSeq + ", businessName=" + businessName + ", name=" + name + ", phone="
				+ phone + ", addr=" + addr + ", email=" + email + ", id=" + id + ", password=" + password
				+ ", joinDate=" + joinDate + ", businessNum=" + businessNum + "]";
	}   

}
