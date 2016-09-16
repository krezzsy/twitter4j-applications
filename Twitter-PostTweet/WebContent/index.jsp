<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<section> <span></span>
	<h1>Twitter Login</h1>
	<form action="Controller">
		<input type="hidden" name="command" value="oauth" /> <input
			placeholder="Consumer Key" type='text' name="key"> <input
			placeholder="Consumer Secret" type='text' name="secret"> <input
			placeholder="Access Token" type='text' name="token"> <input
			placeholder="Access Token Secret" type='text' name="token_secret">
		<button>LOGIN</button>
		<c:if test="${not empty errorMessage}">
			<c:out value="Wrong data!" />
		</c:if>
	</form>

	</section>
</body>
</html>
