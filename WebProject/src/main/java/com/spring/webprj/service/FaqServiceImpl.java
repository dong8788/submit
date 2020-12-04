package com.spring.webprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.FaqVo;
import com.spring.webprj.persistence.FaqDao;

@Service
public class FaqServiceImpl implements FaqService {

	@Autowired
	private FaqDao faqDao;
	
	@Override
	public List<FaqVo> selectAll(SearchVO search) {
		return faqDao.selectAll(search);
	}
	
	@Override
	public int listCount(SearchVO search) {
		return faqDao.listCount(search);
	}
	
	@Override
	public FaqVo select(int faqSeq) {
		// TODO Auto-generated method stub
		return faqDao.select(faqSeq);
	}

	@Override
	public void delete(int faqSeq) {
		faqDao.delete(faqSeq);

	}

	@Override
	public void insert(FaqVo faq) {
		faqDao.insert(faq);

	}
	
	@Override
	public void update(FaqVo faq) {
		faqDao.update(faq);
		
	}


}
