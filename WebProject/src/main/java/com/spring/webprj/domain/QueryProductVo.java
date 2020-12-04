package com.spring.webprj.domain;

import java.sql.Date;

public class QueryProductVo {

	private int querySeq;
	private String open;
	private int prodSeq;
	private String title;
	private String content;
	private Date qregDate;
	private String reply;
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
	public int getQuerySeq() {
		return querySeq;
	}
	public void setQuerySeq(int querySeq) {
		this.querySeq = querySeq;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public int getProdSeq() {
		return prodSeq;
	}
	public void setProdSeq(int prodSeq) {
		this.prodSeq = prodSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getQregDate() {
		return qregDate;
	}
	public void setQregDate(Date qregDate) {
		this.qregDate = qregDate;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
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
		return "QueryProductVo [querySeq=" + querySeq + ", open=" + open + ", prodSeq=" + prodSeq + ", title=" + title
				+ ", content=" + content + ", qregDate=" + qregDate + ", reply=" + reply + ", sellerSeq=" + sellerSeq
				+ ", category=" + category + ", prodName=" + prodName + ", prodInfo=" + prodInfo + ", price=" + price
				+ ", discount=" + discount + ", shippingCharge=" + shippingCharge + ", stockNumber=" + stockNumber
				+ ", photoUrl=" + photoUrl + ", regDate=" + regDate + ", updateDate=" + updateDate + "]";
	}
	
}
