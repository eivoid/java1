<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>테이블에서 행 지우기</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mystyle1.css" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<form action="delete.do" method="post">
		<div class="box600">
		<div>
			<input type="text" name="id" class="form-control" placeholder="아이디" />
		</div>
		<div>
			<input type="submit" id="btn-delete" class="btn btn-success"
					value="삭제" />
		</div>
	</div>
	</form>

</body>
</html>