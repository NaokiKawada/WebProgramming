<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="ja">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="./css/bootstrap.min.css">

<title>userInfo</title>
</head>
<body>
	<nav id="navbar-example2" class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#"></a>
		<ul class="nav nav-pills">
			<li class="nav-item"><a class="nav-link text-white bg-dark"
				href="file:///C:/Users/naoki/Documents/git/Web%E3%83%97%E3%83%AD%E3%82%B0%E3%83%A9%E3%83%9F%E3%83%B3%E3%82%B0/Mock/userInfo-id0001.html">${userinfo.name}さん</a></li>
			<li class="nav-item"><a class="nav-link text-danger"
				href="Logout">ログアウト </a></li>
		</ul>
	</nav>

	<div class="container ">
		<br /> <br />
		<div align="center">
			<h1>ユーザ削除確認</h1>
		</div>
		<br /> <a>ログインID :${user.loginid}<br /> を本当に削除してもよろしいでしょうか。
		</a>
		<form action="UserDeleteServlet" method="post">

			<br />
			<div style="float: left;">
				<a class="btn bg-dark text-white" href="UserList" role="button">
					キャンセル </a>
			</div>
			<div style="float: left;">
				<a> </a>
			</div>

			<div style="float: left;">
				<input type="submit" class="btn bg-dark text-white"
					 role="button" value="　　OK　　"> <input
					type="hidden" name="loginid" value="${user.loginid}">
			</div>

		</form>

	</div>
   </body>
  </html>