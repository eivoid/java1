<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>회원가입</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<form action="join.do" method="post">
		<input type="text" name="id" class="form-control"	/>
		<input type="text" name="pw" class="form-control"	/>
		<input type="text" name="name" class="form-control"	/>
		<input type="submit" class="btn btn-success" value="회원가입"	/>
		</form>
	</div>
	
</body>
</html>
