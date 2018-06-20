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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//숫자이지만 String으로 생성함.
			//getParameter가 리턴되는 값이 String
			String page = request.getParameter("page");
			if(page ==null) {
				page ="1"; //page = 1
			}

			String[] str = { "글번호", "제목", "작성자", "조회수", "날짜" };
			// C -> V 로 값전달
			request.setAttribute("str", str);

			request.setAttribute("aaa", "AAA");
			//목록
			//page     start
			//1 -> 1 and 10
			//2 -> 11 and 20
			//3 -> 21 and 30
			//(Integer.parseInt(page)-1)*10 +1
			BoardDAO bDAO = new BoardDAO();
			List<V1_Board> list = bDAO.selectBoardList1((Integer.parseInt(page)-1)*10 +1);
			request.setAttribute("list", list);

			// 전체 게시물 수
			int cnt = bDAO.selectBoardCount();
			// 9 ->1개 11->2개 23->3개 (cnt-1)/10 +1
			request.setAttribute("cnt", (cnt - 1) / 10 + 1);

			// view표시
			request.getRequestDispatcher("/WEB-INF/board.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
