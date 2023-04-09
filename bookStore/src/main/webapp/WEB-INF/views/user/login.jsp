<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
* {
	padding: 0;
	margin: 0;
}

html, body {
	height: 100%;
	background: #ffffff;
}

#container {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	height: 100%;
}

#loginBox {
	width: 300px;
	text-align: center;
	background-color: #ffffff;
}

.input-form-box {
	border: 0px solid #ff0000;
	display: flex;
	margin-bottom: 5px;
}

.input-form-box>span {
	display: block;
	text-align: left;
	padding-top: 5px;
	min-width: 65px;
}

.button-login-box {
	margin: 10px 0;
}

#loginBoxTitle {
	color: #000000;
	font-weight: bold;
	font-size: 32px;
	text-transform: uppercase;
	padding: 5px;
	margin-bottom: 20px;
	background: linear-gradient(to right, #270a09, #8ca6ce);
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
}

#inputBox {
	margin: 10px;
}

#inputBox button {
	padding: 3px 5px;
}
</style>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.0.0/crypto-js.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- 나의 스타일 추가 -->
<link rel="stylesheet" href="css/login.css?v=1234">

</head>
<body class="text-center">

	<!--  html 전체 영역을 지정하는 container -->
	<div id="container">
		<!--  login 폼 영역을 : loginBox -->
		<div id="loginBox">

			<!-- 로그인 페이지 타이틀 -->
			<div id="loginBoxTitle">BookStore Login</div>
			<!-- 아이디, 비번, 버튼 박스 -->
			<form method="POST" id="loginForm">
				<div id="inputBox">
					<div class="input-form-box">
						<span>이메일 </span><input type="text" name="email"
							class="form-control">
					</div>
					<div class="input-form-box">
						<span>비밀번호 </span><input type="text" id="plainPW"
							class="form-control"> <input type="password"
							name="hashedPW" class="form-control" hidden>
					</div>
					<div class="button-login-box">
						<button type="button" class="btn btn-primary btn-xs"
							style="width: 100%" onclick="doLogin()">로그인</button>
					</div>
				</div>
			</form>

		</div>
	</div>

	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<script>
	function doLogin(){
	
    var hashedPW = document.getElementsByName('hashedPW');
    var nameDOM = document.getElementsByName('name');
 	var inputText = document.getElementById('plainPW').value;
 	var loginForm = document.getElementById('loginForm');
 	
 	var hash = CryptoJS.SHA256(inputText).toString(); 
    hashedPW[0].value = hash;
    
    loginForm.submit();
	}
	</script>
</body>
</html>