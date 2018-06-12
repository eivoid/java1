package com.ds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.model.MemberDAO;

@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/delete.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// jsp에서 전달되는 값 받기 매개변수는 name값이다
		String a = request.getParameter("id");
		MemberDAO obj = new MemberDAO();
		obj.memberDelete(a);
		//사용자에게 보여줄 페이지로 전환.
		response.sendRedirect("delete.do");
	}

}
