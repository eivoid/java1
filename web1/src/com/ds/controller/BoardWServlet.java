package com.ds.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.model.BoardDAO;
import com.ds.vo.V1_Board;

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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
		
		String t = request.getParameter("title");
		String c =request.getParameter("content");
		String w =request.getParameter("writer");
		
		System.out.println(t);
		System.out.println(c);
		System.out.println(w);
		//vo 생성
		V1_Board vo = new V1_Board();
		vo.setBrd_content(c);
		vo.setBrd_title(t);
		vo.setBrd_writer(w);
		//DAO에 VO 값 전달
		BoardDAO bDAO = new BoardDAO();
		bDAO.insertBoard(vo);
		//글쓰기가 완료되면 글목록으로 이동함.
		response.sendRedirect("board.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
