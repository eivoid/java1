package com.ds.model;

import java.sql.PreparedStatement;

public class MemberDAO {
	public void memberLogin() {

	}

	public int memberJoin(String a, String b, String c, String d, String e) {
		try {
			// INSERT INTO 테이블명(필드명,,) VALUES('추가할값',,,)
			String sql = "INSERT INTO V1_MEMBER(MEM_ID,MEM_PW," + "MEM_NAME,MEM_AGE,MEM_EMAIL,MEM_DATE) VALUES"
					+ "(?,?,?,?,?,SYSDATE)";
			// 클래스명.static메소드명();
			PreparedStatement ps = OracleConnStatic.getConn().prepareStatement(sql);// conn 사용

			ps.setString(1, a);
			ps.setString(2, b);
			ps.setString(3, c);
			ps.setInt(4, Integer.parseInt(d));// 문자를 숫자로 변환
			ps.setString(5, e);// SQL문?완성
			return ps.executeUpdate();// SQL문 수행

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return 0;
		}
	}

	public void changePassword() {

	}

	public void memberEdit() {

	}

	public void memberDelete(String a) {
		try {
			// INSERT INTO 테이블명(필드명,,) VALUES('추가할값',,,)
			String sql = "DELETE FROM V1_MEMBER WHERE MEM_ID=?";
			// 클래스명.static메소드명();
			PreparedStatement ps = OracleConnStatic.getConn().prepareStatement(sql);// conn 사용

			ps.setString(1, a);

			ps.execute();// SQL문 수행

		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		}
	}
}
