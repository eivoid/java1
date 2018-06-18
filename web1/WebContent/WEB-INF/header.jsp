<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpSession httpsession = request.getSession();
	String id = (String) httpsession.getAttribute("SID");
	String name = (String) httpsession.getAttribute("SNAME");
%>    

<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
<div class="container">
  <a class="navbar-brand" href="#">WEB1</a>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.do">홈 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
      <% if(id == null) {%> 
		<a class="nav-link" href="login.do">로그인</a>
		<% } else { %>
		<a class="nav-link" href="logout.do">로그아웃</a>
		<% } %>
        
      </li>
      <li class="nav-item">
      	<a class="nav-link" href="board.do">게시판</a>
      </li>
      <li class="nav-item">
      	<a class="nav-link" href="join.do">회원 가입</a>
      </li>
      <li class="nav-item">
      	<a class="nav-link" href="table.do">회원 보기</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
  </div>
</nav>
