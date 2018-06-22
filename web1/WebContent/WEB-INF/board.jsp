<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>게시판</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mystyle1.css" />

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">

		<div class="form-inline justify-content-end">
			<div class="form-inline" style="margin-top: 5px; margin-bottom: 5px">
				<select class="form-control" id="type-search">
					<option value="brd_title">제목</option>
					<option value="brd_content">내용</option>
					<option value="brd_writer">작성자</option>
				</select>
				<div style="margin-left: 5px; margin-right: 5px">
					<input type="text" id="text-search" class="form-control"
						placeholder="검색어입력" />
				</div>
				<input type="submit" id="btn-search" class="btn btn-success"
					value="검색" />
			</div>
		</div>

		<table class="table">
			<thead>
				<tr>
					<c:forEach var="tmp" items="${str}">
						<th>${tmp}</th>
					</c:forEach>
				</tr>

			</thead>
			<tbody>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.brd_no }</td>
						<td><a href="boardup.do?no=${vo.brd_no }">${vo.brd_title }</a></td>
						<td>${vo.brd_writer }</td>
						<td>${vo.brd_hit1 }</td>
						<td>${vo.brd_date }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%-- <nav aria-label="page navigation example">
		<ul class="pagination justify-content-center"> <!-- center부분이 없으면 왼쪽 오른쪽으로 붙이려면 end -->
			<li class="page-item"><a class="page-link" href="#">Previous</a></li>
			<c:forEach var="i" begin="1" end="${cnt }" step="1">
			<li class="page-item"><a class="page-link" href="board.do?page=${i }">${i }</a></li>
			</c:forEach>
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
		</ul>
		</nav>
		<hr/> --%>
		<div class="wrap" style="display: flex; justify-content: center">
			<ul id="pagination" class="pagination"></ul>
		</div>

		<a href="boardw.do" class="btn btn-success">글쓰기</a>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/jquery.twbsPagination-1.3.1_bs4.js"></script>
	<script>
		$(function() {
			$('#pagination').twbsPagination({
				totalPages : '${cnt}',
				visiblePages : 10,
				href : '?page={{number}}'
			});
			//$('#text-search').click(function(){		} click에는 반환이 필요없지만 keyup에는 반환이 필요해서 event라는 매개변수가 들어간다.
			//id가  text-search인 곳에 키가 눌러지면
			$('#text-search').keyup(
					function(event) {
						if (event.which == 13) {
							var ty = $('#type-search').val();
							var tx = $('#text-search').val();
							//alert('엔터키가 눌러짐');
							//jquery에서 a태그 발생시킴
							window.location.href = "board.do?type=" + ty
									+ "&text=" + tx;
						}
					});
		});
	</script>
</body>
</html>