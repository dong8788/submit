package com.spring.webprj;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// session 객체를 가져옴
        HttpSession session = request.getSession();
        // login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
        Object obj = session.getAttribute("login");
          
        if ( obj == null ){
            // 로그인이 안되어 있는 상태임으로 로그인 폼으로 다시 돌려보냄(redirect를 쓰려했으나 alert창을 띄우기 위해 아래와 같이 작성)
        	response.setCharacterEncoding("UTF-8"); 
        	response.setContentType("text/html; charset=UTF-8");
        	PrintWriter out = response.getWriter();
        	out.println("<script>alert('로그인이 필요한 페이지입니다.'); location.href='/ex/user/login';</script>");
            //response.sendRedirect("/ex/user/login");
            
            return false; // 더이상 컨트롤러 요청으로 가지 않도록 false로 반환함
        } 
          
        // preHandle의 return은 컨트롤러 요청 uri로 가도 되냐 안되냐를 허가하는 의미임
        // 따라서 true로하면 컨트롤러 uri로 가게 됨.
        return true;
	}
}
