<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="./include/header.jsp" />

<html>
<body>
<!-- Slider -->

	<div class="main_slider" style="background-image:url(<c:url value='/images/slider_1.jpg'/>)">
		<div class="container fill_height">
			<div class="row align-items-center fill_height">
				<div class="col">
					<div class="main_slider_content">
						<h6>Spring / Summer Collection 2017</h6>
						<h1>Get up to 30% Off New Arrivals</h1>
						<div class="red_button shop_now_button"><a href="<c:url value='/product/content'/>">shop now</a></div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script>
	const msg = "${msg}";
	if(msg === "not-login"){
		alert("로그인이 필요한 페이지 입니다.");
	}
</script>
</html>

<jsp:include page="./include/footer.jsp" />