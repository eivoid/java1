<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<title>게시판</title>
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
				<% for(int i=0;i<10;i++){ %>
				<tr>
					<td><%=i %></td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
					<td>5</td>
				</tr>
				<%} %>
			</tbody>
		</table>
		<a href="boardw.do" class="btn btn-success">글쓰기</a>
	</div>

</body>
</html>