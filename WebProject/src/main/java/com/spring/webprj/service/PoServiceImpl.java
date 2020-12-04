package com.spring.webprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.webprj.domain.PoProductVo;
import com.spring.webprj.domain.PoVo;
import com.spring.webprj.persistence.PoDao;

@Service
public class PoServiceImpl implements PoService {
	
	@Autowired
	private PoDao poDao;
	
	@Override
	public List<PoProductVo> list(int cusSeq) {
		
		return poDao.list(cusSeq);
	}
	
	@Override
	public List<PoProductVo> listAll() {
		
		return poDao.listAll();
	}
	
	@Override
	public List<PoProductVo> newOrderlist(int sellerSeq) {
		return poDao.newOrderlist(sellerSeq);
	}
	
	@Override
	public List<PoProductVo> confirmOrderlist(int sellerSeq) {
		return poDao.confirmOrderlist(sellerSeq);
	}
	
	@Override
	public List<PoProductVo> shipOrderlist(int sellerSeq) {
		return poDao.shipOrderlist(sellerSeq);
	}
	
	@Override
	public List<PoProductVo> shipSucOrderlist(int sellerSeq) {
		return poDao.shipSucOrderlist(sellerSeq);
	}
	
	@Override
	public List<PoProductVo> poFconfirmOrderlist(int sellerSeq) {
		return poDao.poFconfirmOrderlist(sellerSeq);
	}
	

	@Override
	public PoVo getPo(int poNum) {
		return poDao.getPo(poNum);
	}

	@Override
	public void delete(int poNum) {
		poDao.delete(poNum);

	}

	@Override
	public void insert(PoVo po) {
		System.out.println("service : insert");
		poDao.insert(po);
	}
	
	@Override
	public void update(PoVo po) {
		poDao.update(po);
		
	}

}
