package com.ds.app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ds.app.vo.V1_Member;

public class MemberModel {
	Connection conn;

	public void login(V1_Member vo) {
		//SELECT*FROM 테이블명 WHERE 조건
		//INSERT INTO 테이블명(필드명) VALUES(추가할값)
		//DELETE FROM 테이블명 WHERE 조건
		//UPDATE 테이블명 SET 필드명 = 바꿀값 WHERE 조건
		String sql = "SELECT * FROM V1_MEMBER "
				+"WHERE MEM_ID=? AND MEM_PW=? ";
		try {
			//클래스명 객체명 = new 클래스명() 여기
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getMem_id());
			ps.setString(2, vo.getMem_pw());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {//결과값이 있따면
				vo.setMem_id(rs.getString("MEM_ID"));
				vo.setMem_pw(rs.getString("MEM_PW"));
				vo.setMem_name(rs.getString("MEM_NAME"));
				vo.setMem_age(rs.getInt("MEM_AGE"));
				vo.setMem_email(rs.getString("MEM_EMAIL"));
				vo.setMem_date(rs.getString("MEM_DATE"));
			}
			else {//결과값이 없다면
				System.out.println("로그인실패");
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

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
			// e.printStackTrace();
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

}
