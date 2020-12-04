<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/header.jsp" />
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
					<h5>고객 센터</h5>
				</div>
				<ul class="sidebar_categories">
					<li><a href="<c:url value='/cs/notice'/>">공지 사항</a></li>
					<li><a href="<c:url value='/cs/faq'/>">FAQ</a></li>
					<li><a href="<c:url value='/cs/cenquery'/>">문의 사항</a></li>
				</ul>
			</div>
		</div>
		<div class="table-wrapper" style="margin-left:250px;margin-top:200px;overflow-x:auto;max-width:70% ">
		<h4>${noticeVo.getTitle()}</h4>
		<hr>
			<table style="width:50%">
			<thead>
			</thead>
			<tbody>
				<tr><th>분류</th><td>${faqVo.getFaqCategory()}</td></tr>
				<tr><th>질문</th><td style="height:200px; width:300px">${faqVo.getQuery()}</td></tr>
				<tr><th>답변</th><td style="height:200px; width:300px">${faqVo.getReply()}</td></tr>
				<tr><th>작성일</th><td>${faqVo.getRegDate()}</td></tr>
			</tbody>
			<tfoot>
			</tfoot>
			</table>
			<hr>
			<a href="<c:url value="/cs/faq"/>">목록</a>
			<c:if test="${seller1 == null }">
				<c:if test="${login.cusId == 'admin' }">
					<a href="<c:url value="/cs/faq/update/${faqVo.getFaqSeq()}"/>">수정</a>&nbsp;
					<a href="<c:url value="/cs/faq/delete/${faqVo.getFaqSeq()}"/>">삭제</a>
				</c:if>
			</c:if>
		</div>
	</div>
</body>
</html>
<jsp:include page="../../include/footer.jsp" />