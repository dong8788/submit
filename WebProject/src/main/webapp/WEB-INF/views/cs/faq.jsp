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
			<div><h4>FAQ</h4></div>
			<div  style="margin-top: 6px">
				<table style="width:100%;">
					<thead align="center">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>					
							<th>작성일</th>					
							<th>조회수</th>								
						</tr>
					</thead>
					<tbody align="center">
					<c:forEach var="faq" items="${faqList}" varStatus="loop">
						<tr style="height: 2em">
							<td>${faq.faqSeq}</td>
							<td>
								<a href="<c:url value="/cs/faq/view/${faq.getFaqSeq()}"/>">
								${faq.query}</a>
							</td>
							<td>운영자</td>
							<td>${faq.regDate}</td>
							<td></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<hr width="100%">
			<div align="center">
				
			    	<c:if test="${pageMaker.prev}">
			    		<a href="<c:url value='/cs/faq/${pageMaker.makeQuery(pageMaker.startPage - 1)}'/>">이전</a>&nbsp;
			    	</c:if> 
			
				    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
				    	<a href="<c:url value='/cs/faq/${pageMaker.makeQuery(idx)}'/>">${idx}</a>&nbsp;
			    	</c:forEach>
			
				    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				    	<a href="<c:url value='/cs/faq/${pageMaker.makeQuery(pageMaker.endPage + 1)}'/>">다음</a>
			   	 	</c:if> 
			  	
			</div>
			<div align="right" style="margin-bottom: 3px; margin-top: 3px">
				<select>
					<option value="register">가입</option>
					<option value="customer">고객</option>
					<option value="seller">판매자</option>
					<option value="etc">기타</option>
				</select>
				<input type="text" placeholder="검색" name="keyword">
				<button type="button" onclick="location.href='/cs/faq/search'">검색하기</button>
				<c:if test="${login.cusId == 'admin'}">
				<button type="button" onclick="location.href='<c:url value="/cs/faq/insert"/>'">작성하기</button>
				</c:if>	
			</div>
			
		</div>
	</div>
	
</body>
</html>
<jsp:include page="../include/footer.jsp" />