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
		<table style="width:400px;margin-left:auto;margin-right:auto">

				<h4>회원 탈퇴</h4>
				<tbody>
					<form id="loginForm" action="<c:url value='/user/cusDelete'/>" method="post">
					<tr>	
						<td><input type="password" name="password" placeholder="암호를 입력하세요" max="20" style="width: 100%"></td>
						<td><input type="submit" value="탈퇴" style="width:100%"></td>

					</tr>
					<tr>
						<td colspan="2"><input type="checkbox" required="required">탈퇴에 동의합니다.</td>
					</tr>
					</form>
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
<script>
	const msg = "${msg}";
	if(msg === "passwordError"){
		alert("비밀번호가 잘못되었습니다.");
	}
</script>
</html>
<jsp:include page="../include/footer.jsp" />