package com.spring.webprj.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.webprj.domain.PoProductVo;
import com.spring.webprj.domain.PoVo;
import com.spring.webprj.domain.ProductVo;
import com.spring.webprj.domain.QueryProductVo;
import com.spring.webprj.domain.QueryVo;
import com.spring.webprj.domain.SellerVo;
import com.spring.webprj.service.PoService;
import com.spring.webprj.service.ProductService;
import com.spring.webprj.service.QueryService;
import com.spring.webprj.domain.SellerVo;
import com.spring.webprj.service.PoService;
import com.spring.webprj.service.ProductService;
import com.spring.webprj.service.SellerService;
import com.spring.webprj.util.UploadFileUtils;

@Controller
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private ProductService prodservice;
	
	@Autowired
	private SellerService sellerservice;
	
	@Autowired
	private PoService poservice;
	
	@Autowired
	private QueryService queryservice;
	
	@Resource(name="uploadPath")
	private String uploadPath;

	@GetMapping("/prodWrite")
	public void prodWrite() {
		System.out.println("get : prodwrite");
	}
	
	@PostMapping("/prodWrite")
	public String prodWrite(ProductVo prod, MultipartFile file) throws Exception {
		String imgUploadPath = uploadPath + File.separator + "imgUpload"; 
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); String fileName = null;
		if(file != null) { 
			fileName = UploadFileUtils.fileUpload(imgUploadPath,file.getOriginalFilename(), file.getBytes(), ymdPath); 
			} else { 
				fileName = uploadPath + File.separator + "images" + File.separator + "none.png"; 
			}
			     
		prod.setPhotoUrl(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		prodservice.insert(prod);
		System.out.println(prod);
		return "redirect:/seller/prodList";
	}
	
	@GetMapping("/prodList")
	public void prodList(Model model, HttpSession session) {
		List<ProductVo> prodList = prodservice.listBySellerSeq(sellerservice.select(((SellerVo)session.getAttribute("login")).getId()).getSellerSeq());
		System.out.println("get : prodList");
		System.out.println(prodList);
		model.addAttribute("prodList", prodList);
	}
	
	@GetMapping("/prodView/{prodSeq}")
	public String prodView(@PathVariable int prodSeq,Model model) {
		model.addAttribute("prod", prodservice.getProd(prodSeq));
		System.out.println(prodservice.getProd(prodSeq));
		return "/seller/prodView";
	}
	
	@GetMapping("/prodModify/{prodSeq}")
	public String prodModify(@PathVariable int prodSeq,Model model) {
		model.addAttribute("prod", prodservice.getProd(prodSeq));
		System.out.println(prodservice.getProd(prodSeq));
		return "/seller/prodModify";
	}

	@PostMapping("/prodModify")
	public String prodModify(ProductVo prod, MultipartFile file, HttpServletRequest req) throws Exception {
		// 새로운 파일이 등록되었는지 확인
		System.out.println(prod); 
	    // 새로 첨부한 파일을 등록
	    String imgUploadPath = uploadPath + File.separator + "imgUpload";
	    String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
	    String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
	         
	    prod.setPhotoUrl(File.separator + "imgUpload" + ymdPath + File.separator + fileName);


		System.out.println(prod);
		prodservice.update(prod);
		return "redirect:/seller/prodList";
	}
	
	@PostMapping("/prodDelete/{prodSeq}")
	public String prodDelete(@PathVariable int prodSeq) throws Exception {
		// 새로운 파일이 등록되었는지 확인

		prodservice.delete(prodSeq);;
		return "redirect:/seller/prodList";
	}
	
	@GetMapping("/newOrder")
	public String newOrder(HttpSession session, Model model) {
		System.out.println(((SellerVo)session.getAttribute("login")).getSellerSeq());
		List<PoProductVo> newOrderList = poservice.newOrderlist(((SellerVo)session.getAttribute("login")).getSellerSeq());
		model.addAttribute("newOrderList", newOrderList);
		System.out.println(newOrderList);
		return "/seller/newOrder";
	}
	
	@PostMapping("/newOrder")
	public String newOrder(@RequestParam(value="poNum") List<Integer> poNumList,@RequestParam(name="poStat") String poStat, Model model, HttpSession session) {
		System.out.println("post : neworder");
		System.out.println(poStat);
		System.out.println(poNumList);
		for(int poNum : poNumList) {
			PoVo po = poservice.getPo(poNum);
			po.setPoStat(poStat);
			System.out.println(po);
			poservice.update(po);
		}
		
		return "/seller/newOrder";
	}
	
	@PostMapping("/send")
	public String send(@RequestParam(value="poNum") List<Integer> poNumList,
			@RequestParam(name="poStat") String poStat,
			@RequestParam(name="courier") List<String> courierList,
			@RequestParam(name="shippingNum") List<String> shippingNumList,
			Model model, HttpSession session) {
		System.out.println("post : send");
		System.out.println(poStat);
		System.out.println(poNumList);
		
		int i = 0;
		for(int poNum : poNumList) {
			PoVo po = poservice.getPo(poNum);
			po.setPoStat(poStat);
			po.setCourier(courierList.get(i));
			po.setShippingNum(shippingNumList.get(i));
			System.out.println(po);
			poservice.update(po);
			i++;
		}
		
		return "/seller/send";
	}
	
	@GetMapping("/send")
	public String send(HttpSession session, Model model) {
		System.out.println(((SellerVo)session.getAttribute("login")).getSellerSeq());
		List<PoProductVo> confirmOrderlist = poservice.confirmOrderlist(((SellerVo)session.getAttribute("login")).getSellerSeq());
		model.addAttribute("Orderlist", confirmOrderlist);
		System.out.println(confirmOrderlist);
		return "/seller/send";
	}
	
	@PostMapping("/sendStat")
	public String sendStat(@RequestParam(value="poNum") List<Integer> poNumList,
			@RequestParam(name="courier") List<String> courierList,
			@RequestParam(name="shippingNum") List<String> shippingNumList,
			Model model, HttpSession session) {
		System.out.println("post : sendStat 수정");
		System.out.println(poNumList);
		
		int i = 0;
		for(int poNum : poNumList) {
			
			PoVo po = poservice.getPo(poNum);
			po.setCourier(courierList.get(i));
			po.setShippingNum(shippingNumList.get(i));
			System.out.println(po);
			poservice.update(po);
			i++;
		}
		
		return "redirect:/seller/sendStat";
	}
	
	@GetMapping("/sendStat")
	public String sendStat(HttpSession session, Model model) {
		System.out.println(((SellerVo)session.getAttribute("login")).getSellerSeq());
		List<PoProductVo> shipOrderlist = poservice.shipOrderlist(((SellerVo)session.getAttribute("login")).getSellerSeq());
		model.addAttribute("Orderlist", shipOrderlist);
		System.out.println(shipOrderlist);
		return "/seller/sendStat";
	}
	
	@GetMapping("/query")
	public String query(HttpSession session, Model model) {
		System.out.println(((SellerVo)session.getAttribute("login")).getSellerSeq());
		List<QueryProductVo> querylist = queryservice.querySelectBysellerSeq(((SellerVo)session.getAttribute("login")).getSellerSeq());
		model.addAttribute("querylist", querylist);
		System.out.println(querylist);
		return "/seller/query";
	}
	
	@GetMapping("/reply/{querySeq}")
	public String reply(@PathVariable int querySeq, Model model) {
		QueryProductVo query = queryservice.prodquerySelectOne(querySeq);
		model.addAttribute("query", query);
		System.out.println(query);
		return "/seller/reply";
	}
	
	@PostMapping("/reply/{querySeq}")
	public String reply(@PathVariable int querySeq,@RequestParam(value="reply") String reply) {
		QueryVo query = queryservice.querySelectOne(querySeq);
		query.setReply(reply);
		queryservice.queryUpdate(query);
		System.out.println(query);
		return "redirect:/seller/query";
	}
}
