package com.spring.webprj.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.webprj.domain.ReviewVo;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<ReviewVo> reviewSelectAll(int prodSeq) {
		return sqlSessionTemplate.selectList("ReviewDao.reviewSelectAll", prodSeq);
	}

	@Override
	public ReviewVo reviewSelectOne(int seq) {
		return sqlSessionTemplate.selectOne("ReviewDao.reviewSelectOne", seq);
	}

	@Override
	public void reviewInsert(ReviewVo reviewVo) {
		sqlSessionTemplate.insert("ReviewDao.reviewInsert", reviewVo);
	}

	@Override
	public void reviewUpdate(ReviewVo reviewVo) {
		sqlSessionTemplate.update("ReviewDao.reviewUpdate", reviewVo);
	}

	@Override
	public void reviewDelete(int seq) {
		sqlSessionTemplate.delete("ReviewDao.reviewDelete", seq);
	}

}
