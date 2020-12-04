package com.spring.webprj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.webprj.domain.ReviewVo;

public interface ReviewService {

	public List<ReviewVo> reviewSelectAll(int prodSeq);
	public ReviewVo reviewSelectOne(int seq);
	public void reviewInsert(ReviewVo reviewVo);
	public void reviewUpdate(ReviewVo reviewVo);
	public void reviewDelete(int seq);
}
