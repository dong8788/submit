package com.spring.webprj.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.NoticeVo;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<NoticeVo> selectAll(SearchVO search) {
		System.out.println("전체 리스트 불러오기");
		return sqlSessionTemplate.selectList("NoticeDao.selectAll", search);
	}
	
	@Override
	public int listCount(SearchVO search) {
		return sqlSessionTemplate.selectOne("NoticeDao.listCount", search);
	}

	@Override
	public NoticeVo selectBySeq(int noticeSeq) {
		return sqlSessionTemplate.selectOne("NoticeDao.selectBySeq", noticeSeq);
	}

	@Override
	public void delete(int noticeSeq) {
		sqlSessionTemplate.delete("NoticeDao.delete", noticeSeq);
	}

	@Override
	public void insert(NoticeVo notice) {
		sqlSessionTemplate.insert("NoticeDao.insert", notice);
	}

	@Override
	public void update(NoticeVo notice) {
		sqlSessionTemplate.update("NoticeDao.update", notice);
	}

	@Override
	public void updateReadCount(int noticeSeq) {
		sqlSessionTemplate.update("NoticeDao.updateCount", noticeSeq);
	}

}
