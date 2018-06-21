package com.ds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.model.BoardDAO;
import com.ds.vo.V1_Board;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/boarde.do")
public class BoardEServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardEServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			int maxSize = 1024*1024*10; //10M 제한
			String path =request.getSession().getServletContext().getRealPath("/");
			//request => multirequest
			MultipartRequest multi = 
					new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			//글번호, 글제목, 글내용, 작성자, 이미지, 조회수, 날짜
			String brd_no = multi.getParameter("brd_no");
			String brd_title =multi.getParameter("brd_title");
			String brd_content =multi.getParameter("brd_content");
			String brd_writer =multi.getParameter("brd_writer");
			String brd_file = multi.getFilesystemName("brd_file");
			
			
			System.out.println(brd_no);
			System.out.println(brd_title);
			System.out.println(brd_content);
			System.out.println(brd_writer);
			System.out.println(brd_file);
		
			
			V1_Board vo = new V1_Board(
					Integer.parseInt(brd_no), 
					brd_title, 
					brd_content, 
					brd_writer, 
					brd_file);
			
			BoardDAO bDAO = new BoardDAO();
			bDAO.updateBoardOne(vo);
			response.sendRedirect("boardc.do?no="+brd_no);
			
			
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


