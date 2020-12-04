package com.spring.webprj.service;

import java.util.List;

import com.spring.webprj.domain.SellerVo;

public interface SellerService {

	//seller 아이디 중복확인
	public int sellerIdChk(SellerVo vo) throws Exception;
	
	//Seller 리스트를 가져오기 위한 기능
	public List<SellerVo> selectAll();
	
	//Seller 상세 조회 기능
	public SellerVo select(String id);
	
	//Seller id 체크 기능
	public int checkSellerId(String id);
	
	//Seller 취소 기능
	public void delete(int sellerSeq);
	
	//Seller 생성기능
	public void insert(SellerVo seller);
}
