package com.spring.webprj.domain;

import java.sql.Date;

public class ProductVo {

	/*PRODSEQ NUMBER,
	SELLERSEQ NUMBER,
	CATEGORY varchar2(50),
	PRODNAME varchar2(100),
	PRODINFORM varchar2(1000),
	PRICE number not null,
	DISCOUNT number DEFAULT 0,
	STOCK NUMBER DEFAULT 99999,
	SHIPPINGCHARGE NUMBER,
	REGDATE date default sysdate,
	UPDATEDATE date*/
	private int prodSeq;  //제품seq
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
	public int getProdSeq() {
		return prodSeq;
	}
	public void setProdSeq(int prodSeq) {
		this.prodSeq = prodSeq;
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
		return "ProductVo [prodSeq=" + prodSeq + ", sellerSeq=" + sellerSeq + ", category=" + category + ", prodName="
				+ prodName + ", prodInfo=" + prodInfo + ", price=" + price + ", discount=" + discount
				+ ", shippingCharge=" + shippingCharge + ", stockNumber=" + stockNumber + ", photoUrl=" + photoUrl
				+ ", regDate=" + regDate + ", updateDate=" + updateDate + "]";
	}
	
	
	
}
