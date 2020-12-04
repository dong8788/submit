package com.spring.webprj.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.ProductVo;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<ProductVo> listBySellerSeq(int sellerSeq) {
		System.out.println("dao : prod list");
		return sqlSessionTemplate.selectList("ProductDao.listBySellerSeq", sellerSeq);
	}
	
	@Override
	public List<ProductVo> list(SearchVO search) {
		return sqlSessionTemplate.selectList("ProductDao.list", search);
	}
	
	@Override
	public int listCount(SearchVO search) {
		return sqlSessionTemplate.selectOne("ProductDao.listCount", search);
	}

	@Override
	public ProductVo getProd(int prodSeq) {
		System.out.println("dao : prod get");
		return sqlSessionTemplate.selectOne("ProductDao.getProd", prodSeq);
	}

	@Override
	public void delete(int prodSeq) {
		System.out.println("dao : prod delete");
		sqlSessionTemplate.delete("ProductDao.delete", prodSeq);
	}

	@Override
	public void insert(ProductVo prod) {
		System.out.println("dao : prod insert");
		sqlSessionTemplate.insert("ProductDao.insert", prod);

	}

	@Override
	public void update(ProductVo prod) {
		System.out.println("dao : prod update");
		sqlSessionTemplate.insert("ProductDao.update", prod);
		
	}

}
