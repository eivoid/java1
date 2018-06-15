package com.ds.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.model.BoardDAO;

@WebServlet("/boardc.do")
public class BoardCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardCServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// boardc.do?no=34
		String no = request.getParameter("no");

		// 조회수를 1증가시키고no에 해당하는 게시물을 1개를 가져와서 표시
		
		
		request.getRequestDispatcher("/WEB-INF/boardc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}
