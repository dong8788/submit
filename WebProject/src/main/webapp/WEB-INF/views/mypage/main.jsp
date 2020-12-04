<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<h5>마이페이지</h5>
				</div>
				<ul class="sidebar_categories">
				<c:if test="${seller1 == null}">
					<li><a href="<c:url value='/mypage/cart'/>">장바구니</a></li>
					<li><a href="<c:url value='/mypage/polist'/>">주문목록</a></li>
					<li><a href="<c:url value='/mypage/prodquery'/>">상품문의내역</a></li>
					<li><a href="<c:url value='/user/cusModify'/>">사용자 정보 수정</a></li>
					<li><a href="<c:url value='/user/cusDelete'/>">사용자 탈퇴</a></li>
				</c:if>
				<c:if test="${seller1 != null}">
					<li><a href="<c:url value='/user/sellerModify'/>">사용자 정보 수정</a></li>
					<li><a href="<c:url value='/user/sellerDelete'/>">사용자 탈퇴</a></li>
				</c:if>
				</ul>
			</div>
		</div>
		<div class="table-wrapper" style="margin-left:250px;margin-top:200px;margin-bottom:300px;overflow-x:auto;max-width:70% ">
			<h4>마이페이지</h4>
			<br><br>
			<c:if test="${seller1 == null}">
			<table style="width:100%;">
				<thead align="center"" style="">
					<tr>
					<th>장바구니</th>
					<th>주문수량</th>
					<th>상품문의</th>					
					</tr>
				</thead>
				<tbody align="center">
					<tr>
						<td>${ cartSize }</td>
						<td>${ polistSize }</td>
						<td>${ prodquerySize } / ${ prodreplySize } </td>
					</tr>
				</tbody>
			</table>
			</c:if>
		</div>
	</div>
</body>
</html>
<jsp:include page="../include/footer.jsp" />