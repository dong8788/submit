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
			<h4>장바구니</h4>
			<br><br>
			<form action="" method="post">
			<input type="hidden" name="cusId" value="${ login.cusId }">
			<table style="width:100%;">
				<thead align="center"" style="">
					<tr>
						<th>썸네일</th>
						<th>상품명</th>
						<th>제품단일가격</th>					
						<th>배송비</th>					
						<th>주문수량</th>					
						<th>주문금액</th>					
						<th></th>
					</tr>
				</thead>
				
				<tbody align="center">
				<c:forEach var="cartProduct" items="${ cartProductList }" varStatus="loop">
				<input type="hidden" name="prodSeq" value="${ cartProduct.prodSeq }">
					<tr>
						<td></td>
						<td>${cartProduct.prodName}</td>
						<td>${cartProduct.price - cartProduct.discount}</td>
						<td>${cartProduct.shippingCharge}</td>
						<td><input type="text" name="poQuantity" value="${cartProduct.poQuantity}" readonly="readonly"></td>
						<td class="row_value"><input type="text" name="billingAmount" value="${cartProduct.poQuantity*(cartProduct.price - cartProduct.discount + cartProduct.shippingCharge)}" readonly="readonly"></td>						
						<td><button type="button" onclick="location.href='<c:url value="/mypage/cartDelete/${ cartProduct.cartSeq }"/>'">삭제</button></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5"></td><td class="row_sum"></td><td></td>
				</tr>
				</tbody>
			</table>
			<div align="right"><input type="submit" value="구매하기"></div>
			</form>
		</div>
	</div>
</body>
<script>
    $(document).ready(function () {
        $(".row_sum").each(function () {
            var $this = $(this);
            var sum_value = 0;
            $(".row_value",$this.closest('td')).each(function (i, e) {
                sum_value+=parseInt($(e).text());
            })
            $this.text(sum_value);
        })
    })
</script>
</html>
<jsp:include page="../include/footer.jsp" />