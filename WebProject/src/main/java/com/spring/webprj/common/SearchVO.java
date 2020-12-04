package com.spring.webprj.common;

public class SearchVO extends Criteria{
	
	private String keyword;
	private String condition;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public SearchVO() {
		this.keyword = "";
		this.condition = "";
	}
	
}
