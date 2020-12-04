<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a");
%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/categories_styles.css'/>">
</head>
<body>
	<div style="width:1200px;margin-left:auto;margin-right:auto">
		<div class="sidebar" style="margin-left:50px;">
			<div class="sidebar_section">
				<div class="sidebar_title">
					<h5>판매자 페이지</h5>
				</div>
				<ul class="sidebar_categories">
					<li><a href="<c:url value='/seller/prodWrite'/>">상품 등록하기</a></li>
					<li><a href="<c:url value='/seller/prodList'/>">상품조회/수정하기</a></li>
					<li><a href="<c:url value='/seller/newOrder'/>">신규주문</a></li>
					<li><a href="<c:url value='/seller/send'/>">발송처리</a></li>
					<li><a href="<c:url value='/seller/sendStat'/>">배송중/완료</a></li>
					<li><a href="<c:url value='/seller/confirmOrder'/>">구매결정 완료</a></li>
					<li><a href="<c:url value='/seller/query'/>">문의사항 관리</a></li>
				</ul>
			</div>
		</div>
		<div class="table-wrapper" style="margin-left:250px;margin-top:200px;margin-bottom:300px;overflow-x:auto;max-width:70% ">
			<h4>판매자 메인페이지</h4>
			<br><br>
			<table style="width:100%;" border="1">
				<thead align="center"" style="height: 3em">
					<tr style="height: 6em">
					<th style="width:25%"><%= sf.format(nowTime) %></th>
					<th style="width:25%">신규 주문</th>
					<th style="width:25%">발송 처리</th>					
					<th style="width:25%">상품 문의</th>					
					</tr>
				</thead>
			</table>
			<br><br><br>
			<table style="width:100%;">
				<thead align="center"" style="height: 3em">
					<tr>
						<th>주문</th>
						<th>배송</th>					
						<th>상품문의</th>					
					</tr>
				</thead>
				<tbody align="center" style="height: 3em">
					<tr style="height: 3em">
						<td>신규 주문 : 1</td>
						<td>배송 중 : 1</td>
						<td>상품 문의 : 1</td>
					</tr>
					<tr style="height: 3em">
						<td>발송 필요 : 1</td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
<jsp:include page="../include/footer.jsp" />