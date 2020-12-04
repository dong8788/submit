package com.spring.webprj.domain;

import java.sql.Date;

public class NoticeVo {

//    "NOTICESEQ" number primary key,
//    "NOTICECATEGORY" varchar2(30),
//    "CONTENT" varchar2(1000),
//    "TITLE" varchar2(255),
//   "REGDATE" date default sysdate
	
	private int noticeSeq;
	private String noticeCategory;
	private String content;
	private String title;
	private Date regDate;
	private int readCount;
	
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getNoticeSeq() {
		return noticeSeq;
	}
	public void setNoticeSeq(int noticeSeq) {
		this.noticeSeq = noticeSeq;
	}
	public String getNoticeCategory() {
		return noticeCategory;
	}
	public void setNoticeCategory(String noticeCategory) {
		this.noticeCategory = noticeCategory;
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
	@Override
	public String toString() {
		return "NoticeVo [noticeSeq=" + noticeSeq + ", noticeCategory=" + noticeCategory + ", content=" + content
				+ ", title=" + title + ", regDate=" + regDate + "]";
	}
	
	
	
}
