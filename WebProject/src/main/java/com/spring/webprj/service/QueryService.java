package com.spring.webprj.service;

import java.util.List;

import com.spring.webprj.domain.QueryProductVo;
import com.spring.webprj.domain.QueryVo;

public interface QueryService {

	public List<QueryVo> querySelectAll(int prodSeq);
	public List<QueryProductVo> querySelectBySeq(int cusSeq);
	public List<QueryProductVo> querySelectBysellerSeq(int sellerSeq);
	public QueryProductVo prodquerySelectOne(int querySeq);
	public QueryVo querySelectOne(int querySeq);
	public void queryInsert(QueryVo queryVo);
	public void queryUpdate(QueryVo queryVo);
	public void queryDelete(int querySeq);
}
