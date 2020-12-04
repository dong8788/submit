<%@page import="com.spring.webprj.persistence.CartDao"%>
<%@page import="com.spring.webprj.domain.CustomerVo"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.spring.webprj.service.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>2Jo Shop</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="2Jo Shop Template">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/bootstrap4/bootstrap.min.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/plugins/font-awesome-4.7.0/css/font-awesome.min.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/plugins/OwlCarousel2-2.2.1/owl.carousel.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/plugins/OwlCarousel2-2.2.1/owl.theme.default.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/plugins/OwlCarousel2-2.2.1/animate.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/main_styles.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/responsive.css'/>">

</head>

<body>

<div class="super_container">

	<!-- Header -->

	<header class="header trans_300">



		<!-- Main Navigation -->

		<div class="main_nav_container">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-right">
						<div class="logo_container">
							<a href="<c:url value='/'/>">2jo<span>shop</span></a>
							
						</div>
						
						<nav class="navbar">
						<c:if test="${seller1 == null}" >
						<form action="<c:url value='/product/search'/>" method="get">
							<input type="hidden" name="condition" value="전체">
							<input type="text" class="form-control" name="keyword" id="keywordInput" placeholder="검색"/>
							<button type="submit" class="fa fa-search" aria-hidden="true"></button>
						</form>
						</c:if>
							<ul class="navbar_user" style="margin-left:10px">
								<!-- 고객센터 -->
								<li style="width:90px"><a href="<c:url value='/cs/main'/>" style="width:90px">고객센터</a></li>
								<!-- 마이페이지 -->								
								<li><a href="<c:url value='/mypage/main'/>"><i class="fa fa-user" aria-hidden="true"></i></a></li>&nbsp;&nbsp;
								<!-- 장바구니 링크 -->
								<c:if test="${seller1 == null}" >
								<li class="checkout">
									<a href="<c:url value='/mypage/cart'/>">
										<i class="fa fa-shopping-cart" aria-hidden="true"></i>
										<c:if test='${cartSize!=null }'>
											<span id="checkout_items" class="checkout_items">
											${cartSize }
											</span>	
										</c:if>
									</a>
								</li>
								</c:if>
							</ul>
							<div class="hamburger_container">
								<i class="fa fa-bars" aria-hidden="true"></i>
							</div>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<!-- Top Navigation -->

		<div class="top_nav">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="top_nav_left">2조 웹프로젝트</div>
					</div>
					<div class="col-md-6 text-right">
						<div class="top_nav_right">
							<ul class="top_nav_menu">
							
							<!-- Category -->
							<c:if test="${seller1 == null}" >
								<li class="language">
									<a href="#">
										제품카테고리
										<i class="fa fa-angle-down"></i>
									</a>
									<ul class="language_selection">
										<li><a href="#">전자제품</a></li>
										<li><a href="#">패션</a></li>
										<li><a href="#">주방</a></li>
										<li><a href="#">가구</a></li>
										<li><a href="#">애완</a></li>
									</ul>
								</li>
							</c:if>
								<!-- My Account -->

								<li class="account">
									<c:if test="${login == null}" >
										<a href="#">
											My Account
											<i class="fa fa-angle-down"></i>
										</a>
									
										<ul class="account_selection">
											<li><a href="<c:url value='/user/login'/>"><i class="fa fa-sign-in" aria-hidden="true"></i>로그인</a></li>
											<li><a href="<c:url value='/user/register'/>" aria-hidden="true"><i class="fa fa-sign-in" aria-hidden="true"></i>회원가입</a></li>
										</ul>
									</c:if>
									<c:if test="${login != null}" >
										<a href="#">
											${login.name} 님
											<i class="fa fa-angle-down"></i>
										</a>
										<ul class="account_selection">
											<li><a href="<c:url value='/user/logout'/>"><i class="fa fa-sign-in" aria-hidden="true"></i>logout</a></li>
										</ul>
									</c:if>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
</div>
  

