<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
 	.modal-dialog{
 	top:300px;
 	height:800px;
 	}

  </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">홈</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="n2.jsp" class="btn" data-toggle="modal" data-target="#myModal"><span>로그인</span></a></li>
      <li><a href="#">회원가입</a></li>
    </ul>
  </div>
</nav>
<!-- Trigger the modal with a button -->
  <!-- <a href="#modal" class="btn" data-toggle="modal"></a> --> 
<!-- <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">로그인</button> -->
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
        
      </div>
      
    </div>
  </div>  


</body>
</html>