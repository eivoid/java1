package com.ds.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.model.BoardDAO;

@WebServlet("/boardup.do")
public class BoardUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");

		// 조회수를 1증가시키고no에 해당하는 게시물을 1개를 가져와서 표시
		BoardDAO bDAO = new BoardDAO();
		int ret = bDAO.updateBoardHit(Integer.parseInt(no));
		response.sendRedirect("boardc.do?no="+no);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
