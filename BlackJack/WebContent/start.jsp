<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ブラックジャック</title>
<style type="text/css">
.entry{
	text-align:center;
}
.red{
	font-size:30px;
	color:red;
}
</style>
</head>
<body>
	<div class="entry">
		<h1>＜ブラックジャック・ゲーム＞</h1>
		<p>
			${requestScope.message }<br/><br/>
			あなたの現在の数字は<span class="red"> ${sessionScope.number } </span>になります。<br/><br/>
			親の数は15～22のいずれかになります。
		</p>

		<form action="BlackJack" method="post">

				<input type="hidden" name="btn" value="once"/>
				<input type="submit" value="もう一度"/>

		</form>
		<br/>
		<form action="BlackJack" method="post">

				<input type="hidden" name="btn" value="stay"/>
				<input type="submit" value="ステイ"/>

		</form>
	</div>
</body>
</html>