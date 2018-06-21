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

	<form action="boarde.do" method="post" enctype="multipart/form-data">
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
							id="brd_no" name="brd_no" class="form-control" readonly />
					</div>
					<div class="form-inline" style="margin-bottom:5px" >
					<label style="width:100px">글제목</label>
					<input type="text" id="brd_title" name="brd_title" class="form-control" style="width:300px"/>
					</div>
					<div class="form-inline" style="margin-bottom:5px" >
					<label style="width:100px">글내용</label>
					<textarea class="form-control" id="brd_content" name="brd_content" rows="6" style="width:500px"></textarea>
					</div>
					<div class="form-inline" style="margin-bottom:5px" >
					<label style="width:100px">작성자</label>
					<input type="text" id="brd_writer" name="brd_writer" class="form-control" style="width:300px"/>
					</div>
					<div class="form-inline" style="margin-bottom:5px" >
					<label style="width:100px">조회수</label>
					<input type="text" id="brd_hit" name="brd_hit" class="form-control" style="width:300px" readonly/>
					</div>
					<div class="form-inline" style="margin-bottom:5px" >
					<label style="width:100px">이미지</label>
					<a href="#">
					<img src="default.jpg" id="brd_file" width="100px" height="100px" />
					</a>
					<input type="file" name="brd_file" class="form-control"  style="display:none" />
					</div>
					<div class="form-inline" style="margin-bottom:5px" >
					<label style="width:100px">날짜</label>
					<input type="text" id="brd_date" name="brd_date" class="form-control" style="width:300px" readonly/>
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
	</form>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script>
		$(function() {
			//삭제 버튼 누르면 삭제 모달창 표시
			$('#btn-delete').click(function() {
				$('#deleteModal').modal('show');
			});
			//수정 버튼 누르면 수정 모달창 표시
			$('#btn-update').click(function() {
				$('#updateModal').modal('show');
			});
			//수정모달창이 화면에 표시되면
			$('#updateModal').on('shown.bs.modal', function(){
				//주소가 ajaxboardone.do 인 서블릿 호출후 결과값 받기
				$.get('ajaxboardone.do?no='+'${vo.brd_no}', function(data){//data 를 vo 처럼 쓸수있다.
					$('#brd_no').val(data.brd_no);
					$('#brd_title').val(data.brd_title);
					$('#brd_content').val(data.brd_content);
					$('#brd_writer').val(data.brd_writer);
					$('#brd_date').val(data.brd_date);
					$('#brd_hit').val(data.brd_hit);
					
					//값을 비교 ==, !=
					//type비교 ===, !==
					if(typeof data.brd_file !=="undefined"){
						$('#brd_file').attr('src', data.brd_file);
					}
					console.log(data); //크롬의 콘솔
				}, 'json');
			});
			//파일첨부 값이 변경되면
			$('input[type=file]').change(function(){
				var img = this; //파일정보를 img변수에 넣음 여러개 선택하려면 multiple 속성을 input에서 줘야한다.
				if(img.files && img.files[0]){ //첨부가 된경우
					var reader = new FileReader();  
				 	reader.onload = function(e){ // 쓰레드 이부분은 백그라운드로 돌아간다.
				 		$('#brd_file').attr('src', e.target.result);
				 	};
				 	reader.readAsDataURL(img.files[0]);
				}
				else{ //첨부가 되지않은 경우
					
				}
			});
			
			$('#brd_file').click(function(){
				$('input[type=file]').click();
			})
		});
	</script>
</body>
</html>