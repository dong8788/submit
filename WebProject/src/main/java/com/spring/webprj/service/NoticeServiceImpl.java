package com.spring.webprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.NoticeVo;
import com.spring.webprj.persistence.NoticeDao;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<NoticeVo> selectAll(SearchVO search) {
		return noticeDao.selectAll(search);
	}
	
	@Override
	public int listCount(SearchVO search) {
		return noticeDao.listCount(search);
	}

	@Override
	public NoticeVo selectBySeq(int noticeSeq) {
		return noticeDao.selectBySeq(noticeSeq);
	}

	@Override
	public void delete(int noticeSeq) {
		noticeDao.delete(noticeSeq);
	}

	@Override
	public void insert(NoticeVo notice) {
		noticeDao.insert(notice);
	}

	@Override
	public void update(NoticeVo notice) {
		noticeDao.update(notice);
	}

	@Override
	public void updateReadCount(int noticeSeq) {
		noticeDao.updateReadCount(noticeSeq);
	}

}
