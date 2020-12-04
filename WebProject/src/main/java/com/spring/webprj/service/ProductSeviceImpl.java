package com.spring.webprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.ProductVo;
import com.spring.webprj.persistence.ProductDao;


@Service
public class ProductSeviceImpl implements ProductService {

	@Autowired
	private ProductDao prodDao;
	
	@Override
	public List<ProductVo> listBySellerSeq(int sellerSeq) {
		System.out.println("prodlist");
		return prodDao.listBySellerSeq(sellerSeq);
	}
	
	@Override
	public List<ProductVo> list(SearchVO search) {
		return prodDao.list(search);
	}
	
	@Override
	public int listCount(SearchVO search) {
		return prodDao.listCount(search);
	}

	@Override
	public ProductVo getProd(int prodSeq) {
		System.out.println("prod get");
		return prodDao.getProd(prodSeq);
	}

	@Override
	public void delete(int prodSeq) {
		System.out.println("prod delete");
		prodDao.delete(prodSeq);
		
	}

	@Override
	public void insert(ProductVo prod) {
		System.out.println("prod insert");
		prodDao.insert(prod);
		
	}

	@Override
	public void update(ProductVo prod) {
		System.out.println("prod update");
		prodDao.update(prod);
		
	}



}
