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
		String[] vstr = (String[]) request.getAttribute("vstr");
		String v1 = (String) request.getAttribute("v1");	
				
	
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
				<tr>
				<%for(String tmp:vstr){ %>
					<td><%=vstr%></td>
				<%} %>
				</tr>
				<tr>
				<td><%=v1 %></td>
				</tr>
			</tbody>
		</table>
		
	</div>


</div>

</body>
</html>