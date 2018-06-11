<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mystyle1.css" />
<style>
.modal-content, .form-control, .btn{font-size:15px;}
</style>
</head>
<body>
<div class="modal-content">
<h4>회원가입</h4>
		<hr />
		<div class="form-inline" style="margin-bottom:5px">
			<div style="width: 100px">
				<label>아이디</label>
			</div>
			<div style="margin-right:10px">
			<input type="text" class="form-control" placeholder="아이디" />
			</div>
			<div style="margin-right:10px">
			<input type="button" class="btn btn-primary" value="중복확인" />
			</div>
		</div>
		<div class="form-inline" style="margin-bottom:5px">
			<div style="width: 100px">
				<label>암호</label>
			</div>
			<div style="margin-right:10px">
			<input type="password" class="form-control" placeholder="암호" />
			</div>
		</div>
		<div class="form-inline" style="margin-bottom:5px">
			<div style="width: 100px">
				<label>암호확인</label>
			</div>
			<div style="margin-right:10px">
			<input type="password" class="form-control" placeholder="암호확인" />
			</div>
		</div>
		<div class="form-inline" style="margin-bottom:5px">
			<div style="width: 100px">
				<label>이름</label>
			</div>
			<div style="margin-right:10px">
			<input type="text" class="form-control" placeholder="이름" />
			</div>
		</div>
		<div class="form-inline" style="margin-bottom:5px">
			<div style="width: 100px">
				<label>나이</label>
			</div>
			<div style="margin-right:10px">
			<input type="text" class="form-control" placeholder="나이" />
			</div>
		</div>
		<div class="form-inline" style="margin-bottom:5px">
			<div style="width: 100px">
				<label>이메일</label>
			</div>
			<div style="margin-right:10px">
			<input type="text" class="form-control" placeholder="이메일" />
			</div>
		</div>
		<hr />
		<input type="button" class="btn btn-success" value="회원가입" />
		</div>
</body>
</html>