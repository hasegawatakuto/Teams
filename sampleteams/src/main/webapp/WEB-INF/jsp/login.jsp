<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<link rel="stylesheet" href="/sampleteams/css/login.css">
<title>ログイン画面</title>
</head>
<!-- ここからヘッダー -->
<header>
	<img id="logo" src="./public/drivelinelogo.ico" alt="drivelineロゴ">
	<p id="logoright">JavaTeamDevelopment</p>
</header>
<body>
	<main>
		<div class="mx-auto">
			<h1 class="mb-3">ログイン画面</h1>
			<form action="/sampleteams/LoginServlet" method="POST">
			<p id = ermail><%= request.getAttribute("errorMsgmail") %></p>
			<p id = erpass><%= request.getAttribute("errorMsgpass") %></p>
				<div class="mb-3">
					<label for="email" class="form-label">メールアドレス</label> <input
						type="text" class="form-control" id="email" name="email">
				</div>
				<div class="mb-3">
					<label for="pass" class="form-label">パスワード</label> <input
						type="password" class="form-control" id="pass" name="password">
				</div>
				<button type="submit" class="btn btn-primary">ログイン</button>
			</form>
		</div>
		<a href="<%=request.getContextPath()%>/CustomerRegisterServlet">新規会員登録はこちら</a>
	</main>
</body>
</html>