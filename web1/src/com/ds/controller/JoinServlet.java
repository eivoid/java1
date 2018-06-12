package com.ds.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.activation.MailcapCommandMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.model.MemberDAO;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JoinServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//값을 보내는곳
		request.setAttribute("title", "회원가입"); //title="회원가입"
		request.setAttribute("num", 123); //num=123;
		
		//setAttribute로 보내고 jsp에서 getAttribute로 받는다 그떄jsp에서 자바문이기떄문에<% %>로 감싸준다.
		
		
		
		//jsp화면을 표시함.
		request.getRequestDispatcher("/WEB-INF/join.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//jsp에서 전달되는 값 받기 매개변수는 name값이다
		String a = request.getParameter("id");
		String b = request.getParameter("pw");
		String c = request.getParameter("name");
		String d = request.getParameter("age");
		String e = request.getParameter("email")+request.getParameter("email_select");
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);

		//Model을 통해 DB에 값을 추가함.
		MemberDAO obj = new MemberDAO();
		int ret = obj.memberJoin(a,b,c,d,e);
		if(ret ==1) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; character=UTF-8");
			out.println("<script>"
					+ "alert('회원가입되었습니다.');"
					+"location='index.do'"
					+"</script>");
		}else {
			response.sendRedirect("join.do");
		}
		//사용자에게 보여줄 페이지로 전환.
		
	}

}
