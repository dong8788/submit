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
			<h4>문의사항 관리</h4>
			<br><br>
			<table style="width:100%;" border="1">
				<thead align="center" style="height: 3em">
					<tr style="height: 3em">
					<th>상품명</th>
					<th style="width:100px">문의제목</th>
					<th>문의일시</th>
					<th>답변상태</th>									
					<th></th>
					</tr>
				</thead>
				<tbody align="center" style="height: 3em">
				<c:forEach var="query" items="${ querylist}" varStatus="loop">
					<tr style="height: 3em">
						<td>${ query.prodName }</td>
						<td>${ query.title }</td>
						<td>${ query.qregDate }</td>
						<td>
							<c:choose>
								<c:when test="${query.reply != null }">Y</c:when>
								<c:when test="${query.reply == null }">N</c:when>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${query.reply != null }"><button onclick="location.href='<c:url value="/seller/reply/${ query.querySeq }"/>'">답변수정</button></c:when>
								<c:when test="${query.reply == null }"><button onclick="location.href='<c:url value="/seller/reply/${ query.querySeq }"/>'">답변하기</button></c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
<jsp:include page="../include/footer.jsp" />