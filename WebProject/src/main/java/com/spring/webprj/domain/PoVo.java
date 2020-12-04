package com.spring.webprj.domain;

import java.sql.Date;

public class PoVo {

	private int poNum;
	private int cusSeq;
	private int prodSeq;
	private int poQuantity;
	private String payNum;
	private String recipient;
	private String recipientPhone;
	private String recipientAddr;
	private String shipMemo;
	private String courier;
	private String shippingNum;
	private String poStat;
	private int billingAmount;
	private Date orderDate;
	private Date confirmDate;
	private Date shipDate;
	private Date recipientDate;
	private Date fconfirmDate;
	private Date RejectDate;
	private String payMethod;
	public PoVo() {
		// TODO Auto-generated constructor stub
	}
	public int getPoNum() {
		return poNum;
	}
	public void setPoNum(int poNum) {
		this.poNum = poNum;
	}
	public int getCusSeq() {
		return cusSeq;
	}
	public void setCusSeq(int cusSeq) {
		this.cusSeq = cusSeq;
	}
	public int getProdSeq() {
		return prodSeq;
	}
	public void setProdSeq(int prodSeq) {
		this.prodSeq = prodSeq;
	}
	public int getPoQuantity() {
		return poQuantity;
	}
	public void setPoQuantity(int poQuantity) {
		this.poQuantity = poQuantity;
	}
	public String getPayNum() {
		return payNum;
	}
	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getRecipientPhone() {
		return recipientPhone;
	}
	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}
	public String getRecipientAddr() {
		return recipientAddr;
	}
	public void setRecipientAddr(String recipientAddr) {
		this.recipientAddr = recipientAddr;
	}
	public String getShipMemo() {
		return shipMemo;
	}
	public void setShipMemo(String shipMemo) {
		this.shipMemo = shipMemo;
	}
	public String getCourier() {
		return courier;
	}
	public void setCourier(String courier) {
		this.courier = courier;
	}
	public String getShippingNum() {
		return shippingNum;
	}
	public void setShippingNum(String shippingNum) {
		this.shippingNum = shippingNum;
	}
	public String getPoStat() {
		return poStat;
	}
	public void setPoStat(String poStat) {
		this.poStat = poStat;
	}
	public int getBillingAmount() {
		return billingAmount;
	}
	public void setBillingAmount(int billingAmount) {
		this.billingAmount = billingAmount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	public Date getRecipientDate() {
		return recipientDate;
	}
	public void setRecipientDate(Date recipientDate) {
		this.recipientDate = recipientDate;
	}
	public Date getFconfirmDate() {
		return fconfirmDate;
	}
	public void setFconfirmDate(Date fconfirmDate) {
		this.fconfirmDate = fconfirmDate;
	}
	public Date getRejectDate() {
		return RejectDate;
	}
	public void setRejectDate(Date rejectDate) {
		RejectDate = rejectDate;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	@Override
	public String toString() {
		return "PoVo [poNum=" + poNum + ", cusSeq=" + cusSeq + ", prodSeq=" + prodSeq + ", poQuantity=" + poQuantity
				+ ", payNum=" + payNum + ", recipient=" + recipient + ", recipientPhone=" + recipientPhone
				+ ", recipientAddr=" + recipientAddr + ", shipMemo=" + shipMemo + ", courier=" + courier
				+ ", shippingNum=" + shippingNum + ", poStat=" + poStat + ", billingAmount=" + billingAmount
				+ ", orderDate=" + orderDate + ", confirmDate=" + confirmDate + ", shipDate=" + shipDate
				+ ", recipientDate=" + recipientDate + ", fconfirmDate=" + fconfirmDate + ", RejectDate=" + RejectDate
				+ ", payMethod=" + payMethod + "]";
	}

	
	
}
