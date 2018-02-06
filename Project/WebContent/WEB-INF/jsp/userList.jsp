<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="beans.UserInfo" %>


<!doctype html>
<html lang="ja">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="./css/bootstrap.min.css">

<title>userList</title>
</head>
<body>
	<nav id="navbar-example2" class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#"></a>
		<ul class="nav nav-pills">
			<li class="nav-item"><a class="nav-link text-white bg-dark"
				href="file:///C:/Users/naoki/Documents/git/Web%E3%83%97%E3%83%AD%E3%82%B0%E3%83%A9%E3%83%9F%E3%83%B3%E3%82%B0/Mock/userInfo-id0001.html">${userinfo.name}さん</a></li>
			<li class="nav-item"><a class="nav-link text-danger" href="Logout">ログアウト

</a>
			</li>
		</ul>
	</nav>
	<div class="container ">
		<br />
		<br />

		<div align="center">
			<h1>ユーザ一覧</h1>
			<br />
			<div align="right">
				<a class="btn bg-dark text-white btn-sm" href="NewUserServlet?loginid=${user.loginid}" role="button">新規登録</a>
			</div>
			<br />
	<form action="UserList" method="post">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-2 col-form-label">ログインID</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword" placeholder="Login ID" name="loginid">
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-2 col-form-label">ユーザ名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword" placeholder="User Name" name="name">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-2 col-form-label">生年月日</label><a>
					</a><a>　</a>
					<div class="row">
						<div class="col">
							<input type="date" class="form-control" placeholder="年 / 月 / 日" name="birthdayFrom">
						</div>
						<a> ～ </a>
						<div class="col">
							<input type="date" class="form-control" placeholder="年 / 月 / 日" name="birthdayTo">
						</div>
					</div>
				</div>

			<div  align="right">
						<input type="submit" class="btn bg-dark text-white"  role="button" value="　検　索　">
			</div>
	</form>

			<Hr class="text-light bg-dark">

			<table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col" class="p-3 mb-2 bg-dark text-white"><div align="center">ログインID</div></th>
						<th scope="col" class="p-3 mb-2 bg-dark text-white"><div align="center">ユーザー名</div></th>
						<th scope="col" class="p-3 mb-2 bg-dark text-white"><div align="center">生年月日</div></th>
						<th scope="col" class="p-3 mb-2 bg-dark text-white"><div id="wrapper"></div></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="user" items="${userInfoList}">
					<tr>
						<th scope="row">${user.loginid}</th>
						<td>${user.name}</td>
						<td>${user.birthdayFormat}</td>
						<td>
							<div align="center">
								<a class="btn bg-dark text-white btn-sm" href="UserInfo?loginid=${user.loginid}"
									role="button"> 詳細 </a>

								<c:if test="${userinfo.loginid == 'admin'}">
							    <a class="btn bg-dark text-white btn-sm" href="UserUpdateServlet?loginid=${user.loginid}"
									role="button"> 更新 </a>
									</c:if>

								<c:if test="${userinfo.loginid == user.loginid}">
							    <a class="btn bg-dark text-white btn-sm" href="UserUpdateServlet?loginid=${user.loginid}"
									role="button"> 更新 </a>
									</c:if>

								<c:if test="${userinfo.loginid == 'admin'}">
								<a class="btn bg-dark text-white btn-sm" href="UserDeleteServlet?loginid=${user.loginid}"
									role="button"> 削除 </a>
									</c:if>

							</div>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
</body>
</html>