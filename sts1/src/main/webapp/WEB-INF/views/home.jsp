<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>
<body>
	<input type="button" class="btn btn-success" value="버튼" />
	
	<script src="resources/js/jquery-3.3.1.min.js"></script>
	<script>
	$(function(){
		alert('test');
	});
	</script>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
