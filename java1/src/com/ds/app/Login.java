package com.ds.app;

import com.ds.app.model.MemberModel;
import com.ds.app.view.LoginView;
import com.ds.app.vo.V1_Member;

public class Login {

	public static void main(String[] args) {
		//vo를 생성함
		//클래스명 객체명 = new 클래스명()
		V1_Member vo = new V1_Member();
		
		//클래스명 객체명 = new 클래스명()
		LoginView view = new LoginView();
		view.jsp(vo);
		System.out.println("입력후 -" + vo.toString());
		
		//클래스명 객체명 = new 클래스명()
		MemberModel model = new MemberModel();
		model.connOracle();//DB접속
		model.login(vo);//LoginView의 객체 view를 전달.
		System.out.println("로그인후 -" + vo.toString());
	}

}
