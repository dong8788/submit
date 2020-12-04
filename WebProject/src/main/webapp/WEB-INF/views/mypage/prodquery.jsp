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
			<h4>상품문의내역</h4>
			<br><br>
			<table style="width:100%;">
				<thead align="center" style="height: 3em">
					<tr>
						<th>상품명</th>
						<th>문의제목</th>					
						<th>문의일시</th>					
						<th>답변상태</th>					
					</tr>
				</thead>
				<tbody >
				<c:forEach var="queryProduct" items="${ queryProductList }" varStatus="loop">
					<tr align="center" style="height: 3em">
						<td><input type="text" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;text-align: center;" value="${queryProduct.prodName}" readonly="readonly"></td>
						<td><input type="text" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;text-align: center;" value="${queryProduct.title}" readonly="readonly"></td>
						<td><input type="text" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;text-align: center;" value="${queryProduct.qregDate}" readonly="readonly"></td>
						<td><input type="text" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;text-align: center;" value="${queryProduct.reply}" readonly="readonly"></td>		
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
<jsp:include page="../include/footer.jsp" />