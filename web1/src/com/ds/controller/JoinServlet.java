package com.ds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		doGet(request, response);
	}

}
