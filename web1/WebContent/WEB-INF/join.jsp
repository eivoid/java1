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
	function checkemail() {
		if (email_select.value == '1') {
			email_select.value = '';
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
	<form action="join.do" method="post">
		<div class="box600">
			<h4><%=a%>
				<%=b%></h4>
			<hr />
			<div class="form-inline" style="margin-bottom: 5px">
				<div style="width: 100px">
					<label>아이디</label>
				</div>
				<div style="margin-right: 10px">
					<input type="text" id="id" name="id" class="form-control" placeholder="아이디" />
				</div>
				<div style="margin-right: 10px">
					<input type="button" id="btn-idcheck" class="btn btn-primary" value="중복확인" />
				</div>
			</div>
			<div class="form-inline" style="margin-bottom: 5px">
				<div style="width: 100px">
					<label>암호</label>
				</div>
				<div style="margin-right: 10px">
					<input type="password" name="pw" class="form-control"
						placeholder="암호" />
				</div>
			</div>
			<div class="form-inline" style="margin-bottom: 5px">
				<div style="width: 100px">
					<label>암호확인</label>
				</div>
				<div style="margin-right: 10px">
					<input type="password" name="pw" class="form-control"
						placeholder="암호확인" />
				</div>
			</div>
			<div class="form-inline" style="margin-bottom: 5px">
				<div style="width: 100px">
					<label>이름</label>
				</div>
				<div style="margin-right: 10px">
					<input type="text" name="name" class="form-control"
						placeholder="이름" />
				</div>
			</div>
			<div class="form-inline" style="margin-bottom: 5px">
				<div style="width: 100px">
					<label>나이</label>
				</div>
				<div style="margin-right: 10px">
					<input type="text" name="age" class="form-control" placeholder="나이" />
				</div>
			</div>
			<div class="form-inline" style="margin-bottom: 5px">
				<div style="width: 100px">
					<label>이메일</label>
				</div>
				<div style="margin-right: 10px">
					<input type="text" name=email id=email class="form-control"
						placeholder="이메일" />
				</div>
				<div>@</div>
				<div>
					<select name="email_select" id="email_select" class="form-control"
						onChange="checkemail();">
						<option value="@gmail.com">gmail.com</option>
						<option value="@naver.com">naver.com</option>
						<option value="1">직접입력</option>
					</select>
				</div>
				</div>
				<hr />

				<div align="right">
					<input type="submit" class="btn btn-success" value="회원가입" />
				</div>

			</div>
	</form>
	<script src="js/jquery-3.3.1.min.js"></script>
	
	<script>
		$(function(){
			$('#id').keyup(function(){
				var a = $('#id').val();
				//console.log(a);
				if(a.length > 0){
				//doGet을 호출{"ret":"y"}
				$.get('ajaxidcheck.do?id='+a,function(data){
					if(data.ret == 'y'){
						$('#btn-idcheck').val('사용가능');
						$('#btn-idcheck').attr('class','btn btn-success');
					}
					else if(data.ret == 'n'){
						$('#btn-idcheck').val('사용불가');
						$('#btn-idcheck').attr('class','btn btn-warning');
					}
					console.log(data);
				}, 'json');
				}
				else {
					$('#btn-idcheck').val('중복확인');
					$('#btn-idcheck').attr('class','btn btn-primary');
				}
				
				//doPost를 호출
				/* $.post('서버주소','전달할값', function(data){
					
				}, 'json'); */
			});
		});
	</script>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>