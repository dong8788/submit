<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
   <h5>제품 리뷰 작성</h5>
</div>

<div>
<form action="<c:url value='/mypage/reviewWrite/insert'/>" method="post">
   <table>
      <tr><td>제품명</td><td><input type="text" value="${product.prodName}" readonly></td></tr>
      <tr><td>별점</td>
      <td>
      
      <input type="radio" name="score" value="1">1점<br>
      <input type="radio" name="score" value="2">2점<br>
      <input type="radio" name="score" value="3">3점<br>
      <input type="radio" name="score" value="4">4점<br>
      <input type="radio" name="score" value="5" checked="checked">5점<br>
      </td>
      </tr>
      <tr><td>제목</td><td><input type="text" name="title"></td></tr>
      <tr><td>내용</td><td><input type="text" name="content"></td></tr>
   </table>
   <input type="hidden" name="prodSeq" value="${product.prodSeq}">
   <input type="hidden" name="cusId" value="${cusId}">
   <input type="submit" value="리뷰 등록">

</form>

</div>

</body>
</html>