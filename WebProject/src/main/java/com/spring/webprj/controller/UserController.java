package com.spring.webprj.controller;

import java.io.PrintWriter;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.webprj.domain.CustomerVo;
import com.spring.webprj.domain.SellerVo;
import com.spring.webprj.service.CartService;
import com.spring.webprj.service.CustomerService;
import com.spring.webprj.service.SellerService;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@ResponseBody
	@RequestMapping(value="/sellerIdChk", method = RequestMethod.POST)
	public int sellerIdChk(SellerVo vo) throws Exception{
		System.out.println(vo);
		int result = sellservice.sellerIdChk(vo);
		return result;
	}
	
	@Inject    //서비스를 호출하기 위해서 의존성을 주입
    JavaMailSender mailSender;     //메일 서비스를 사용하기 위해 의존성을 주입함.
	@Autowired
	private CustomerService cusservice;
	
	@Autowired
	private SellerService sellservice;
	
	@Autowired
	private CartService cartservice;
	
	@GetMapping("/login")
	public void login() {
		System.out.println("user:login");
	}
	
	@PostMapping("/login")
	public String login(CustomerVo cus, HttpSession session, RedirectAttributes ra) {
		System.out.println("user:login");
		System.out.println(cus);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(cusservice.checkCusId(cus.getCusId()));
		if(cusservice.checkCusId(cus.getCusId())==1) {
			if(encoder.matches(cus.getPassword(), cusservice.select(cus.getCusId()).getPassword())) {
				session.setAttribute("login", cusservice.select(cus.getCusId()));
				return "redirect:/";
			} else {
				ra.addFlashAttribute("msg","not-login");
				return "redirect:/user/login";
			}
		}else {
			ra.addFlashAttribute("msg","not-login");
			return "redirect:/user/login";
		}
		
	}
	
	@PostMapping("/sellerLogin")
	public String login(SellerVo seller, HttpSession session, RedirectAttributes ra) {
		System.out.println("seller:login");
		System.out.println(seller);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(sellservice.checkSellerId(seller.getId())==1) {
			if(encoder.matches(seller.getPassword(), sellservice.select(seller.getId()).getPassword())) {
				session.setAttribute("login", sellservice.select(seller.getId()));
				session.setAttribute("seller1", "판매자용로그인");
				return "/seller/main";
			}else {
				ra.addFlashAttribute("msg","not-login");
				return "redirect:/user/login";
			}
		}else {
			ra.addFlashAttribute("msg","not-login");
			return "redirect:/user/login";
		}
		
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("login");
		session.removeAttribute("seller");
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/register")
	public void register() {
		System.out.println("user:register");
	}
	
	@GetMapping("/cusRegister")
	public void cusRegister() {
		System.out.println("user:cusRegister");
	}
	
	@PostMapping("/cusRegister")
	public String cusregister(CustomerVo cus) {
		System.out.println("user:register 회원가입");
		cusservice.insert(cus);
		return "/user/login";
	}
	
	@GetMapping("/sellerRegister")
	public void sellerRegister() {
		System.out.println("user:sellerRegister");
	}
	
	@PostMapping("/sellerRegister")
	public String register(SellerVo seller) {
		System.out.println("user:register 회원가입");
		System.out.println(seller);
		sellservice.insert(seller);
		return "/user/login";
	}
	
	@GetMapping("/cusModify")
	public String cusModify(HttpSession session, RedirectAttributes ra, Model model) {
		System.out.println("user:cusModify");
		if(session.getAttribute("login") == null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			if(session.getAttribute("seller1") == null) {
				int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
				model.addAttribute("cartSize", cartSize);
			}
			return "/user/cusModify";
		}
	}
	
	@PostMapping("/cusModify")
	public String cusModify(CustomerVo cus) {
		System.out.println("user:cusModify Post");
		cusservice.update(cus);
			return "/home";
	}
	
	@GetMapping("/cusDelete")
	public String cusDelete(HttpSession session, RedirectAttributes ra) {
		System.out.println("user:cusDelete");
		if(session.getAttribute("login") == null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			return "/user/cusDelete";
		}
	}
	
	@PostMapping("/cusDelete")
	public String cusDelete(HttpSession session, String password, RedirectAttributes ra ) {
		System.out.println("user:cusModify Post");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(password, ((CustomerVo)session.getAttribute("login")).getPassword())) {
			cusservice.delete(((CustomerVo)session.getAttribute("login")).getCusSeq());
			session.removeAttribute("login");
			session.invalidate();
			return "/home";
		} else {
			ra.addAttribute("msg","passwordError");
			return "redirect:/user/cusDelete";
		}
		
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="/emailChk", method = RequestMethod.POST)
	public String sellerIdChk(HttpServletRequest request, String e_mail, HttpServletResponse response_email) throws Exception{
		Random r = new Random();
        int dice = r.nextInt(4589362) + 49311; //이메일로 받는 인증코드 부분 (난수)
        String setfrom = "2jotestyong@gamil.com";
        String tomail = request.getParameter("email"); // 받는 사람 이메일
        String title = "회원가입 인증 이메일 입니다."; // 제목
        String content =
        
        System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
        
        System.getProperty("line.separator")+
                
        "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+

        " 인증번호는 " +dice+ " 입니다. "
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
        
        
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");

            messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
            messageHelper.setTo(tomail); // 받는사람 이메일
            messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
            messageHelper.setText(content); // 메일 내용
            
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        response_email.setContentType("text/html; charset=UTF-8");
        //PrintWriter out_email = response_email.getWriter();
        //out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
        //out_email.flush();
        
        String dicestr = String.valueOf(dice);
        
        System.out.println(dicestr);
        
        return dicestr;
	}
	
}
