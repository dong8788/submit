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
		<h4>${cenquery.title}</h4>
		<hr>
			<table style="width:50%">
				<thead>
				</thead>
				<tbody>
					<!--<tr><th>제목</th><td>${noticeVo.getTitle()}</td></tr>-->
					<tr><th>공개여부</th><td>${cenquery.open}</td></tr>
					<tr><th>분류</th><td>${cenquery.queryType}</td></tr>
					<tr><th>내용</th>
						<td style="height:100px; width:300px">
						${cenquery.content}
						</td>
					</tr>
					<tr><th>작성일</th><td>${cenquery.regDate}</td></tr>
				</tbody>
				<tfoot>
				
				</tfoot>
			</table>
			<hr>
			<a href="<c:url value="/cs/cenquery"/>">목록</a>
			<c:if test="${seller1 != null }">
				<c:if test="${login.sellerSeq == cenquery.sellerSeq }">
					<a href="<c:url value="/cs/cenquery/update/${cenquery.cenQuerySeq}"/>">수정</a>
					<a href="<c:url value="/cs/cenquery/delete/${cenquery.cenQuerySeq}"/>">삭제</a>
				</c:if>
			</c:if>
			<c:if test="${seller1 == null }">
				<c:if test="${login.cusSeq == cenquery.cusSeq }">
					<a href="<c:url value="/cs/cenquery/update/${cenquery.cenQuerySeq}"/>">수정</a>
					<a href="<c:url value="/cs/cenquery/delete/${cenquery.cenQuerySeq}"/>">삭제</a>
				</c:if>
			</c:if>
			
		</div>
	</div>
</body>
</html>
<jsp:include page="../../include/footer.jsp" />