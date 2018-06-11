<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>web1_회원가입</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mystyle1.css" />
<script>
	function checkemail(){
		if(email_select.value=='1'){
			email_select.value='';
			email.focus();
		}
	}
</script>
</head>
<body>

	<%
		//받는곳은 = 형변환 필요
		String a = (String) request.getAttribute("title");
		int b = (int) request.getAttribute("num");
	%>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="box600">
		<h4><%= a %> <%= b %></h4>
		<hr />
		<div class="form-inline" style="margin-bottom: 5px">
			<div style="width: 100px">
				<label>아이디</label>
			</div>
			<div style="margin-right: 10px">
				<input type="text" class="form-control" placeholder="아이디" />
			</div>
			<div style="margin-right: 10px">
				<input type="button" class="btn btn-primary" value="중복확인" />
			</div>
		</div>
		<div class="form-inline" style="margin-bottom: 5px">
			<div style="width: 100px">
				<label>암호</label>
			</div>
			<div style="margin-right: 10px">
				<input type="password" class="form-control" placeholder="암호" />
			</div>
		</div>
		<div class="form-inline" style="margin-bottom: 5px">
			<div style="width: 100px">
				<label>암호확인</label>
			</div>
			<div style="margin-right: 10px">
				<input type="password" class="form-control" placeholder="암호확인" />
			</div>
		</div>
		<div class="form-inline" style="margin-bottom: 5px">
			<div style="width: 100px">
				<label>이름</label>
			</div>
			<div style="margin-right: 10px">
				<input type="text" class="form-control" placeholder="이름" />
			</div>
		</div>
		<div class="form-inline" style="margin-bottom: 5px">
			<div style="width: 100px">
				<label>나이</label>
			</div>
			<div style="margin-right: 10px">
				<input type="text" class="form-control" placeholder="나이" />
			</div>
		</div>
		<div class="form-inline" style="margin-bottom: 5px">
			<div style="width: 100px">
				<label>이메일</label>
			</div>
			<div style="margin-right: 10px">
				<input type="text" name = email id = email class="form-control" placeholder="이메일" />&nbsp&nbsp@&nbsp
			</div>
			<div style="margin-right: 10px">
				<select name="email_select" class="form-inline" id="email_select" onChange="checkemail();">
					<option value="gmail.com">gmail.com</option>
					<option value="naver.com">naver.com</option>
					<option value="1">직접입력</option>
				</select>
			</div>
			<hr />

		</div>
		<input type="button" class="btn btn-success" value="회원가입" />


		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>