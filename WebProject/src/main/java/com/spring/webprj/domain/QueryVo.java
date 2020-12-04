package com.spring.webprj.domain;

import java.sql.Date;

public class QueryVo {

	private int querySeq;
	private String open;
	private int prodSeq;
	private int cusSeq;
	private String title;
	private String content;
	private Date qregDate;
	private String reply;
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
	public int getCusSeq() {
		return cusSeq;
	}
	public void setCusSeq(int cusSeq) {
		this.cusSeq = cusSeq;
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
	@Override
	public String toString() {
		return "QueryVo [querySeq=" + querySeq + ", open=" + open + ", prodSeq=" + prodSeq + ", cusSeq=" + cusSeq
				+ ", title=" + title + ", content=" + content + ", qregDate=" + qregDate + ", reply=" + reply + "]";
	}

	
	
	
		
}
