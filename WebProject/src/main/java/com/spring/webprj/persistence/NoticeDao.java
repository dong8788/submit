package com.spring.webprj.persistence;

import java.util.List;

import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.NoticeVo;

public interface NoticeDao {

	//공지사항 리스트를 가져오기 위한 기능
	public List<NoticeVo> selectAll(SearchVO search);

	//페이징 처리 전 목록 전체 개수
	public int listCount(SearchVO search);
	
	//공지사항 상세 조회 기능
	public NoticeVo selectBySeq(int noticeSeq);
	
	//공지사항 삭제 기능
	public void delete(int noticeSeq);
	
	//공지사항 생성 기능
	public void insert(NoticeVo notice);
	
	//공지사항 수정 기능
	public void update(NoticeVo notice);
	
	//공지사항 조회수 갱신 기능
	public void updateReadCount(int noticeSeq);
}
