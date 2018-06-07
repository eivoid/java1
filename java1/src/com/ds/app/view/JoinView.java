package com.ds.app.view;

import java.util.Scanner;

public class JoinView {
	public String jsp() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("회원정보입력");
		String id = scanner.nextLine();
		String pw = scanner.nextLine();
		String name = scanner.nextLine();
		String age = scanner.nextLine();
		
		String email = scanner.nextLine();

		System.out.println("아이디 : " + id);
		System.out.println("암호   : " + pw);
		System.out.println("이름   : " + name);
		System.out.println("나이   : " + age);
		System.out.println("이메일 : " + email);
		return id;
	}
}
