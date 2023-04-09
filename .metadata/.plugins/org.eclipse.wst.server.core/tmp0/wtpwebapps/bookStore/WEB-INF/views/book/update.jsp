<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<!-- 캐시 사용안함 -->


<html>
<head>
<META http-equiv="Cache-Control" content="no-cache">
<title>책 수정</title>
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
	<h1>책 수정</h1>
	<form method="POST" enctype="multipart/form-data">
		<p>
			제목 : <input type="text" name="title" value="${ data.title }" />
		</p>
		<p>
			카테고리 : <input type="text" name="category" value="${ data.category }" />
		</p>
		<p>
			가격 : <input type="text" name="price" value="${ data.price }" />
		</p>
		<div class="product-title">
			<div class="product-img-div">
				<img class="product-img" src="/images/${data.image_path}.jpeg">
			</div>
		</div>
		<p>
			이미지 : <input type="file" name="file">
		</p>
		<p>
			<input type="submit" value="저장" />
	</form>
</body>
</html>
