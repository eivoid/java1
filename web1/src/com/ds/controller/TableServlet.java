package com.ds.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.model.TableDAO;
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
		TableDAO tDAO = new TableDAO();
		V1_Member[] vo= tDAO.view();
		String v1 = "vo[1].getMem_id()";
		request.setAttribute("v1", v1);
		String[] vstr = {"vo[0].getMem_id()","vo[0].getMem_pw()","vo[0].getMem_name()",
				         "vo[0].getMem_age()","vo[0].getMem_email()"};
		request.setAttribute("vstr", vstr);
/*		for(int i=0;i<vo.length;i++)
			request.setAttribute("vo[i]", vo[i]);
*/			//new "vo[i].getMem_id()","vo[i].getMem_pw()","vo[i].getMem_name()",
				//	"vo[i].getMem_age()","vo[i].getMem_email()"," "
			
		
		

		request.getRequestDispatcher("/WEB-INF/table.jsp")
		.forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
