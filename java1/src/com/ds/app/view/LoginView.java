package com.ds.app.view;

import java.util.Scanner;

import com.ds.app.vo.V1_Member;

public class LoginView {
	

	public void jsp(V1_Member vo) {
		try {
			Scanner in = new Scanner(System.in);
			
			vo.setMem_id(in.nextLine());
			vo.setMem_pw(in.nextLine());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void jsp1() throws Exception { // throws는 오류를 메인메서드쪽으로 보낸다. try catch는 스스로 처리한다.
	}
}
