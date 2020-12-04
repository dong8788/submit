package com.spring.webprj.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.webprj.domain.QueryProductVo;
import com.spring.webprj.domain.QueryVo;

@Repository
public class QueryDaoImpl implements QueryDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<QueryVo> querySelectAll(int prodSeq) {
		return sqlSessionTemplate.selectList("QueryDao.querySelectAll", prodSeq);
	}

	@Override
	public List<QueryProductVo> querySelectBySeq(int cusSeq) {
		System.out.println("query : querySelectBySeq");
		return sqlSessionTemplate.selectList("QueryDao.querySelectBySeq", cusSeq);
	}
	
	@Override
	public List<QueryProductVo> querySelectBysellerSeq(int sellerSeq) {
		return sqlSessionTemplate.selectList("QueryDao.querySelectBysellerSeq", sellerSeq);
	}

	@Override
	public QueryProductVo prodquerySelectOne(int querySeq) {
		return sqlSessionTemplate.selectOne("QueryDao.prodquerySelectOne", querySeq);
	}
	
	@Override
	public QueryVo querySelectOne(int querySeq) {
		return sqlSessionTemplate.selectOne("QueryDao.querySelectOne", querySeq);
	}

	@Override
	public void queryInsert(QueryVo queryVo) {
		sqlSessionTemplate.insert("QueryDao.queryInsert", queryVo);
		
	}

	@Override
	public void queryUpdate(QueryVo queryVo) {
		sqlSessionTemplate.update("QueryDao.queryUpdate", queryVo);
	}

	@Override
	public void queryDelete(int querySeq) {
		sqlSessionTemplate.delete("QueryDao.queryDelete", querySeq);
	}


}
