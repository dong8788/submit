<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<jsp:include page="../include/header.jsp" />
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="<c:url value='/plugins/themify-icons/themify-icons.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/plugins/jquery-ui-1.12.1.custom/jquery-ui.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/single_styles.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/single_responsive.css'/>">
<body>
	<div class="container single_product_container">
		<div class="row">
			<div class="col">

				<!-- Breadcrumbs -->

				<div class="breadcrumbs d-flex flex-row align-items-center">
					<ul>
						<li><a href="index.html">Home</a></li>
						<li><a href="categories.html"><i class="fa fa-angle-right" aria-hidden="true"></i>Men's</a></li>
						<li class="active"><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i>Single Product</a></li>
					</ul>
				</div>

			</div>
		</div>

		<div class="row">
			<div class="col-lg-7">
				<div class="single_product_pics">
					<div class="row">
						<div class="col-lg-3 thumbnails_col order-lg-1 order-2">
							<div class="single_product_thumbnails">
								<ul>
									<li><img src="<c:url value='/images/single_1_thumb.jpg'/>" alt="" data-image="<c:url value='/images/single_1.jpg'/>"></li>
									<li class="active"><img src="<c:url value='/images/single_2_thumb.jpg'/>" alt="" data-image="<c:url value='/images/single_2.jpg'/>"></li>
									<li><img src="<c:url value='/images/single_3_thumb.jpg'/>" alt="" data-image="<c:url value='/images/single_3.jpg'/>"></li>
								</ul>
							</div>
						</div>
						<div class="col-lg-9 image_col order-lg-2 order-1">
							<div class="single_product_image">
								<div class="single_product_image_background" style="background-image:url(<c:url value='/images/single_2.jpg'/>)"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-5">
				<div class="product_details">
					<div class="product_details_title">
						<h2>Pocket cotton sweatshirt</h2>
						<p>Nam tempus turpis at metus scelerisque placerat nulla deumantos solicitud felis. Pellentesque diam dolor, elementum etos lobortis des mollis ut...</p>
					</div>
					<div class="free_delivery d-flex flex-row align-items-center justify-content-center">
						<span class="ti-truck"></span><span>free delivery</span>
					</div>
					<div class="original_price">12000원</div>
					<div class="product_price">10000원</div>
					<ul class="star_rating">
						<li><i class="fa fa-star" aria-hidden="true"></i></li>
						<li><i class="fa fa-star" aria-hidden="true"></i></li>
						<li><i class="fa fa-star" aria-hidden="true"></i></li>
						<li><i class="fa fa-star" aria-hidden="true"></i></li>
						<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
					</ul>
					<!-- <div class="product_color">
						<span>Select Color:</span>
						<ul>
							<li style="background: #e54e5d"></li>
							<li style="background: #252525"></li>
							<li style="background: #60b3f3"></li>
						</ul>
					</div> -->
					<div class="quantity d-flex flex-column flex-sm-row align-items-sm-center">
						<span>Quantity:</span>
						<div class="quantity_selector">
							<span class="minus"><i class="fa fa-minus" aria-hidden="true"></i></span>
							<span id="quantity_value">1</span>
							<span class="plus"><i class="fa fa-plus" aria-hidden="true"></i></span>
						</div>
						<div class="red_button add_to_cart_button"><a href="#">add to cart</a></div>
						<div class="product_favorite d-flex flex-column align-items-center justify-content-center"></div>
					</div>
					<div>
						<div class="red_button shop_now_button"><a href="<c:url value='/product/po'/>">shop now</a></div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Tabs -->

	<div class="tabs_section_container">

		<div class="container">
			<div class="row">
				<div class="col">
					<div class="tabs_container">
						<ul class="tabs d-flex flex-sm-row flex-column align-items-left align-items-md-center justify-content-center">
							<li class="tab active" data-active-tab="tab_1"><span>Description</span></li>
							<li class="tab" data-active-tab="tab_2">
								<span>
								문의 사항
								<c:if test="${queryList.size() != 0 }">
									( ${queryList.size()} )
								</c:if>
								</span>
							</li>
							<li class="tab" data-active-tab="tab_3">
							<span>
							리뷰
							<c:if test="${reviewList.size() != 0 }">
								( ${reviewList.size()} )
							</c:if>
							</span>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">

					<!-- Tab Description -->

					<div id="tab_1" class="tab_container active">
						<div class="row">
							<div class="col-lg-5 desc_col">
								<div class="tab_title">
									<h4>Description</h4>
								</div>
								<div class="tab_text_block">
									<h2>Pocket cotton sweatshirt</h2>
									<p>Nam tempus turpis at metus scelerisque placerat nulla deumantos solicitud felis. Pellentesque diam dolor, elementum etos lobortis des mollis ut...</p>
								</div>
								<div class="tab_image">
									<img src="<c:url value='/images/desc_1.jpg'/>" alt="">
								</div>
								<div class="tab_text_block">
									<h2>Pocket cotton sweatshirt</h2>
									<p>Nam tempus turpis at metus scelerisque placerat nulla deumantos solicitud felis. Pellentesque diam dolor, elementum etos lobortis des mollis ut...</p>
								</div>
							</div>
							<div class="col-lg-5 offset-lg-2 desc_col">
								<div class="tab_image">
									<img src="<c:url value='/images/desc_2.jpg'/>" alt="">
								</div>
								<div class="tab_text_block">
									<h2>Pocket cotton sweatshirt</h2>
									<p>Nam tempus turpis at metus scelerisque placerat nulla deumantos solicitud felis. Pellentesque diam dolor, elementum etos lobortis des mollis ut...</p>
								</div>
								<div class="tab_image desc_last">
									<img src="<c:url value='/images/desc_3.jpg'/>" alt="">
								</div>
							</div>
						</div>
					</div>

					<!-- 문의사항 -->

					<div id="tab_2" class="tab_container">
						<div class="row">
							<div class="col query_info_col">
								<div class="tab_title query_info_title">
									<h4>
									문의 사항
									<c:if test="${queryList.size() != 0 }">
										( ${queryList.size()} )
									</c:if>
									</h4>
								</div>
								<div style="width:70%;margin-left:auto;margin-right:auto">
									<table border="1" style="width:100%">
										<tr align="center">
											<td>상품명</td><td>문의 제목</td><td>문의 일시</td><td>답변 상태</td>
										</tr>
										<c:forEach var="query" items="${queryList}" varStatus="loop">
											<c:set var="reply" value="${query.reply }"/>
												<tr align="center">
													<td>${query.prodSeq}</td>
													<td>${query.title}</td>
													<td>${query.qregDate}</td>
													<td>
													<c:choose>
														<c:when test="${reply != null }">Y</c:when>
														<c:when test="${reply == null }">N</c:when>
													</c:choose>
													</td>
												</tr>
										</c:forEach>
									</table>
									<c:if test="${login != null}" >
										<form action="<c:url value='/product/query'/>" method="post">
										<input type="hidden" name="prodId" value="1">
										<input type="hidden" name="cusId" value="${login.cusId }">
										<div style="margin-left:auto;margin-right:auto;width:50%">
											<div style="margin-top:50px">
												<br>
												<input type="text" name="name" placeholder="${login.name }" readonly="readonly" style="width:100%">
												<br>
												<select name="open" style="width:100%">
													<option value="공개글" selected="selected">공개글</option>
													<option value="비밀글">비밀글</option>
												</select>
												<br>
												<input type="text" name="title" placeholder="문의제목*" required="required" data-error="Valid title is required." style="width:100%">
											</div>
											<div>
												<textarea name="content"  placeholder="Your query" rows="4" required="required" data-error="Please, leave us a query." style="width:100%"></textarea>
											</div>
											<div class="text-left text-sm-right">
												<input type="submit" value="문의하기">
											</div>
										</div>
										</form>
									</c:if>
								</div>
							</div>
						</div>
					</div>

					<!-- Tab Reviews -->

					<div id="tab_3" class="tab_container">
						<div class="row">

							<!-- User Reviews -->

							<div class="col-lg-6 reviews_col">
								<div class="tab_title reviews_title">
									<h4>
									Reviews
									<c:if test="${reviewList.size() != 0 }">
										( ${reviewList.size()} )
									</c:if>
									</h4>
								</div>

								<!-- User Review -->
								
								<c:forEach var="review" items="${reviewList}" varStatus="loop">
										 
												<div class="user_pic"></div>
												<div class="user_rating">
													<ul class="star_rating">
														<c:if test="${review.score > 0}">
															<li><i class="fa fa-star" aria-hidden="true"></i></li>
														</c:if>														
														<c:if test="${review.score == 0}">
															<li><i class="fa fa-star" aria-hidden="false"></i></li>
														</c:if>
														<c:if test="${review.score > 1}">
															<li><i class="fa fa-star" aria-hidden="true"></i></li>
														</c:if>														
														<c:if test="${review.score <= 1}">
															<li><i class="fa fa-star" aria-hidden="false"></i></li>
														</c:if>
														<c:if test="${review.score > 2}">
															<li><i class="fa fa-star" aria-hidden="true"></i></li>
														</c:if>														
														<c:if test="${review.score <= 2}">
															<li><i class="fa fa-star" aria-hidden="false"></i></li>
														</c:if>
														<c:if test="${review.score > 3}">
															<li><i class="fa fa-star" aria-hidden="true"></i></li>
														</c:if>														
														<c:if test="${review.score <= 3}">
															<li><i class="fa fa-star" aria-hidden="false"></i></li>
														</c:if>
														<c:if test="${review.score > 4}">
															<li><i class="fa fa-star" aria-hidden="true"></i></li>
														</c:if>														
														<c:if test="${review.score <= 4}">
															<li><i class="fa fa-star" aria-hidden="false"></i></li>
														</c:if>
													</ul>
												</div>
											</div>
											<div class="review">
												<div class="review_date">${review.regDate }</div>
												<div class="user_name">${ review.cusId }</div>
												<p>${review.content }</p>
											</div>
										</div>
									</c:forEach>
							</div>

							<!-- Add Review -->

							<div class="col-lg-6 add_review_col">

								<div class="add_review">
									<form id="review_form" action="post">
										<div>
											<h1>Add Review</h1>
											<input id="review_name" class="form_input input_name" type="text" name="name" placeholder="Name*" required="required" data-error="Name is required.">
											<input id="review_email" class="form_input input_email" type="email" name="email" placeholder="Email*" required="required" data-error="Valid email is required.">
										</div>
										<div>
											<h1>Your Rating:</h1>
											<ul class="user_star_rating">
												<li><i class="fa fa-star" aria-hidden="true"></i></li>
												<li><i class="fa fa-star" aria-hidden="true"></i></li>
												<li><i class="fa fa-star" aria-hidden="true"></i></li>
												<li><i class="fa fa-star" aria-hidden="true"></i></li>
												<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
											</ul>
											<textarea id="review_message" class="input_review" name="message"  placeholder="Your Review" rows="4" required data-error="Please, leave us a review."></textarea>
										</div>
										<div class="text-left text-sm-right">
											<button id="review_submit" type="submit" class="red_button review_submit_btn trans_300" value="Submit">submit</button>
										</div>
									</form>
								</div>

							</div>

						</div>
					</div>

				</div>
			</div>
		</div>

	</div>
</body>
<script src="<c:url value='/js/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='/styles/bootstrap4/popper.js'/>"></script>
<script src="<c:url value='/styles/bootstrap4/bootstrap.min.js'/>"></script>
<script src="<c:url value='/plugins/Isotope/isotope.pkgd.min.js'/>"></script>
<script src="<c:url value='/plugins/OwlCarousel2-2.2.1/owl.carousel.js'/>"></script>
<script src="<c:url value='/plugins/easing/easing.js'/>"></script>
<script src="<c:url value='/plugins/jquery-ui-1.12.1.custom/jquery-ui.js'/>"></script>
<script src="<c:url value='/js/single_custom.js'/>"></script>
</html>
<jsp:include page="../include/footer.jsp" />