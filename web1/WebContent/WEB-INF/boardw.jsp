<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<title>
	<%
		String title = (String) request.getAttribute("title");
	%> <%=title%>
</title>
<link rel="stylesheet" href="css/bootstrap.min.css?ver=2">
<link rel="stylesheet" href="css/mystyle1.css?ver=2" />
<script src="js/jquery-3.2.1.slim.min.js?ver=2"></script>
<script src="js/popper.min.js?ver=2"></script>
<script src="js/bootstrap.min.js?ver=2"></script>
<link href="css/summernote-bs4.css?ver=2" rel="stylesheet" />
<script src="js/summernote-bs4.js?ver=2"></script>

</head>
<body>
	<form action="boardw.do" method="post" enctype="multipart/form-data">
		<div class="box600">
		<h4><%=title%></h4>
		<div style="margin-bottom: 5px">
			<input type="text" name="title" class="form-control" placeholder="제목" />
		</div>
		<div style="margin-bottom: 5px">
			<textarea name="content" id="summernote"></textarea>
		</div>
		<div style="margin-bottom: 5px">
			<input type="text" name="writer" class="form-control" placeholder="작성자" />
		</div>
		<div style="margin-bottom: 5px">
			<input type="file" name="img" class="form-control" />
		</div>
		<div style="margin-bottom: 5px">
			<input type="submit" class="btn btn-primary" value="글쓰기" /> <a
				href="board.do" class="btn btn-light">글목록</a>
		</div>
	</div>
	</form>
	<script>
		$('#summernote').summernote({
			placeholder : "hello-world",
			tabsize : 2,
			height : 200
		});
	</script>
</body>
</html>