<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="po" style="width:500px;margin-top:200px;margin-left:auto;margin-right:auto">
		결제 내역<br>
	<div class="table-wrapper" style="margin-left:250px;margin-top:200px;margin-bottom:300px;overflow-x:auto;max-width:70% ">
		<h4>마이페이지</h4>
		<br><br>
		<form action="<c:url value='/product/po'/>" method="post">
		<table style="width:100%;">
			<thead align="center"" style="">
				<tr>
					<th>썸네일</th>
					<th>상품명</th>
					<th>제품단일가격</th>					
					<th>배송비</th>					
					<th>주문수량</th>					
					<th>주문금액</th>					
				</tr>
			</thead>
			<tbody align="center">
			<c:forEach var="cartProduct" items="${ cartProductList }" varStatus="loop">
				<input type="hidden" name="prodSeq" value="${ cartProduct.prodSeq }">
				<input type="hidden" name="cusSeq" value="${ login.cusSeq }">
				<tr>
					<td></td>
					<td><input type="text" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" value="${cartProduct.prodName}" readonly="readonly"></td>
					<td><input type="text" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" value="${cartProduct.price - cartProduct.discount}" readonly="readonly"></td>
					<td><input type="text" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" value="${cartProduct.shippingCharge}" readonly="readonly"></td>
					<td><input type="text" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" value="${cartProduct.PoQuantity}" readonly="readonly"></td>
					<td class="row_value"><input type="text" name="billingAmount" value="${cartProduct.PoQuantity*(cartProduct.price - cartProduct.discount + cartProduct.shippingCharge)}"  readonly="readonly"></td>						
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"></td><td class="row_sum"></td>
			</tr>
			</tbody>
		</table>
		</div>
		<br><br>
		배송 정보<br>
			<input type="hidden" name="payNum" value=1>
			<input type="hidden" name="poStat" value="newOrder">
			수령인 : <input type="text" name="recipient" ><br>
			수령인 연락처 : <input type="text" name="recipientPhone" ><br>
			배송지 주소 : <input type="text" name="recipientAddr" ><br>
			배송지 메모 : <input type="text" name="shipMemo" ><br><br>
			<br><br>
			결제 수단<br>
			<ul>
		    	<li>
		        	<input type="radio" name="payMethod" value="easyaccount" checked>계좌 간편 결제
		    	</li>
		    	<li>
		        	<input type="radio" name="payMethod" value="easycard">카드 간편 결제
		      	</li>
		      	<li>
		      		<input type="radio" name="payMethod" value="normal">일반 결제
		      	</li>
	  			</ul>
			<input type="submit" value="결제하기">
		</form>
	</div>

</body>
   <script>
		function renameForModelAttribute(){
			$(this).find("input[name=prodSeq]").attr("name", "poVos[" + index + "].prodSeq");
			$(this).find("input[name=cusSeq]").attr("name", "poVos[" + index + "].cusSeq");
		}
		
       $(document).ready(function () {
           $(".row_sum").each(function () {
               var $this = $(this);
               var sum_value = 0;
               $(".row_value",$this.closest('tr')).each(function (i, e) {
                   sum_value+=parseInt($(e).text());
               })
               $this.text(sum_value);
           })
       })
   </script>
</html>
<jsp:include page="../include/footer.jsp" />