package com.spring.webprj.persistence;

import java.util.List;

import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.CenQueryVo;


public interface CenQueryDao {
	
	//검색 조건에 맞는 목록보기(페이징 처리)
	public List<CenQueryVo> list(SearchVO search);  
	
	//페이징 처리 전 목록 전체 개수
	public int listCount(SearchVO search);
	
	//하나보기
	public CenQueryVo read(int req);  
	
	//입력
	public void insert(CenQueryVo dto);  
	
	//수정
	public void update(CenQueryVo dto);  
	
	//삭제
	public void delete(int cenQuerySeq);  

}
