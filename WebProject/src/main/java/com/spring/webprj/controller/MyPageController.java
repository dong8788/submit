package com.spring.webprj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.webprj.domain.CartProductVo;
import com.spring.webprj.domain.CartVo;
import com.spring.webprj.domain.CustomerVo;
import com.spring.webprj.domain.PoProductVo;
import com.spring.webprj.domain.QueryProductVo;
import com.spring.webprj.domain.ReviewVo;
import com.spring.webprj.service.CartService;
import com.spring.webprj.service.PoService;
import com.spring.webprj.service.ProductService;
import com.spring.webprj.service.QueryService;
import com.spring.webprj.service.ReviewService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	@Autowired
	private PoService poservice;
	
	@Autowired
	private CartService cartservice;
	
	@Autowired
	private QueryService queryservice;
	
	@Autowired
	private ProductService prodservice;
	
	@Autowired
	private ReviewService reviewService;
	
	@ResponseBody
	@RequestMapping(value="/addCart", method = RequestMethod.POST)
	public int sellerIdChk(HttpSession session, CartVo cart) throws Exception{
		CustomerVo cus = (CustomerVo)session.getAttribute("login");
		cart.setCusSeq(cus.getCusSeq());
		int result = cartservice.insert(cart);
		return result;
	}
	
	
	@GetMapping("/main")
	public String main(HttpSession session, RedirectAttributes ra, Model model) {
		if(session.getAttribute("seller1") == null) {
			System.out.println("mypage:main");
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			int polistSize = poservice.list(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			int prodquerySize = queryservice.querySelectBySeq(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			int prodreplySize = 0;
			for(QueryProductVo prodquery : queryservice.querySelectBySeq(((CustomerVo)session.getAttribute("login")).getCusSeq())) {
				if(prodquery.getReply() != null) prodreplySize ++;
			}
			model.addAttribute("cartSize", cartSize);
			model.addAttribute("polistSize", polistSize);
			model.addAttribute("prodquerySize", prodquerySize);
			model.addAttribute("prodreplySize", prodreplySize);
		}

			 
		return "mypage/main";
	}
	
	@GetMapping("/cart")
	public String cart(HttpSession session, RedirectAttributes ra, Model model) {
		System.out.println("mypage:cart");
		List<CartProductVo> cartProductLsit = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq());
		System.out.println(((CustomerVo)session.getAttribute("login")).getCusSeq());
		System.out.println(cartProductLsit);
		int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
		model.addAttribute("cartSize", cartSize);
		model.addAttribute("cartProductList", cartProductLsit);
		return "mypage/cart";
	}
	
	@GetMapping("/cartDelete/{cartSeq}")
	public String cartDelete(@PathVariable int cartSeq, RedirectAttributes ra, HttpSession session) {
		System.out.println("mypage:cartdelete" + cartSeq);
		cartservice.delete(cartSeq);
		return "redirect:/mypage/cart";
	}
	
	@GetMapping("/polist")
	public String polist(Model model, HttpSession session, RedirectAttributes ra) {
		System.out.println("mypage:polist"+ ((CustomerVo)session.getAttribute("login")).getCusSeq());
		int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
		model.addAttribute("cartSize", cartSize);
		List<PoProductVo> poProductList = poservice.list(((CustomerVo)session.getAttribute("login")).getCusSeq());
		model.addAttribute("poProductList", poProductList);
		System.out.println(poProductList);
		return "mypage/polist";
	}
	
	@GetMapping("/prodquery")
	public String prodquery(HttpSession session, RedirectAttributes ra, Model model) {
		System.out.println("mypage:prodquery " + ((CustomerVo)session.getAttribute("login")).getCusSeq());
		List<QueryProductVo> queryProductList = queryservice.querySelectBySeq(((CustomerVo)session.getAttribute("login")).getCusSeq());
		System.out.println(queryProductList);
		model.addAttribute("queryProductList", queryProductList);
		int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
		model.addAttribute("cartSize", cartSize);
		return "mypage/prodquery";
	}
	
	@GetMapping("/reviewWrite/{prodSeq}")
	public String reviewWrite(@PathVariable int prodSeq, HttpSession session, RedirectAttributes ra, Model model) {
    	System.out.println("mypage:prodquery " + ((CustomerVo)session.getAttribute("login")).getCusSeq());
        int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
        model.addAttribute("cartSize", cartSize);
        model.addAttribute("product", prodservice.getProd(prodSeq));
        String id = ((CustomerVo)session.getAttribute("login")).getCusId();
        model.addAttribute("cusId", id);
        return "mypage/reviewWrite";
	}
	   
	@PostMapping("/reviewWrite/insert")
	public String reviewInsert(HttpSession session, RedirectAttributes ra, ReviewVo reviewVo, Model model) {
	      if(session.getAttribute("login")==null) {
	         ra.addFlashAttribute("msg", "not-login");
	         return "redirect:/";
	      } else {
	         reviewService.reviewInsert(reviewVo);
	         return "redirect:/mypage/polist";
	      }
	   }

}
