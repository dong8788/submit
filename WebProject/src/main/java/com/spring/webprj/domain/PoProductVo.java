package com.spring.webprj.domain;

import java.sql.Date;

public class PoProductVo {
	
	//구매 정보
	private int poNum;
	private int cusSeq;
	private int prodSeq;
	private int poQuantity;
	private int payNum;
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
	//상품
	private int sellerSeq;  //판매자seq
	
	private String category;  //카테고리
	private String prodName;  //제품명
	private String prodInfo;  //제품정보
	private int price;  //가격
	private int discount;  //할인가격
	private int shippingCharge;  //배송비
	private int stockNumber;  //재고
	private String photoUrl; //상품 이미지 경로
	private Date regDate;  //등록일
	private Date updateDate;  //수정일
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
	public int getPayNum() {
		return payNum;
	}
	public void setPayNum(int payNum) {
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
	public int getSellerSeq() {
		return sellerSeq;
	}
	public void setSellerSeq(int sellerSeq) {
		this.sellerSeq = sellerSeq;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdInfo() {
		return prodInfo;
	}
	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getShippingCharge() {
		return shippingCharge;
	}
	public void setShippingCharge(int shippingCharge) {
		this.shippingCharge = shippingCharge;
	}
	public int getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "PoProductVo [poNum=" + poNum + ", cusSeq=" + cusSeq + ", prodSeq=" + prodSeq + ", poQuantity="
				+ poQuantity + ", payNum=" + payNum + ", recipient=" + recipient + ", recipientPhone=" + recipientPhone
				+ ", recipientAddr=" + recipientAddr + ", shipMemo=" + shipMemo + ", courier=" + courier
				+ ", shippingNum=" + shippingNum + ", poStat=" + poStat + ", billingAmount=" + billingAmount
				+ ", orderDate=" + orderDate + ", confirmDate=" + confirmDate + ", shipDate=" + shipDate
				+ ", recipientDate=" + recipientDate + ", fconfirmDate=" + fconfirmDate + ", RejectDate=" + RejectDate
				+ ", payMethod=" + payMethod + ", sellerSeq=" + sellerSeq + ", category=" + category + ", prodName="
				+ prodName + ", prodInfo=" + prodInfo + ", price=" + price + ", discount=" + discount
				+ ", shippingCharge=" + shippingCharge + ", stockNumber=" + stockNumber + ", photoUrl=" + photoUrl
				+ ", regDate=" + regDate + ", updateDate=" + updateDate + "]";
	}

	
	
}
