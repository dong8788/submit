package com.spring.webprj.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.webprj.domain.SellerVo;

@Repository
public class SellerDaoImpl implements SellerDao {

	@Override
	public int sellerIdChk(SellerVo vo) throws Exception{
		System.out.println("IdChk");
		int result = sql.selectOne("SellerDao.sellerIdChk", vo);
		return result;
	}
	
	@Inject SqlSession sql;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<SellerVo> selectAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("SellerDao.selectAll");
	}

	@Override
	public SellerVo select(String id) {
		return sqlSessionTemplate.selectOne("SellerDao.select",id);
	}
	
	@Override
	public int checkSellerId(String id) {
		return sqlSessionTemplate.selectOne("SellerDao.checkSellerId",id);
	}

	@Override
	public void delete(int sellerSeq) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(SellerVo seller) {
		System.out.println("SellerDao");
		System.out.println(seller);
		sqlSessionTemplate.insert("SellerDao.insert",seller);

	}

}
