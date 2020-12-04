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
			<h4>회원가입</h4>
			<form action="<c:url value='/user/cusModify'/>" method="post">
				<tbody>
					<tr style="height:3em">
						<td>아이디</td>
						<td><input type="text" name="cusId" value="${login.cusId }" max="20" readonly="readonly"></td>
						<td></td>
					</tr>
					<tr style="height:3em">
						<td>비밀번호</td>
						<td><input type="password" name="password" placeholder="암호를 입력하세요" max="20"></td>
						<td></td>
					</tr>
					<tr style="height:3em">
						<td>비밀번호 확인</td>
						<td><input type="password" name="passwordCheck" placeholder="암호 확인" max="20"></td>
						<td></td>
					</tr>
					<tr style="height:3em">
						<td>고객 이름</a></td>
						<td><input type="text" name="name" value="${login.name }" max="20" readonly="readonly"></td>
						<td></td>
					</tr>
					<tr style="height:3em">
						<td>휴대전화</td>
						<td><input type="text" name="phone" value="${login.phone }" max="20"></td>
						<td></td>
					</tr>
					<tr style="height:3em">
						<td>이메일</td>
						<td><input type="email" name="email" value="${login.email }" max="20"></td>
						<td></td>
					</tr>
					<tr style="height:3em">
						<td>인증번호</td>
						<td><input type="text" name="authkey" placeholder="인증번호" max="20"></td>
						<td><button class="authkey-confirm" style="width:100%; height: 100%">인증확인</button></td>
					</tr>
					<tr style="height:3em">
						<td colspan="3" align="right"><input type="submit" value="정보수정하기"></td>
					</tr>
				</tbody>
			</form>
		</table>
	</div>
</body>
</html>
<jsp:include page="../include/footer.jsp" />