package com.spring.webprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.webprj.domain.CartProductVo;
import com.spring.webprj.domain.CartVo;
import com.spring.webprj.persistence.CartDao;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	@Override
	public List<CartProductVo> select(int cusSeq) {
		return cartDao.select(cusSeq);
	}

	@Override
	public CartProductVo getCart(int CartSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int cartSeq) {
		cartDao.delete(cartSeq);

	}

	@Override
	public int insert(CartVo cart) {
		return cartDao.insert(cart);

	}

}
