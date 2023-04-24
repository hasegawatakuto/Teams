<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://unpkg.com/sanitize.css" rel="stylesheet"/>
<link rel="stylesheet" href="../css/newMember.css">
<meta charset="UTF-8">
<title>新規会員登録</title>
</head>
<body>
<!-- ここからヘッダー -->
<header>
<img id = "logo" src = "#" alt = "drivelineロゴ">
<p id = "logoright">JavaTeamDevelopment</p>
</header>
<!-- ここからメイン -->
<main>
<h1>新規会員登録</h1>
<p id = "mailadd">MailAddless</p>
<p id ="mailbox">
<input type="text" name="loginId" required>
</p>
<p id = "pass">PassWord</p>
<p id = "passbox">
<input type="password" name="pass" required>
</p>
<p id ="loginbox">
<input type="submit" value="登録">
</p>
<a href="login.jsp">ログイン画面へ</a>
</main>
</body>
</html>