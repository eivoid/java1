<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>게시판</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mystyle1.css" />
</head>
<body>
	<%  String aaa=(String) request.getAttribute("aaa"); %>
	<%= aaa %>
	${aaa}
	
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container">
	${vo.brd_no }
	${vo.brd_title }
	${vo.brd_content }
	
		<table class="table">
			<thead>
				<tr>
					<c:forEach var="tmp" items="${str}" >
					<th>${tmp}</th>
					</c:forEach>					
				</tr>

			</thead>
			<tbody>
				<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.brd_no }</td>
					<td>${vo.brd_title }</td>
					<td>${vo.brd_writer }</td>
					<td>${vo.brd_hit }</td>
					<td>${vo.brd_date }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="boardw.do" class="btn btn-success">글쓰기</a>
	</div>

</body>
</html>