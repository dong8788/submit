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
		<table style="width:250px;margin-left:auto;margin-right:auto">

				<h4>로그인</h4>
				<hr width="100%">
				<tbody>
					<form id="loginForm" action="<c:url value='/user/login'/>" method="post">
					<tr align="center" style="height:3em">
						<td colspan="3"><input type="radio" name="login" value="customer" checked>회원&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="login" value="seller" checked>판매자</td>
					</tr>
					<tr style="height:6em">
						<td colspan="2" align="center"><input type="text" id="Id" name="cusId" placeholder="User id" max="20"><br>
						<input type="password" name="password" placeholder="User pw" max="20"></td>
						<td><input type="submit" value="로그인" style="width:100%"></td>
					</tr>
					</form>
					<tr>
						<td colspan="3" style="height:3em"><input type="checkbox" value="idSave">아이디 저장</td>
					</tr>
					<tr>
						<td><a href="<c:url value='/user/searchid'/>">아이디 찾기</a></td>
						<td><a href="<c:url value='/user/searchpw'/>">비밀번호 찾기</a></td>
						<td><a href="<c:url value='/user/register'/>">회원가입</a></td>
					</tr>
				</tbody>

		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script>
	const msg = "${msg}";
	if(msg === "not-login"){
		alert("고객정보를 확인하세요");
	}
	
	$( "#loginForm" ).submit(function(event){
	    console.log('이벤트 발생');
	    if ( $('input[name="login"]:checked').val() == 'seller'){
	    	$('#Id').attr('name','id');
	    	$('#loginForm').attr('action',"/ex/user/sellerLogin");
	    };
	});
	
	</script>
</body>
</html>
<jsp:include page="../include/footer.jsp" />