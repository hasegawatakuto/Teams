<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- リセットCSS -->
<link href="https://unpkg.com/sanitize.css" rel="stylesheet" />
<!-- loginCSS -->
<link rel="stylesheet" href="../css/login.css">
<title>ログイン画面</title>
</head>
<body>
	<!-- ここからヘッダー -->
	<header>
		<img id="logo" src="#" alt="drivelineロゴ">
		<p id="logoright">JavaTeamDevelopment</p>
	</header>
	<!-- ここからMain -->
	<main>
		<h1 id="log">ログイン</h1>
		<!-- ユーザーID,password入力 -->
		<p id=mailadd>MailAddless</p>
		<form action = "Loginservlet" method = "post">
		<p id=mailbox>
			<input type="text" name="loginId" required>
		</p>
		<p id=pass>PassWord</p>
		<p id=passbox>
			<input type="password" name="pass" required>
		</p>
		<p id=loginbox>
			<input type="submit" value="ログイン">
		</p>
		</form>
		<a href="newMember.jsp">新規会員登録はこちら</a>
	</main>
</body>
</html>