<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ja">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="./css/bootstrap.min.css">

<title>Login</title>
</head>
<body>
	<div class="container ">
		<br />
		<br />
		<div align="center">
			<h1>ログイン画面</h1>
		</div>


		<p>
  			${message}
		</p>

		<form action="Index" method="post">
			<br />
			<div class="form-group">
				<label for="exampleInputEmail1">ログインID</label>
				<input type="text" name="loginid" class="form-control" placeholder="Login ID">
			</div>
			<br />
			<div class="form-group">
				<label for="exampleInputPassword1">パスワード</label>
				<input type="password" name="password" class="form-control" placeholder="Password">
			</div>
			<br />
			<div align="center">
				<input type="submit" class="btn btn-primary" value="Login">

			</div>
		</form>
	</div>
</body>
</html>