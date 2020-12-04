package com.spring.webprj.domain;

import java.util.Date;

public class UserCenQueryVo {

	private int cenQuerySeq;  //글번호
	
	private String open; //비공개여부
	private String queryType; //문의분류
	private int cusSeq; //회원아이디
	private int sellerSeq; //회원아이디
	
//	@NotEmpty(message = "내용을 작성해야 합니다.")
	private String content; //글내용
	
//	@NotEmpty(message = "제목을 작성해야 합니다.")
	private String title; //글제목
	private Date regDate; //작성일
	private String reply; //답변
	
	//고객정보
	private String cusId;

	
	//판매자 정보
	private String businessName;
	private String id;
	public int getCenQuerySeq() {
		return cenQuerySeq;
	}
	public void setCenQuerySeq(int cenQuerySeq) {
		this.cenQuerySeq = cenQuerySeq;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	public int getCusSeq() {
		return cusSeq;
	}
	public void setCusSeq(int cusSeq) {
		this.cusSeq = cusSeq;
	}
	public int getSellerSeq() {
		return sellerSeq;
	}
	public void setSellerSeq(int sellerSeq) {
		this.sellerSeq = sellerSeq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CusCenQueryVo [cenQuerySeq=" + cenQuerySeq + ", open=" + open + ", queryType=" + queryType + ", cusSeq="
				+ cusSeq + ", sellerSeq=" + sellerSeq + ", content=" + content + ", title=" + title + ", regDate="
				+ regDate + ", reply=" + reply + ", cusId=" + cusId + ", businessName=" + businessName + ", id=" + id
				+ "]";
	}
	
	
	
	
}
