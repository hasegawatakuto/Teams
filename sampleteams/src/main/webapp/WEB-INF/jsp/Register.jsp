<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link rel="stylesheet" href="/sampleteams/css/register.css">
<title>新規会員登録</title>
</head>
<!-- ここからヘッダー -->
	<header>
		<img id="logo" src="./public/drivelinelogo.ico" alt="drivelineロゴ">
		<p id="logoRight">JavaTeamDevelopment</p>
	</header>
<body>
<main>
	<div class="mx-auto" style="width: 270px;">
		<h1 class="mb-3" style="text-align: center">新規会員登録</h1>
		<form action="/sampleteams/CustomerRegisterServlet" method="POST">
		<p id = ermail><%= request.getAttribute("errorMsgmail") %></p>
			<p id = erpass><%= request.getAttribute("errorMsgpass") %></p>
			<p id = erpass><%= request.getAttribute("errorMsguser_id") %></p>
		  <div class="mb-3">
		    <label for="email" class="form-label">メールアドレス</label>
		    <input type="text" class="form-control" id="email" name="email">
		  </div>
		  <div class="mb-3">
		    <label for="pass" class="form-label">パスワード</label>
		    <input type="password" class="form-control" id="pass" name="password">
		  </div>
		   <div class="mb-3">
		    <label for="email" class="form-label">UserId</label>
		    <input type="text" class="form-control" id="user_id" name="user_id">
		  </div>
		  <button type="submit" class="btn btn-primary">登録</button>
		</form>
	</div>
	<a href ="<%=request.getContextPath()%>/LoginServlet">ログイン画面はこちら</a>
	</main>
</body>
</html>