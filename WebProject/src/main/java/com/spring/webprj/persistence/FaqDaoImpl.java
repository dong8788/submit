package com.spring.webprj.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.FaqVo;

@Repository
public class FaqDaoImpl implements FaqDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<FaqVo> selectAll(SearchVO search) {
		return sqlSessionTemplate.selectList("FaqDao.selectAll", search);
	}
	
	@Override
	public int listCount(SearchVO search) {
		return sqlSessionTemplate.selectOne("FaqDao.listCount", search);
	}

	@Override
	public FaqVo select(int faqSeq) {
		return sqlSessionTemplate.selectOne("FaqDao.select", faqSeq);
	}

	@Override
	public void delete(int faqSeq) {
		sqlSessionTemplate.delete("FaqDao.delete", faqSeq);
	}

	@Override
	public void insert(FaqVo faq) {
		sqlSessionTemplate.insert("FaqDao.insert", faq);

	}
	
	@Override
	public void update(FaqVo faq) {
		sqlSessionTemplate.update("FaqDao.update", faq);
		
	}

}
