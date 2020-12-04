package com.spring.webprj.persistence;

import java.util.List;

import com.spring.webprj.domain.ReviewVo;

public interface ReviewDao {
	
	public List<ReviewVo> reviewSelectAll(int prodSeq);
	public ReviewVo reviewSelectOne(int seq);
	public void reviewInsert(ReviewVo reviewVo);
	public void reviewUpdate(ReviewVo reviewVo);
	public void reviewDelete(int seq);
}
