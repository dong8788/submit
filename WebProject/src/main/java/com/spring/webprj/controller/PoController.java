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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.webprj.common.PageMaker;
import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.CustomerVo;
import com.spring.webprj.domain.PoVo;
import com.spring.webprj.domain.QueryVo;
import com.spring.webprj.domain.ReviewVo;
import com.spring.webprj.service.CartService;
import com.spring.webprj.service.PoService;
import com.spring.webprj.service.ProductService;
import com.spring.webprj.service.QueryService;
import com.spring.webprj.service.ReviewService;


@Controller
@RequestMapping("/product")
public class PoController {
	
	@Autowired
	private PoService service;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private QueryService queryService;
	
	@Autowired
	private CartService cartservice;
	
	@Autowired
	private ProductService prodservice;

	@GetMapping("/content")
	public String product(HttpSession session, Model model) {
		System.out.println("get : product");
		List<QueryVo> queryList = queryService.querySelectAll(1);
		List<ReviewVo> reviewList = reviewService.reviewSelectAll(1);
		System.out.println(queryList);
		System.out.println(reviewList);
		model.addAttribute("queryList", queryList);
		model.addAttribute("reviewList", reviewList);
		if(session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		return "product/single";
	}
	
	@GetMapping("/content/{prodSeq}")
	public String product(@PathVariable int prodSeq, HttpSession session, Model model) {
		System.out.println("get : product");
		List<QueryVo> queryList = queryService.querySelectAll(prodSeq);
		List<ReviewVo> reviewList = reviewService.reviewSelectAll(prodSeq);
		System.out.println(queryList);
		System.out.println(reviewList);
		model.addAttribute("product", prodservice.getProd(prodSeq));
		model.addAttribute("queryList", queryList);
		model.addAttribute("reviewList", reviewList);
		if(session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		return "product/content";
	}
	
	@GetMapping("/po")
	public String order(@RequestParam int prodSeq, @RequestParam int poQuantity,HttpSession session, RedirectAttributes ra, Model model) {
		System.out.println("get : po");
		int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
		model.addAttribute("cartSize", cartSize);
		model.addAttribute("product", prodservice.getProd(prodSeq));
		model.addAttribute("poQuantity", poQuantity);
		return "product/po";
	}
	
	@PostMapping("/po")
	public @ResponseBody void order(PoVo po, HttpSession session, Model model) {
		System.out.println("post: "+ po);
		//String 
		service.insert(po);
		if(session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
	}

	@PostMapping("/query")
	public String query(QueryVo query) {
		System.out.println("post: query");
		System.out.println(query);
		queryService.queryInsert(query);
		return "redirect:/product/content/"+query.getProdSeq();
	}
	
	@GetMapping("/search")
	public String search(HttpSession session, Model model, SearchVO search) {
		System.out.println("get : search");
		if(session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		PageMaker pm = new PageMaker();
		pm.setCri(search);
		System.out.println(search.getRowStart());
		System.out.println("parameter(페이지번호) : "+search.getPage());
		System.out.println("검색 조건 : "+ search.getCondition());
		System.out.println("검색어 : "+ search.getKeyword());
		System.out.println("rowStart : "+ search.getRowStart());
		System.out.println("rowEnd : "+ search.getRowEnd());
		pm.setTotalCount(prodservice.listCount(search));
		model.addAttribute("prodList", prodservice.list(search));
		System.out.println(prodservice.list(search));
		model.addAttribute("pageMaker", pm);
		return "product/search";
	}
	
	@GetMapping("/map")
	public String map(HttpSession session, Model model, SearchVO search) {
		System.out.println("get : search");
		if(session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		PageMaker pm = new PageMaker();
		pm.setCri(search);
		System.out.println(search.getRowStart());
		System.out.println("parameter(페이지번호) : "+search.getPage());
		System.out.println("검색 조건 : "+ search.getCondition());
		System.out.println("검색어 : "+ search.getKeyword());
		System.out.println("rowStart : "+ search.getRowStart());
		System.out.println("rowEnd : "+ search.getRowEnd());
		pm.setTotalCount(prodservice.listCount(search));
		model.addAttribute("prodList", prodservice.list(search));
		System.out.println(prodservice.list(search));
		model.addAttribute("pageMaker", pm);
		return "product/map";
	}

}
