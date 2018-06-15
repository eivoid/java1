package com.ds.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.model.BoardDAO;
import com.ds.vo.V1_Board;

@WebServlet("/board.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] str = {"글번호", "제목", "작성자", "조회수", "날짜"};
		//C -> V 로 값전달
		request.setAttribute("str", str);
		
		request.setAttribute("aaa", "AAA");

		BoardDAO bDAO = new BoardDAO();
		List<V1_Board> list = bDAO.selectBoardList();
		request.setAttribute("list", list);
		//view표시
		request.getRequestDispatcher("/WEB-INF/board.jsp")
		.forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
