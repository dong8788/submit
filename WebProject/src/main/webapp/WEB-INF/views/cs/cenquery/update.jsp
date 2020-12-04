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
<script src="https://cdn.ckeditor.com/ckeditor5/23.1.0/classic/ckeditor.js"></script>
<style>
.ck-editor__editable {
    min-height: 250px;
    max-width: 600px;
}
</style>
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
		<form action="${pageContext.request.contextPath}/cs/cenquery/update" method="post">
		<input type="hidden" name="cenQuerySeq" value="${cenquery.cenQuerySeq}">
		<c:if test="${cenquery.reply != null }">
			<input type="hidden" name="reply" value="${cenquery.reply }">
		</c:if>
		<table style="width:70%">
		<tr>
			<th style="width:50px">제목</th>
			<td style="width:500px"><input type="text" name="title" value="${ cenquery.title }"></td>
		</tr>
		<tr>
			<th>공개여부</th>
			<td>
				<select name='open'>
					<option value="공개" <c:if test="${cenquery.open == '공개'}"> selected="selected"</c:if>>공개</option>
					<option value="비공개" <c:if test="${cenquery.open == '비공개'}"> selected="selected"</c:if>>비공개</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>분류</th>
			<td>
				<select name='queryType'>
					<option value="가입" <c:if test="${cenquery.queryType == '가입'}"> selected="selected"</c:if> >가입</option>
					<option value="고객" <c:if test="${cenquery.queryType == '고객'}"> selected="selected"</c:if> >고객</option>
					<option value="판매자" <c:if test="${cenquery.queryType == '판매자'}"> selected="selected"</c:if> >판매자</option>
					<option value="기타" <c:if test="${cenquery.queryType == '기타'}"> selected="selected"</c:if> >기타</option>
				</select>
			</td>
		</tr>
		<tr><th style="width:50px">질문</th>
			<td style="height:100px; width:100px">
				<textarea name="content" id="editor" style="height:200px; width:400px">${cenquery.content}</textarea>
				<script>
				ClassicEditor
				    .create( document.querySelector( '#editor' ), {
				    	toolbar: [ 'heading', '|', 'bold', 'italic', '|', 'undo', 'redo']
				        }
				    )
				    .catch( error => {
				        console.error( error );
				    	} 
					);
			</script>
			</td>
		</tr>
		</table>
		<div align="right"><button type="submit">수정</button></div>
		</form>
		</div>
	</div>
</body>
</html>
<jsp:include page="../../include/footer.jsp" />