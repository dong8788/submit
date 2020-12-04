package com.spring.webprj.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.webprj.domain.CustomerVo;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<CustomerVo> selectAll() {
		return sqlSessionTemplate.selectList("CustomerDao.selectAll");
	}

	@Override
	public CustomerVo select(String cusId) {
		return sqlSessionTemplate.selectOne("CustomerDao.select",cusId);
	}

	@Override
	public void delete(int cusSeq) {
		sqlSessionTemplate.selectOne("CustomerDao.delete",cusSeq);

	}

	@Override
	public void insert(CustomerVo cus) {
		System.out.println("CustomerDao");
		System.out.println(cus);
		sqlSessionTemplate.insert("CustomerDao.insert",cus);

	}

	@Override
	public void update(CustomerVo cus) {
		sqlSessionTemplate.update("CustomerDao.update", cus);
		
	}

	@Override
	public int checkCusId(String cusId) {
		
		return sqlSessionTemplate.selectOne("CustomerDao.checkCusId", cusId);
	}

}
