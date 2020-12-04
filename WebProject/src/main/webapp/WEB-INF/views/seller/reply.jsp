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
			<h4>문의사항 답변</h4>
			<br><br>
			<form action="<c:url value='/seller/reply/${query.querySeq }'/>" method="post">
			<table style="width:100%;" border="1">
				<tbody align="center" style="height: 3em">
					<tr style="height: 3em">
						<td>상품명</td>
						<td>${ query.prodName }</td>
					</tr>
					<tr>
						<td>문의제목</td>
						<td>${ query.title }</td>
					</tr>
					<tr>
						<td>문의내용</td>
						<td>${ query.content }</td>
					</tr>
					<tr>
						<td>문의 일시</td>
						<td>${ query.qregDate }</td>
					</tr>
					<tr>
						<td>답변 내용</td>
						<td><textarea name="reply" style="width:100%">${query.reply }</textarea></td>
					</tr>
				</tbody>
			</table>
			<div align="right"><button class="confirmBtn" type="submit">답변하기</button></div>
			</form>
		</div>
	</div>
</body>
</html>
<jsp:include page="../include/footer.jsp" />