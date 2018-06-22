package com.ds.sts1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ds.sts.func.EncryptionClass;

@Controller

public class MemberController {
	
	@RequestMapping(value="join.do", method=RequestMethod.GET)
	public String join(HttpServletRequest request, HttpServletResponse response) {
		return "join"; //join.jsp표시 기존 servlet에서는 아래에 해당하는 부분이다.
		//request.getRequestDispatcher("/WEB-INF/boardw.jsp").forward(request, response);
	}
	
	@RequestMapping(value="join.do", method=RequestMethod.POST)
	public String joinp(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		//입력한 암호를 전달해서 암호화 한 값을 pw변수에 넣음
		pw = EncryptionClass.convertMD5(pw);
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		
		return "redirect:join.do";
		//response.sendRedirect
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String login() {
		return "join";
	}
}
