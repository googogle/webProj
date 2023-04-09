<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<META http-equiv="Cache-Control" content="no-cache">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.product-title {
	text-align: center;
	display: table;
	border: 1px solid #cecece;
	width: 250px;
	height: 400px;
	border: none;
}

.product-img-div {
	display: table-cell;
	vertical-align: middle;
}

.product-img {
	max-width: 250px;
	max-height: 400px;
}
</style>
</head>
<body>
	<h1>검색결과</h1>
	<p>제목 : ${ data.title }</p>
	<p>카테고리 : ${ data.category }</p>
	<p>
		가격 :
		<fmt:formatNumber type="number" maxFractionDigits="3"
			value="${data.price}" />
	</p>
	<p>
		입력일 :
		<fmt:formatDate value="${data.insert_date}"
			pattern="yyyy.MM.dd HH:mm:ss" />
	</p>

	<div class="product-title">
		<div class="product-img-div">
			<img class="product-img" src="/images/${data.image_path}.jpeg">
		</div>
	</div>

	<p>
		<a href="/update?bookId=${data.bookId}">수정</a>
	</p>
	<form method="POST" action="/delete">
		<input type="hidden" name="bookId" value="${data.bookId}" /> <input
			type="submit" value="삭제" />
	</form>
	<p>
		<a href="/list">목록으로</a>
	</p>
	<p>
		<a href="/main">메인페이지</a>
	</p>
</body>
</html>