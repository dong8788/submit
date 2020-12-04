package com.spring.webprj.service;

import java.util.List;

import com.spring.webprj.domain.CustomerVo;


public interface CustomerService {

	//고객정보 리스트를 가져오기 위한 기능
	public List<CustomerVo> selectAll();
	
	//고객정보 상세 조회 기능
	public CustomerVo select(String cusId);
	
	//고객 id 체크
	public int checkCusId(String cusId);
	
	//고객정보 탈퇴 기능
	public void delete(int cusSeq);
	
	//고객정보 생성기능
	public void insert(CustomerVo cus);
	
	//고객정보 수정 기능
	public void update(CustomerVo cus);
}
