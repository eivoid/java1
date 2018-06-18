package com.ds.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.model.BoardDAO;
import com.ds.vo.V1_Board;

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
		
		//DB에서 34에 해당하는 게시물 가져와서 jsp로 전달
		BoardDAO bDAO = new BoardDAO();
		V1_Board vo = bDAO.selectBoardOne( Integer.parseInt(no));
		
		//jsp로 전달
		request.setAttribute("vo", vo);
		
		//이전글
		int pno = bDAO.prevBoardNo(Integer.parseInt(no));
		request.setAttribute("pno", pno);
		//다음글
		int nno = bDAO.nextBoardNo(Integer.parseInt(no));
		request.setAttribute("nno", nno);
		
		request.getRequestDispatcher("/WEB-INF/boardc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}
