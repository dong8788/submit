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
		<form action="${pageContext.request.contextPath}/cs/faq/insert" method="post">
		<table style="width:70%">
		<tr><th>분류</th>
			<td>
				<select name="faqCategory">
					<option value="가입" selected>가입</option>
					<option value="고객">고객</option>
					<option value="판매자">판매자</option>
					<option value="기타">기타</option>
				</select>
			</td>
		</tr>
		<tr><th style="width:50px">질문</th>
			<td style="height:100px; width:100px">
			<textarea name="query" id="editor"></textarea>
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
		<tr><th>답변</th>
			<td style="height:100px; width:100px">
			<textarea name="reply" id="editor2"></textarea>
			<script>
				ClassicEditor
				    .create( document.querySelector( '#editor2' ), {
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
		<div align="right"><button type="submit">등록</button></div>
		</form>
		</div>
	</div>
</body>
</html>
<jsp:include page="../../include/footer.jsp" />