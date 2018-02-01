<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<li class="nav-item"><a class="nav-link text-danger" href="Logout">ログアウト

</a>
			</li>
		</ul>
	</nav>
	  <div class="container "><br/><br/>

	    <div align="center">
	    <h1>ユーザ新規登録</h1></div><br/>

<form>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">ログインID</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword" placeholder="Login ID">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">パスワード</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword" placeholder="Password">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">パスワード(確認)</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword" placeholder="Password">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">ユーザ名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword" placeholder="User Name">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">生年月日</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword" placeholder="Birthday">
    </div>
  </div>
</form>
<br/>
<div class="btn-group-toggle" data-toggle="buttons"  align="center">
  <a class="btn bg-dark text-white" href="file:///C:/Users/naoki/Documents/git/Web%E3%83%97%E3%83%AD%E3%82%B0%E3%83%A9%E3%83%9F%E3%83%B3%E3%82%B0/Mock/userList.html" role="button">　　登　録　　</a>
</div>
<br/>
<br/>

<div align="left">
      	  <a class="btn bg-dark text-white btn-sm" href="UserList" role="button">戻る</a>
	    </div>
