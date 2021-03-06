package com.ds.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.model.TableDAO;
import com.ds.model.TableDAO2;
import com.ds.vo.V1_Member;

@WebServlet("/table.do")
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TableServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] str = {"아이디", "패스워드", "이름", "나이", "이메일", "날짜"};
		request.setAttribute("str", str);
		TableDAO2 tDAO = new TableDAO2();
		List<V1_Member> list = tDAO.view();
		request.setAttribute("list", list);
		
		

		request.getRequestDispatcher("/WEB-INF/table.jsp")
		.forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
