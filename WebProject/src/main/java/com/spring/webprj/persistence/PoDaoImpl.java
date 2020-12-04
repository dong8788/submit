package com.spring.webprj.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.webprj.domain.PoProductVo;
import com.spring.webprj.domain.PoVo;

@Repository
public class PoDaoImpl implements PoDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<PoProductVo> list(int cusSeq) {
		return sqlSessionTemplate.selectList("PoDao.list", cusSeq);
	}
	
	@Override
	public List<PoProductVo> listAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<PoProductVo> newOrderlist(int sellerSeq) {
		return sqlSessionTemplate.selectList("PoDao.newOrderlist", sellerSeq);
	}
	
	@Override
	public List<PoProductVo> confirmOrderlist(int sellerSeq) {
		return sqlSessionTemplate.selectList("PoDao.confirmOrderlist", sellerSeq);
	}
	
	@Override
	public List<PoProductVo> shipOrderlist(int sellerSeq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("PoDao.shipOrderlist", sellerSeq);
	}
	
	@Override
	public List<PoProductVo> shipSucOrderlist(int sellerSeq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("PoDao.shipSucOrderlist", sellerSeq);
	}
	
	@Override
	public List<PoProductVo> poFconfirmOrderlist(int sellerSeq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("PoDao.poFconfirmOrderlist", sellerSeq);
	}

	@Override
	public PoVo getPo(int poNum) {
		return sqlSessionTemplate.selectOne("PoDao.getPo", poNum);
	}

	@Override
	public void delete(int poNum) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(PoVo po) {
		System.out.println("poDao");
		System.out.println(po);
		sqlSessionTemplate.insert("PoDao.insert",po);

	}
	
	@Override
	public void update(PoVo po) {
		sqlSessionTemplate.update("PoDao.update",po);
		
	}

}
