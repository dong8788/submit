package com.spring.webprj.service;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.webprj.domain.SellerVo;
import com.spring.webprj.persistence.SellerDao;

@Service
public class SellerServiceImpl implements SellerService {

	
	@Override
	public int sellerIdChk(SellerVo vo) throws Exception {
		int result = sellerDao.sellerIdChk(vo);
		return result;
	}
	
	@Autowired
	private SqlSessionTemplate sellSqlSession;
	
	
	@Inject
	private SellerDao sellerDao;
	
	@Override
	public List<SellerVo> selectAll() {
		return sellerDao.selectAll();
	}

	@Override
	public SellerVo select(String id) {
		return sellerDao.select(id);
	}
	
	@Override
	public int checkSellerId(String id) {
		return sellerDao.checkSellerId(id);
	}

	@Override
	public void delete(int sellerSeq) {

	}

	@Override
	public void insert(SellerVo seller) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("암호화 전 : "+ seller.getPassword());
		//비밀번호를 암호화하여 다시 User객체에 저장
		String securePw = encoder.encode(seller.getPassword());
		seller.setPassword(securePw);
		System.out.println("암호화 후 : "+ securePw);
		System.out.println(seller);
		System.out.println("insert");
		sellerDao.insert(seller);

	}

}
