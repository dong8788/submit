package com.spring.webprj.service;

import java.util.List;

import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.ProductVo;



public interface ProductService {

	//판매자가 자신의 상품을 조회하여 Product 리스트를 가져오기 위한 기능
	public List<ProductVo> listBySellerSeq(int sellerSeq);
	
	//고객이 상품을 조회하는 기능
	public List<ProductVo> list(SearchVO search);
	
	//상품 list 수확인
	public int listCount(SearchVO search);
	
	//Product 상세 조회 기능
	public ProductVo getProd(int prodSeq);
	
	//Product 취소 기능
	public void delete(int prodSeq);
	
	//Product 생성기능
	public void insert(ProductVo prod);

	//Product 수정기능
	public void update(ProductVo prod);
	
}
