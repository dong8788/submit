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
	<div style="max-width:70%;margin-top:250px;margin-left:auto;margin-right:auto">
		<table style="width:100%;margin-left:auto;margin-right:auto">
			<h4>회원가입</h4>
			<form id="register" action="<c:url value='/user/cusRegister'/>" method="get">
				<tbody style="width:100%;margin-left:auto;margin-right:auto">
					<tr align="center" style="height:3em">
						<td colspan="2"><input type="radio" name="login" value="customer" checked>회원&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="login" value="seller" checked>판매자</td>
					</tr>
					<tr height:3em">
						<td><input type="checkbox" required="required">개인정보 동의(필수)</td>
						<td><textarea rows="2" readonly="readonly" style="width:100%">2Jo 이용약관, 개인정보 수집 및 이용, 위치정보 이용약관(선택), 프로모션 정보 수신(선택)에 모두 동의합니다.
						</textarea></td>
					</tr>
					<tr style="height:3em">
						<td><input type="checkbox" required="required">2Jo 이용 약관 동의(필수)</td>
						<td><textarea rows="4" readonly="readonly" style="width:100%">여러분을 환영합니다.
2Jo 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 2Jo서비스의 이용과 관련하여 2Jo 서비스를 제공하는 2Jo(이하 ‘2Jo’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 2Jo서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.</textarea></td>
						<td></td>
					</tr>
					<tr align="center" style="height:3em">
						<td><button type="button" onclick="location.href='<c:url value="/"/>'" >취소</button></td>
						<td><button type="submit" form="register">동의</button></td>
					</tr>
				</tbody>
			</form>
		</table>
	</div>
</body>
</html>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script>
		$( "#register" ).submit(function(event){
		    console.log('이벤트 발생');
		    if ( $('input[name="login"]:checked').val() == 'seller'){
		    	$('#register').attr('action',"/ex/user/sellerRegister");
		    };
		});
	</script>
<jsp:include page="../include/footer.jsp" />