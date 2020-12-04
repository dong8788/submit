package com.spring.webprj.domain;

import java.sql.Date;

public class FaqVo {
//    "FAQSEQ" number,
//    "FAQCATEGORY" varchar2(30),
//    "QUERY" varchar2(1000),
//    "REPLY" varchar2(1000),
//    "REGDATE" date default sysdate
	
	private int faqSeq;
	private String faqCategory;
	private String query;
	private String reply;
	private Date regDate;
	public int getFaqSeq() {
		return faqSeq;
	}
	public void setFaqSeq(int faqSeq) {
		this.faqSeq = faqSeq;
	}
	public String getFaqCategory() {
		return faqCategory;
	}
	public void setFaqCategory(String faqCategory) {
		this.faqCategory = faqCategory;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "FaqVo [faqSeq=" + faqSeq + ", faqCategory=" + faqCategory + ", query=" + query + ", reply=" + reply
				+ ", regDate=" + regDate + "]";
	}
	
}
