<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>테이블</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mystyle1.css" />
</head>
<body>
<%
		String[] str = (String[]) request.getAttribute("str");
				
	
	%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
		<table class="table">
			<thead>
				<tr>
					<%for(String tmp:str){ %>
					<th><%= tmp %></th>
					<%} %>					
				</tr>

			</thead>
			<tbody>
				<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.mem_id }</td>
					<td>${vo.mem_pw }</td>
					<td>${vo.mem_name }</td>
					<td>${vo.mem_age }</td>
					<td>${vo.mem_email }</td>
					<td>${vo.mem_date }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>


</div>
<jsp:include page="delete.jsp"></jsp:include>
</body>
</html>