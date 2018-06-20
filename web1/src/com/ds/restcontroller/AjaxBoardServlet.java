package com.ds.restcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.ds.model.BoardDAO;
import com.ds.vo.V1_Board;

@WebServlet("/ajaxboardone.do")
public class AjaxBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String no = request.getParameter("no");
			//DAO로 글번호를 전달해서 글번호에 해당하는 게시물 가져옴.
			BoardDAO bDAO = new BoardDAO();
			V1_Board vo = bDAO.selectBoardOne(
					Integer.parseInt(no));
			//vo의 값을 json문서로 변경
			JSONObject jobj = new JSONObject();
			//글번호, 글제목, 글내용, 작성자, 조회수, 이미지, 날짜
			//{"brd_no":33 brd_title..
			jobj.put("brd_no", vo.getBrd_no());
			jobj.put("brd_title", vo.getBrd_title());
			jobj.put("brd_content", vo.getBrd_content());
			jobj.put("brd_writer", vo.getBrd_writer());
			jobj.put("brd_hit1", vo.getBrd_hit1());
			jobj.put("brd_file", vo.getBrd_file());
			jobj.put("brd_date", vo.getBrd_date());
			
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			//출력
			PrintWriter out = response.getWriter();
			out.print(jobj.toString());
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
