<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mystyle1.css" />
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<form action="login.do" method="post">
		<div class="box600">
			<h4 align="center">log in</h4>
			<hr />
			<div class="form-inline" style="margin-bottom: 5px">
				<div style="width: 100px">
					<label>아이디</label>
				</div>
				<div style="margin-right: 10px">
					<input type="text" name="id" class="form-control" placeholder="아이디" />
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


			<hr />

			<div align="right">
				<input type="submit" id="btn-login" class="btn btn-success"
					value="로그인" />
			</div>

		</div>
	</form>
	<script src="js/jquery-3.2.1.slim.min.js"></script>
	<script src="https://unpkg.com/sweetalert2@7.22.2/dist/sweetalert2.all.js"></script>
	<script>
		//jquery 사용
		$(function(){
			//id가 btn-login 인 개체를 찾고 클릭 되는경우에 반응
			$('#btn-login').click(function(){
				//input 태그중에서 name 값이 id인 것의 입력값을 가져와서 a에보관
				var a = $('input[name=id]').val();
				//input 태그중에서 name 값이 pw인 것의 입력값을 가져와서 b에보관
				var b = $('input[name=pw]').val();
				//console창에 출력
				console.log(a);
				console.log(b);
				if(a == ''){
					
					swal('입력오류','아이디를 입력하세요.','warning');
					$('input[name=id]').focus();
					return false;
				}
				if(b == ''){
					
					swal('입력오류','암호를 입력하세요.','warning');
					$('input[name=pw]').focus();
					return false;
				}
				
			});
			
		});
				
	
	</script>
</body>
</html>