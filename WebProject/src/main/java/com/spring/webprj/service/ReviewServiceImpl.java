package com.spring.webprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.webprj.domain.ReviewVo;
import com.spring.webprj.persistence.ReviewDao;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	public List<ReviewVo> reviewSelectAll(int prodSeq) {
		System.out.println("review:selectAll");
		return reviewDao.reviewSelectAll(prodSeq);
	}

	@Override
	public ReviewVo reviewSelectOne(int seq) {
		return reviewDao.reviewSelectOne(seq);
	}

	@Override
	public void reviewInsert(ReviewVo reviewVo) {
		reviewDao.reviewInsert(reviewVo);
	}

	@Override
	public void reviewUpdate(ReviewVo reviewVo) {
		reviewDao.reviewUpdate(reviewVo);
	}

	@Override
	public void reviewDelete(int seq) {
		reviewDao.reviewDelete(seq);
	}

}
