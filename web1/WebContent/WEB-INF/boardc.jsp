<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
					<td>${vo.brd_no }</td>
				</tr>
				<tr>
					<th width="100px">글제목</th>
					<td>${vo.brd_title }</td>
				</tr>
				<tr>
					<th width="100px">글내용</th>
					<td>${vo.brd_content }</td>
				</tr>
				<tr>
					<th width="100px">작성자</th>
					<td>${vo.brd_writer }</td>
				</tr>
				<tr>
					<th width="100px">조회수</th>
					<td>${vo.brd_hit }</td>
				</tr>
				<tr>
					<th width="100px">파일</th>
					<td><img src="${vo.brd_file }" width="100px" height="100px" /></td>
				</tr>
				<tr>
					<th width="100px">날짜</th>
					<td>${vo.brd_date}</td>
				</tr>


			</thead>
			<tbody>

			</tbody>
		</table>
		<a href="board.do" class="btn btn-success">글목록</a>
		<c:if test="${pno !=0 }">
			<a href="boardup.do?no=${pno }" class="btn btn-success">이전글</a>
		</c:if>
		<c:if test="${pno ==0 }">
			<button class="btn btn-success" disabled>이전글</button>
		</c:if>
		<c:if test="${nno !=0 }">
			<a href="boardup.do?no=${nno }" class="btn btn-success">다음글</a>
		</c:if>
		<c:if test="${nno ==0 }">
			<button class="btn btn-success" disabled>다음글</button>
		</c:if>
		<a href="#" id="btn-update" class="btn btn-success">글수정</a> <a
			href="#" id="btn-delete" class="btn btn-success">글삭제</a>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

	<form action="boardd.do" method="get">
		<div class="modal fade" id="deleteModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">삭제</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-lebel="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<input type="hidden" name="no" value="${vo.brd_no }" /> <label>삭제하시겠습니까</label>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-success" value="삭제" />
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
	</form>


	<div class="modal fade" id="updateModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">수정</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-lebel="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-inline" style="margin-bottom:5px" >
						<label style="width: 100px">글번호</label> <input type="text"
							class="form-control" readonly />
					</div>
					<div class="form-inline" style="margin-bottom:5px" >
					<label style="width:100px">글제목</label>
					<input type="text" class="form-control" style="width:300px"/>
					</div>
					<div class="form-inline" style="margin-bottom:5px" >
					<label style="width:100px">글내용</label>
					<textarea class="form-control" rows="6" style="width:500px"></textarea>
					</div>
					<div class="form-inline" style="margin-bottom:5px" >
					<label style="width:100px">작성자</label>
					<input type="text" class="form-control" style="width:300px"/>
					</div>
					<div class="form-inline" style="margin-bottom:5px" >
					<label style="width:100px">조회수</label>
					<input type="text" class="form-control" style="width:300px" readonly/>
					</div>
					<div class="form-inline" style="margin-bottom:5px" >
					<label style="width:100px">이미지</label>
					<img src="${vo.brd_file }" width="100px" height="100px" />
					<input type="file" class="form-control" />
					</div>
					<div class="form-inline" style="margin-bottom:5px" >
					<label style="width:100px">날짜</label>
					<input type="text" class="form-control" style="width:300px" readonly/>
					</div>

				</div>
				<div class="modal-footer">
					<input type="submit" class="btn btn-success" value="수정" />
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>


	<script src="js/jquery-3.2.1.slim.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script>
		$(function() {
			$('#btn-delete').click(function() {
				$('#deleteModal').modal('show');
			})
			$('#btn-update').click(function() {
				$('#updateModal').modal('show');
			})
		});
	</script>
</body>
</html>