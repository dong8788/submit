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
			<h4>발송 처리</h4>
			<br><br>
			<form name="frmJoin" onSubmit="return CheckForm(this)" action="<c:url value='/seller/send'/>" method="post">
			<input type="hidden" class="poStat" name="poStat" value="">
			<table style="width:100%;" border="1">
				<thead align="center" style="height: 3em">
					<tr style="height: 3em">
					<th></th>
					<th style="width:100px">주문번호</th>
					<th>상품명</th>
					<th>주문수량</th>					
					<th>주문금액</th>					
					<th>주문상태</th> 
					<th>택배사</th>					
					<th>운송장번호</th>					
					</tr>
				</thead>
				<tbody align="center" style="height: 3em">
				<c:forEach var="po" items="${ Orderlist}" varStatus="loop">
					<tr style="height: 3em">
						<td><input type="checkbox" name="poNum" value="${ po.poNum }" ></td>
						<td>${ po.poNum }</td>
						<td>${ po.prodName }</td>
						<td>${ po.poQuantity }</td>
						<td>${ po.poQuantity*(po.price - po.discount) }</td>
						<td>구매확인</td>
						<td>
						<select name="courier" required="required">
							<option value="경동택배">경동택배</option>
							<option value="롯데택배">롯데택배</option>
						</select>
						</td>
						<td><input type="text" name="shippingNum" required="required"></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div align="right"><button class="confirmBtn" type="submit">발송</button></div>
			</form>
		</div>
	</div>
</body>

	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script>
	

	$('.confirmBtn').on('click',function(){
			$('.poStat').attr('value','ship');
	 });
	
	function CheckForm(Join){



		var ispoNumChk = false;
		var arr_poNum = document.getElementsByName("poNum");
		for(var i=0;i<arr_poNum.length;i++){
		    if(arr_poNum[i].checked == true) {
		        ispoNumChk = true;
		        break;
		    }
		}
		
		if(!ispoNumChk){
		    alert("한개 주문 이상 선택해주세요.");
		    return false;
		}
	}
	
	</script>

</html>
<jsp:include page="../include/footer.jsp" />