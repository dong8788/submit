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
			<h4>상품 상세페이지</h4>
			<br><br>
			<table style="width:100%;" border="1">
				<tr>
					<td>카테고리</td>
					<td>
						<select name="category">
							<option value="패션" <c:if test="${ prod.category == '패션' }">selected="selected"</c:if>>패션</option>
							<option value="잡화" <c:if test="${ prod.category == '잡화' }">selected="selected"</c:if>>잡화</option>
							<option value="뷰티" <c:if test="${ prod.category == '뷰티' }">selected="selected"</c:if>>뷰티</option>
							<option value="주방" <c:if test="${ prod.category == '주방' }">selected="selected"</c:if>>주방</option>
							<option value="가전디지털" <c:if test="${ prod.category == '가전디지털' }">selected="selected"</c:if>>가전디지털</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>제품명</td>
					<td><input type="text" name="prodName"  value="${ prod.prodName }"></td>
				</tr>
				<tr>
				<tr>
   					<td>제품사진</td>
   					<td>
   						<input type="file" id="photoUrl" name="file" />
					 	<div class="select_img"><img src="${pageContext.request.contextPath}/${ prod.photoUrl }" style="height: 100px;width: 100px"/></div>
					 </td>
				</tr>
				<tr>
					<td>제품정보</td>
					<td>${ prod.prodInfo }</td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="price" value="${ prod.price }"  readonly="readonly"></td>
				</tr>
				<tr>
					<td>할인가격</td>
					<td><input type="text" name="discount" value="${ prod.discount }"  readonly="readonly"></td>
				</tr>
				<tr>
					<td>배송비</td>
					<td><input type="text" name="shippingCharge" value="${ prod.shippingCharge }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>재고수량</td>
					<td><input type="text" name="stockNumber" value="${ prod.stockNumber }" readonly="readonly"></td>
				</tr>
			</table>
			<button onclick = "location.href='<c:url value="/seller/prodModify/${prod.prodSeq}"/>'">수정</button>
		</div>
	</div>
</body>
</html>
<jsp:include page="../include/footer.jsp" />