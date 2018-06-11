package com.ds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardw.do")
public class BoardWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardWServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("title", "글쓰기");
		// boardw.do가 입력되면 /WEB-INF폴더에 있는boardw.jsp표시
		request.getRequestDispatcher("/WEB-INF/boardw.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
