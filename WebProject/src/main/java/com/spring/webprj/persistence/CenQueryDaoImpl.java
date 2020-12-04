package com.spring.webprj.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.CenQueryVo;

@Repository
public class CenQueryDaoImpl implements CenQueryDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<CenQueryVo> list(SearchVO search) {
		return sqlSessionTemplate.selectList("CenQueryDao.list", search);
	}
	
	@Override
	public int listCount(SearchVO search) {
		return sqlSessionTemplate.selectOne("CenQueryDao.listCount", search);
	}

	@Override
	public CenQueryVo read(int seq) {
		return sqlSessionTemplate.selectOne("CenQueryDao.read",seq);
	}

	@Override
	public void insert(CenQueryVo dto) {
		System.out.println("insert dto : " + dto);
		sqlSessionTemplate.insert("CenQueryDao.insert", dto);
	}

	@Override
	public void update(CenQueryVo dto) {
		System.out.println("update dto : " + dto);
		sqlSessionTemplate.update("CenQueryDao.update", dto);
	}

	@Override
	public void delete(int cenQuerySeq) {
		sqlSessionTemplate.delete("CenQueryDao.delete", cenQuerySeq);
	}
	


}
