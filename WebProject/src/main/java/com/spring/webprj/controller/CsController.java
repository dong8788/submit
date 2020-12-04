package com.spring.webprj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.webprj.common.Criteria;
import com.spring.webprj.common.PageMaker;
import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.CenQueryVo;
import com.spring.webprj.domain.CustomerVo;

import com.spring.webprj.domain.FaqVo;
import com.spring.webprj.domain.NoticeVo;
import com.spring.webprj.service.CartService;
import com.spring.webprj.service.CenQueryService;
import com.spring.webprj.service.FaqService;
import com.spring.webprj.service.NoticeService;

@Controller
@RequestMapping("/cs")
public class CsController {
	
	@Autowired
	private NoticeService noticeservice;
	
	@Autowired
	private CenQueryService cenQueryservice;
	
	@Autowired
	private FaqService faqservice;
	
	@Autowired
	private CartService cartservice;
	
	@GetMapping("/cenquery")
	public String cenquery(SearchVO search, HttpSession session, Model model) {
		
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
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
		System.out.println(search);
		
		List<CenQueryVo> cenQueryList = cenQueryservice.list(search);
		pm.setTotalCount(cenQueryservice.listCount(search));
		System.out.println(cenQueryservice.list(search).size());
		model.addAttribute("userCenQueryList", cenQueryList);
		System.out.println(cenQueryList);
		model.addAttribute("pageMaker", pm);
		
		return "cs/cenquery";
	}
	
	@GetMapping("/cenquery/write")
	public String cenqueryWrite(HttpSession session, Model model) {
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		
		return "cs/cenquery/write";
	}
	
	@PostMapping("/cenquery/write")
	public String cenqueryWrite(CenQueryVo cenquery) {
		System.out.println(cenquery);
		cenQueryservice.insert(cenquery);
		return "redirect:/cs/cenquery";
	}
	
	@GetMapping("/cenquery/view/{cenQuerySeq}")
	public String cenqueryView(@PathVariable int cenQuerySeq, HttpSession session, Model model) {
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		
		model.addAttribute("cenquery", cenQueryservice.read(cenQuerySeq));
		
		return "cs/cenquery/view";
	}
	
	@GetMapping("/cenquery/update/{cenQuerySeq}")
	public String cenqueryUpdate(@PathVariable int cenQuerySeq, HttpSession session, Model model) {
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		
		model.addAttribute("cenquery", cenQueryservice.read(cenQuerySeq));
		
		return "cs/cenquery/update";
	}
	
	@PostMapping("/cenquery/update")
	public String cenqueryUpdate(CenQueryVo cenquery, HttpSession session, Model model) {
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		
		System.out.println(cenquery);
		cenQueryservice.update(cenquery);
		
		return "redirect:/cs/cenquery";
	}

	//FAQ
	@GetMapping("/faq")
	public String faq(Model model, HttpSession session, SearchVO search) {
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
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
		pm.setTotalCount(faqservice.listCount(search));
		model.addAttribute("faqList", faqservice.selectAll(search));
		model.addAttribute("pageMaker", pm);

		return "cs/faq/list";
	}
	@GetMapping("/faq/view/{seq}")
	public String faqView(Model model, @PathVariable int seq) {
		FaqVo faqVo = faqservice.select(seq);
		model.addAttribute("faqVo", faqVo);
		return "cs/faq/view";
	}
	@GetMapping("/faq/insert")
	public String faqInsert(Model model) {
		model.addAttribute("faqVo", new FaqVo());
		return "cs/faq/insert";
	}
	@PostMapping("/faq/insert")
	public String faqInsert(FaqVo faqVo) {
		faqservice.insert(faqVo);
		return "redirect:/cs/faq";
	}
	@GetMapping("/faq/delete/{seq}")
	public String faqDelete(Model model, @PathVariable int seq) {
		faqservice.delete(seq);
		return "cs/faq/delete";
	}
	@GetMapping("/faq/update/{seq}")
	public String faqUpdate(Model model, @PathVariable int seq) {
		FaqVo faqVo = faqservice.select(seq);
		model.addAttribute("faqVo", faqVo);
		return "cs/faq/update";
	}
	@PostMapping("/faq/update/{seq}")
	public String faqUpdate(FaqVo faqVo, @PathVariable int seq) {
		System.out.println("updated faqVo : " + faqVo);
		faqservice.update(faqVo);
		return "redirect:/cs/faq";
	}
	//FAQ 끝
	
	
	//공지사항
	@GetMapping("/notice")
	public String notice(Model model, HttpSession session, SearchVO search) {
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
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
		pm.setTotalCount(noticeservice.listCount(search));
		model.addAttribute("noticeList", noticeservice.selectAll(search));
		model.addAttribute("pageMaker", pm);

		return "cs/notice/list";
	}
	@GetMapping("/notice/view/{seq}")
	public String noticeView(Model model, HttpSession session, @PathVariable int seq) {
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		noticeservice.updateReadCount(seq);
		NoticeVo noticeVo = noticeservice.selectBySeq(seq);
		model.addAttribute("noticeVo", noticeVo);
		return "cs/notice/view";
	}
	@GetMapping("/notice/write")
	public String noticeInsert(Model model, HttpSession session) {
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		CustomerVo customerVo = (CustomerVo)session.getAttribute("login");
		if(session.getAttribute("seller1") == null &&
				customerVo.getCusId().equals("admin")){
			model.addAttribute("noticeVo", new NoticeVo());
			return "cs/notice/write";
		} else {
			return "redirect:/cs/notice";
		}
	}
	@PostMapping("/notice/write")
	public String noticeInsert(Model model, HttpSession session, NoticeVo noticeVo) {
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		noticeservice.insert(noticeVo);
		return "redirect:/cs/notice";
	}
	@GetMapping("/notice/delete/{seq}")
	public String noticeDelete(Model model, HttpSession session, @PathVariable int seq) {
		CustomerVo customerVo = (CustomerVo)session.getAttribute("login");
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		if(session.getAttribute("login") == null) {
			return "redirect:/cs/notice";
		}
		if(session.getAttribute("seller1") == null &&
				customerVo.getCusId().equals("admin")){
			noticeservice.delete(seq);
			return "cs/notice/delete";
		} else {
			return "redirect:/cs/notice";
		}
	}
	@GetMapping("/notice/update/{seq}")
	public String noticeUpdate(Model model, HttpSession session, @PathVariable int seq) {
		CustomerVo customerVo = (CustomerVo)session.getAttribute("login");
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		if(session.getAttribute("login") == null) {
			return "redirect:/cs/notice";
		}
		if(session.getAttribute("seller1") == null &&
				customerVo.getCusId().equals("admin")){
			NoticeVo noticeVo = noticeservice.selectBySeq(seq);
			model.addAttribute("noticeVo", noticeVo);
			return "cs/notice/update";
		} else {
			return "redirect:/cs/notice";
		}
	}
	@PostMapping("/notice/update/{seq}")
	public String noticeUpdate(Model model, HttpSession session, NoticeVo noticeVo, @PathVariable int seq) {
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		System.out.println("updated noticeVo : " + noticeVo);
		noticeservice.update(noticeVo);
		return "redirect:/cs/notice";
	}
	//공지사항 끝
	
	@GetMapping("/main")
	public String main(HttpSession session, Model model, SearchVO search){
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		model.addAttribute("noticeList", noticeservice.selectAll(search));
		model.addAttribute("faqList", faqservice.selectAll(search));
		return "cs/support";
	}

}
