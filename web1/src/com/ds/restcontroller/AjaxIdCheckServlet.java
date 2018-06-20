package com.ds.restcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.ds.model.MemberDAO;

@WebServlet("/ajaxidcheck.do")
public class AjaxIdCheckServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public AjaxIdCheckServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			PrintWriter out = resp.getWriter();
			
			MemberDAO mDAO = new MemberDAO();
			int result = mDAO.memberIDCheck(id);
			
			//id를 사용할 수 있으면{"ret", "y"}
			//id를 사용할 수 없으면{"ret": "n"}
			JSONObject jobj = new JSONObject();
			jobj.put("ret", "n"); // if else 조건이 길 경우 먼저 실행되게 한 후 if문으로 바꿀수 있게 한다.
			if(result == 0) {
			jobj.put("ret", "y");
			}
			
			out.print(jobj.toString());
		}
		catch(Exception e ) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	
	
}
