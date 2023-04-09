<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 캐시 사용안함 -->

<!DOCTYPE html>
<html lang="en">
<head>
<META http-equiv="Cache-Control" content="no-cache">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="UTF-8" />
<title>main</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
<!-- Link Swiper's CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />

<!-- Demo styles -->
<style>
.imgslider {
	position: relative;
}

body {
	background: #eee;
	font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
	font-size: 14px;
	color: #000;
	margin: 0;
	padding: 0;
}

.swiper {
	width: 100%;
	height: 100%;
}

.swiper-slide {
	text-align: center;
	font-size: 18px;
	background: #fff;
	display: flex;
	justify-content: center;
	align-items: center;
	overflow: hidden;
	width: 200px;
	height: auto;
}

.slide-image {
	max-width: 100%;
	max-height: 100%;
	display: block;
}

.header-section {
	position: relative;
	height: 80px;
	margin-bottom: 10px;
}

.top-nav-section {
	position: absolute;
	left: 70%;
}

ul li {
	list-style: none;
	float: left;
	margin-right: 30px;
}

.main_search_section {
	margin-bottom: 10px;
}
</style>
</head>

<body>

	<!-- main -->
	<div class="main-section">
		<div class=header-section>
			<h2>
				<a href="/main"> <img src="/images/logo/jpg"
					alt="bookStore Logo Image">
				</a>
			</h2>
			<ul class="top-nav-section">
				<li id = toHide><a href="/login">LogIn</a></li>
				<li id = toHide><a href="/join">Join</a></li>
			</ul>
		</div>
		<!--통합검색-->
		<div class="main_search_section">
			<form name="serForm" action="search" method="GET">
				<fieldset style="text-align: right;">
					<legend>Search</legend>
					<div class="main_search_form">
						<span class="first_tab"> <select class="search_select"
							style="width: 90px;">
								<option value="">제목</option>
						</select>
						</span> <span> <input class="text_input" type="text" name="title"
							value="" />
						</span> <span> <input class="btn_input" type="submit"
							src="../images/btn_search.jpegad" alt="검색" />
						</span>
					</div>
				</fieldset>
			</form>
		</div>
		<!-- Swiper -->
		<div class="imgslider">
			<div class="swiper mySwiper">
				<div class="swiper-wrapper">
					<c:forEach var="row" items="${data}">
						<div class="swiper-slide" style="cursor: pointer"
							onclick="location.href='/detail?bookId=${row.book_id}'">
							<img class="slide-image" src="/images/${row.image_path}.jpeg"
								alt="image not found" />
						</div>
					</c:forEach>
					<c:forEach var="row" items="${data}">
						<div class="swiper-slide" style="cursor: pointer"
							onclick="location.href='/detail?bookId=${row.book_id}'">
							<img class="slide-image" src="/images/${row.image_path}.jpeg"
								alt="image not found" />
						</div>
					</c:forEach>

				</div>
			</div>
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
			<div class="swiper-pagination"></div>
		</div>
	</div>
	<!-- main -->

	<!-- Swiper JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>

	<!-- Initialize Swiper -->
	<script>
		var swiper = new Swiper(".mySwiper", {
			loop : true,
			slidesPerView : 6,
			spaceBetween : 25,
			autoplay : {
				delay : 2000,
				disableOnInteraction : true,
			},
			//pagination : {
			//	el : ".swiper-pagination",
			//	clickable : true,
			//},
			navigation : {
				nextEl : ".swiper-button-next",
				prevEl : ".swiper-button-prev",
			},

		});
	</script>
	<script>

	</script>
</body>

</html>
