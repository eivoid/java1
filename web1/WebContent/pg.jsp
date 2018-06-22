<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div class="form-inline" style="margin-bottom: 5px">
		<div style="width: 100px">
			<label>아이디</label>
		</div>
		<div style="margin-right: 10px">
			<input type="text" id="id" class="form-control" placeholder="아이디" />
		</div>
		<div style="margin-right: 10px">
			<input type="button" class="btn btn-primary" value="중복확인" />
		</div>
	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script>
		$(function() {
			$("#id").keyup(function(event) {
				if(event.which == 13)
					alert('엔터')
				
			})
		});
		/* $(document).ready(function(){
		    $("input").keydown(function(){
		        $("input").css("background-color", "yellow");
		    });
		    $("input").keyup(function(){
		        $("input").css("background-color", "pink");
		    });
		}); */
	</script>
</body>
</html>