package com.ds.app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberModel {
	Connection conn;

	public void connOracle() {
		try {
			// 1. Driver 설치 - jodbc.jar 파일이 있어야 됨.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DB접속(접속할 서버주소, 아이디, 암호 필요)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "1234");
			if (conn != null) {
				System.out.println("오라클 접속 성공");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 접속 실패");
			// 개발자를 위한 오류메세지 출력
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}

	public void memberJoin(String id) {
		try {
			System.out.println("M에서 :" + id);
			System.out.println("회원가입");

			// INSERT INTO 테이블명(필드명,,,) VALUES(추가할값들,,,)
			String sql = "INSERT INTO V1_MEMBER(MEM_ID, MEM_PW, " + " MEM_NAME, MEM_AGE, MEM_EMAIL, MEM_DATE) "
					+ " VALUES(?,'b','가나다',14,'a@naver.com',SYSDATE)";
			

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void abc() {
		System.out.println("그냥");
	}

}
