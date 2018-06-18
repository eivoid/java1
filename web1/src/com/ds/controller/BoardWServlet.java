package com.ds.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.model.BoardDAO;
import com.ds.vo.V1_Board;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/boardw.do")
public class BoardWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardWServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("title", "글쓰기");
		// boardw.do가 입력되면 /WEB-INF폴더에 있는boardw.jsp표시
		request.getRequestDispatcher("/WEB-INF/boardw.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
		// 1. 파일첨부 : 용량
		int maxSize = 1024*1024*10;	//10M
		// 2. 저장위치 : 서버의 특정 폴더에 복사 ,DB를 사용하면 바로 DB에 저장된다 
		String root = request.getSession().getServletContext().getRealPath("/");
		System.out.println(root);
		// 3. request 를 multipartrequest로 변경
		//request, 저장위치, 용량사이즈, 한글처리, 동일파일처리방법
		MultipartRequest multi
			= new MultipartRequest(request, root, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		//jsp에서 오는 값출력	
		String t = multi.getParameter("title");
		String c =multi.getParameter("content");
		String w =multi.getParameter("writer");
		
		System.out.println(t);
		System.out.println(c);
		System.out.println(w);
		//vo 생성
		V1_Board vo = new V1_Board();
		vo.setBrd_content(c);
		vo.setBrd_title(t);
		vo.setBrd_writer(w);
		vo.setBrd_file(multi.getFilesystemName("img"));
		//DAO에 VO 값 전달
		BoardDAO bDAO = new BoardDAO();
		bDAO.insertBoard(vo);
		//글쓰기가 완료되면 글목록으로 이동함.
		response.sendRedirect("board.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
