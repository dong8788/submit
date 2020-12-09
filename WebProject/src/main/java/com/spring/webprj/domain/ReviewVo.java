package com.spring.webprj.domain;

import java.util.Date;

public class ReviewVo {

	private int reviewSeq;
	private int prodSeq;
	private int cusSeq;
	private int score;
	private String title;
	private String content;
	private Date regDate;
	
	public int getReviewSeq() {
		return reviewSeq;
	}
	public void setReviewSeq(int reviewSeq) {
		this.reviewSeq = reviewSeq;
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
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "ReviewVo [reviewSeq=" + reviewSeq + ", prodSeq=" + prodSeq + ", cusSeq=" + cusSeq + ", title=" + title
				+ ", content=" + content + ", regDate=" + regDate + "]";
	}
	
		
	
}
