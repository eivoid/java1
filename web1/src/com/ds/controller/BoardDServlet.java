package com.ds.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.model.BoardDAO;

@WebServlet("/boardd.do")
public class BoardDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no= request.getParameter("no");
		try {
			BoardDAO bDAO = new BoardDAO();
			bDAO.boardDelete(Integer.parseInt(no));
			
			response.sendRedirect("board.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect("board.do?no="+no);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
