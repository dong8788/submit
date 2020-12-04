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
		<br>
			<input type="hidden" name="prodSeq" value="${product.prodSeq }">
			<input type="hidden" name="poQuantity" value="${ poQuantity }">
			<input type="hidden" name="cusSeq" value="${login.cusSeq }">
			<input type="hidden" name="billingAmount" value="${(product.price + product.shippingCharge -product.discount)*poQuantity }">
			<input type="hidden" name="poStat" value="newOrder">
		<table>
			<tr>
				<td>제품 명</td><td>${ product.prodName }</td>
			<tr>
			<tr>
				<td>상품 가격</td><td>${ product.price - product.discount }원</td>
			<tr>
				<td>배송비</td><td>${product.shippingCharge }</td>
			</tr>
			<tr>
				<td>구매 수량</td><td>${poQuantity }개</td>
			</tr>
			<tr>
				<td>총 결제 금액 </td><td>${(product.price + product.shippingCharge -product.discount)*poQuantity }</td>
			</tr>
		</table>
		<br><br>
		배송 정보<br>
		<table>
			<tr>
				<td>수령인</td><td><input type="text" name="recipient" ></td>
			</tr>
			<tr>
				<td>수령인 연락처</td><td><input type="text" name="recipientPhone" ></td>
			</tr>
			<tr>
				<td>배송지 주소</td><td><input type="text" name="recipientAddr" ></td>
			</tr>
			<tr>
				<td>배송지 메모</td><td><input type="text" name="shipMemo" ></td>
			</tr>
		</table>
			<br><br>
			<button id="payForm" type="button">결재하기</button>
	</div>

</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	// getter
	$('#payForm').click(function (){
		var IMP = window.IMP; // 생략가능
		IMP.init('imp04173645'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		IMP.request_pay({
	    pg: 'inicis', // version 1.1.0부터 지원.
	    pay_method: 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : '주문명:결제테스트',
	    amount : ${(product.price + product.shippingCharge -product.discount)*poQuantity },
	    buyer_email : '${login.email}',
	    buyer_name : '${login.name}',
	    buyer_tel : '${login.phone}',
	    buyer_addr : $('input[name="recipientAddr"]').val(),
	    buyer_postcode : '123-456',
		}, function(rsp) {
	    if ( rsp.success ) {
	        var msg = '결제가 완료되었습니다.';
	        msg += '고유ID : ' + rsp.imp_uid;
	        msg += '상점 거래ID : ' + rsp.merchant_uid;
	        msg += '결제 금액 : ' + rsp.paid_amount;
	        msg += '카드 승인번호 : ' + rsp.apply_num;
	        $.ajax({
	        	 type: "POST", 
                 url: "<c:url value='/product/po'/>", //결제관련 값을 전달할 url 설정
                 data: {
                     "prodSeq" : ${product.prodSeq}, //전달 데이터 설정
                     "poQuantity" : ${ poQuantity },
                     "billingAmount" : ${(product.price + product.shippingCharge -product.discount)*poQuantity },
                     "cusSeq" : ${ login.cusSeq },
                     "payMethod" : 'card',
         			 "poStat" : "newOrder",
     				 "recipient" : $('input[name="recipient"]').val(),
     				 "recipientPhone" : $('input[name="recipientPhone"]').val(),
                     "recipientAddr" : $('input[name="recipientAddr"]').val(),
     				 "shipMemo" : $('input[name="shipMemo"]').val(),
     				 "payNum" : rsp.imp_uid
                 }
	        })
	    } else {
	        var msg = '결제에 실패하였습니다.';
	        msg += '에러내용 : ' + rsp.error_msg;
	    }
	    alert(msg);
	    document.location.href="<c:url value='/mypage/polist'/>"; //alert창 확인 후 이동할 url 설정
	})
	});
</script>
</html>
<jsp:include page="../include/footer.jsp" />