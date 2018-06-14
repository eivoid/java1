package com.ds.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//목록 보내기: List 에는 vo가 여러개 들어감
		List<V1_Board> list = new ArrayList<V1_Board>();
		for(int i=0;i<10;i++) {
		V1_Board vo = new V1_Board();
		vo.setBrd_no(i);
		vo.setBrd_title("제목");
		vo.setBrd_hit(2);
		vo.setBrd_writer("작성자");
		vo.setBrd_date("2018-06-14 16:50");
		list.add(vo);
		}
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/board.jsp")
		.forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
