<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>내용</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mystyle1.css" />
</head>
<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th width="100px">글번호</th>
					<td>1</td>
				</tr>
				<tr>
					<th width="100px">글제목</th>
					<td>1</td>
				</tr>
				<tr>
					<th width="100px">글내용</th>
					<td>1ㄴㄷㄴㄷ</td>
				</tr>
				<tr>
					<th width="100px">작성자</th>
					<td>가나다</td>
				</tr>
				<tr>
					<th width="100px">조회수</th>
					<td>1312</td>
				</tr>
				<tr>
					<th width="100px">날짜</th>
					<td>2018-06-15</td>
				</tr>

			</thead>
			<tbody>
				
			</tbody>
		</table>
		<a href="board.do" class="btn btn-success">글목록</a>
		<a href="board.do" class="btn btn-success">이전글</a>
		<a href="board.do" class="btn btn-success">다음글</a>
		<a href="board.do" class="btn btn-success">글수정</a>
		<a href="board.do" class="btn btn-success">글삭제</a>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>