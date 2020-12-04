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
    min-height: 300px;
    max-width: 800px;
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
		<form action="${pageContext.request.contextPath}/cs/notice/write" method="post">
		<table style="width:100%">
			<tr>
				<th style="width:50px">제목</th>
				<td style="width:500px"><input type="text" name="title" required="required"></td>
			</tr>
			<tr>
				<th>분류</th>
				<td>
					판매자<input type="radio" name="noticeCategory" value='판매자' checked>&nbsp;
					구매자<input type="radio" name="noticeCategory" value='구매자'>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" id="editor"></textarea>
					<script>
				    ClassicEditor
				        .create( document.querySelector( '#editor' ), {
				        	toolbar: [ 'heading', '|', 'bold', 'italic', '|', 'undo', 'redo']
				            /*heading: {
				                options: [
				                    { model: 'paragraph', title: 'Paragraph', class: 'ck-heading_paragraph' },
				                    { model: 'heading1', view: 'h2', title: 'Heading 1', class: 'ck-heading_heading1' },
				                    { model: 'heading2', view: 'h3', title: 'Heading 2', class: 'ck-heading_heading2' },
				                    { model: 'heading3', view: 'h4', title: 'Heading 3', class: 'ck-heading_heading3' }
				                ]
				            }
				        	
				        	simpleUpload: {
				                uploadUrl: '/fileupload',
				            },
				            */
				        		// 제거 하고싶은 플러그인 (배열)
				                //removePlugins: [ 'ImageUpload', 'Link', 'BulletedList']
				        	}
				        )
				        .catch( error => {
				            console.error( error );
				        } );
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