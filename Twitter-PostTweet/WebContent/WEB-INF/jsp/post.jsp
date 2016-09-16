<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Post Tweet</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<section> <span></span>
	<h1>Post Tweet</h1>
	<form action="Controller">
		<input type="hidden" name="command" value="post_tweet" />
		<textarea rows="5" cols="25" name="message"></textarea>
		<br><br>
		<button>POST</button>
	</form>

	</section>
</body>
</html>
