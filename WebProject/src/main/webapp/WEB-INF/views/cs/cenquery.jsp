<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<div><h4>문의사항</h4></div>
			<hr width="100%">
				<div  style="margin-top: 6px"">
					<table style="width:100%;">
						<thead align="center"" >
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>					
								<th>작성일</th>					
								<th>조회수</th>								
							</tr>
						</thead>
						<tbody align="center">
						<c:forEach var="userCenQuery" items="${userCenQueryList}" varStatus="loop">
							<tr style="height: 2em">
								<td>${userCenQuery.cenQuerySeq}</td>
								<td><a href="<c:url value='/cs/cenquery/view/${userCenQuery.cenQuerySeq}'/>">${userCenQuery.title}</a></td>
								<c:if test="${userCenQuery.sellerSeq == 0}">
									<td>고객 ${userCenQuery.cusId }</td>
								</c:if>
								<c:if test="${userCenQuery.sellerSeq != 0}">
									<td>판매자 ${userCenQuery.id }</td>
								</c:if>
								<td>${cenQuery.regDate}</td>
								<td></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<hr width="100%">
				<div align="center">
					
				    	<c:if test="${pageMaker.prev}">
				    		<a href="<c:url value='/cs/cenquery/${pageMaker.makeSearch(pageMaker.startPage - 1)}'/>">이전</a>&nbsp;
				    	</c:if> 
				
					    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
					    	<a href="<c:url value='/cs/cenquery/${pageMaker.makeSearch(idx)}'/>">${idx}</a>&nbsp;
				    	</c:forEach>
				
					    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					    	<a href="<c:url value='/cs/cenquery/${pageMaker.makeSearch(pageMaker.endPage + 1)}'/>">다음</a>
				   	 	</c:if> 
				  	
				</div>
			<form role="form" method="get" action="<c:url value='/cs/cenquery'/>">
			<div align="right" style="margin-bottom: 3px; margin-top: 3px">
				<select name='condition'>
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="titleContent">제목+내용</option>
				</select>
				<input type="text" placeholder="검색" name="keyword">
				<button type="submit">검색하기</button>
				<c:if test="${ login != null }">
					<button type="button" onclick="location.href='<c:url value="/cs/cenquery/write"/>'">작성하기</button>
				</c:if>
			</div>
			</form>
		</div>
	</div>
</body>
</html>
<jsp:include page="../include/footer.jsp" />