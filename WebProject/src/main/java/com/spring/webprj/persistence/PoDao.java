package com.spring.webprj.persistence;

import java.util.List;

import com.spring.webprj.domain.PoProductVo;
import com.spring.webprj.domain.PoVo;

public interface PoDao {
	
	//PO 리스트를 가져오기 위한 기능
	public List<PoProductVo> list(int cusSeq);

	//PO 전체 리스트를 가져오기 위한 기능
	public List<PoProductVo> listAll();

	//PO 신규 오더 리스트를 가져오기 위한 기능
	public List<PoProductVo> newOrderlist(int sellerSeq);
	
	//PO 발송필요 오더 리스트를 가져오기 위한 기능
	public List<PoProductVo> confirmOrderlist(int sellerSeq);
	
	//PO 배송중 오더 리스트를 가져오기 위한 기능
	public List<PoProductVo> shipOrderlist(int sellerSeq);
	
	//PO 배송완료 오더 리스트를 가져오기 위한 기능
	public List<PoProductVo> shipSucOrderlist(int sellerSeq);
	
	//PO 구매확정 오더 리스트를 가져오기 위한 기능
	public List<PoProductVo> poFconfirmOrderlist(int sellerSeq);
	
	//PO 구매확 조회 기능
	public PoVo getPo(int poNum);
	
	//PO 취소 기능
	public void delete(int poNum);
	
	//PO 생성기능
	public void insert(PoVo po);
	
	//PO 업데이트기능
	public void update(PoVo po);
	
	
}
