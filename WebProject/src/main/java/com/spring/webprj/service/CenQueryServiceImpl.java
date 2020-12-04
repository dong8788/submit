package com.spring.webprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.CenQueryVo;
import com.spring.webprj.persistence.CenQueryDao;

@Service
public class CenQueryServiceImpl implements CenQueryService {

	@Autowired
	private CenQueryDao cenQueryDao;
	
	@Override
	public List<CenQueryVo> list(SearchVO search) {
		// TODO Auto-generated method stub
		return cenQueryDao.list(search);
	}
	
	@Override
	public int listCount(SearchVO search) {
		return cenQueryDao.listCount(search);
	}

	@Override
	public CenQueryVo read(int req) {
		// TODO Auto-generated method stub
		return cenQueryDao.read(req);
	}

	@Override
	public void insert(CenQueryVo dto) {
		cenQueryDao.insert(dto);

	}

	@Override
	public void update(CenQueryVo dto) {
		cenQueryDao.update(dto);

	}

	@Override
	public void delete(int cenQuerySeq) {
		cenQueryDao.delete(cenQuerySeq);

	}

}
