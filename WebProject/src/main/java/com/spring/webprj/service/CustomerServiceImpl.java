package com.spring.webprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.webprj.domain.CustomerVo;
import com.spring.webprj.persistence.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao cusDao;
	
	@Override
	public List<CustomerVo> selectAll() {
		System.out.println("selectAll");
		return cusDao.selectAll();
	}
	//고객 정보 확인
	@Override
	public CustomerVo select(String cusId) {
		System.out.println("select");
		System.out.println(cusId);
		return cusDao.select(cusId);
	}
	
	@Override
	public int checkCusId(String cusId) {
		// TODO Auto-generated method stub
		return cusDao.checkCusId(cusId);
	}

	@Override
	public void delete(int cusSeq) {
		System.out.println("delete");
		cusDao.delete(cusSeq);
	}

	@Override
	public void insert(CustomerVo cus) {
		//회원 비밀번호를 암호화 인코딩
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("암호화 전 : "+ cus.getPassword());
		//비밀번호를 암호화하여 다시 User객체에 저장
		String securePw = encoder.encode(cus.getPassword());
		cus.setPassword(securePw);
		System.out.println("암호화 후 : "+ securePw);
		System.out.println(cus);
		System.out.println("insert");
		cusDao.insert(cus);

	}
	@Override
	public void update(CustomerVo cus) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("암호화 전 : "+ cus.getPassword());
		//비밀번호를 암호화하여 다시 User객체에 저장
		String securePw = encoder.encode(cus.getPassword());
		cus.setPassword(securePw);
		System.out.println("암호화 후 : "+ securePw);
		System.out.println(cus);
		System.out.println("insert");
		cusDao.update(cus);
		
	}

}
