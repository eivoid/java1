package com.ds.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ds.model.MemberDAO;
import com.ds.vo.V1_Member;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String a = request.getParameter("id");
		String b = request.getParameter("pw");
		
		System.out.println(a);
		System.out.println(b);
		
		//DB에 아이디 암호가 존재하는지 확인
		//DAO 객체 생성
		MemberDAO mDAO = new MemberDAO();
		//memberLogin 메소드 호출 vo가 리턴됨
		V1_Member vo = mDAO.memberLogin(a,b);
		if(vo!= null) {// 로그인 성공
			//세션 객체 생성 - new 로 만드는것아님. 가져옴.
			HttpSession httpsession
			 = request.getSession();
			//세션에 값넣기
			httpsession.setAttribute("SID", vo.getMem_id());
			httpsession.setAttribute("SNAME", vo.getMem_name());
			response.sendRedirect("index.do");
		}else {
			response.sendRedirect("login.do");
		}
		
		
	
	}

}
