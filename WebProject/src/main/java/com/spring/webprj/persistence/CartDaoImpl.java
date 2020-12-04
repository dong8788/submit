package com.spring.webprj.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.webprj.domain.CartProductVo;
import com.spring.webprj.domain.CartVo;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<CartProductVo> select(int cusSeq) {
		System.out.println("cart : select");
		return sqlSessionTemplate.selectList("CartDao.select", cusSeq);
	}

	@Override
	public CartProductVo getCart(int CartSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int cartSeq) {
		sqlSessionTemplate.delete("CartDao.delete", cartSeq); 

	}

	@Override
	public int insert(CartVo cart) {
		return sqlSessionTemplate.insert("CartDao.insert", cart);

	}

}
