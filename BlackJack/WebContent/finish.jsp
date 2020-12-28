<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ブラックジャック・結果ページ</title>
<style type="text/css">
.resultMessage{
	font-size:30px;
	color:red;
}
.result{
	text-align:center;
}
</style>
</head>
<body>
	<div class="result">
		<h1>ブラックジャック・結果画面</h1>
		<p>親の数： ${requestScope.parentNum }</p>
		<p>あなたの数： ${requestScope.number }</p>
		<p><span class="resultMessage"> ${requestScope.resultMessage }</span></p>
		<p><a href="BlackJack">もう一度遊ぶ</a></p>
	</div>
</body>
</html>