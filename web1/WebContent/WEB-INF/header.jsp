<%@page import="javax.net.ssl.HttpsURLConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	HttpSession httpsession = request.getSession();
 	String id = (String) httpsession.getAttribute("SID");
 	String name = (String) httpsession.getAttribute("SNAME");
 	
 	
 %>
<a href="index.do">홈<a>
<% if(id == null) {%>
<a href="login.do">로그인</a> 
<% } else { %>
<a href="logout.do"><%=name %>님 로그아웃</a>
<% } %>
<a href="join.do">회원가입</a>
<a href="board.do">게시판</a>
<a href="table.do">테이블 보기</a>
<a href="delete.do">테이블 행 삭제</a>