package com.ds.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ds.vo.V1_Member;

public class MemberDAO {
	public V1_Member memberLogin(String id, String pw) {
		try {
			//SELECT * FROM 테이블명 WHERE 조건
			String sql = "SELECT * FROM V1_MEMBER " //공백띄우는 습관 중요
					+ " WHERE MEM_ID=? AND MEM_PW=?";
			
			PreparedStatement ps = OracleConnStatic.getConn().prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			//insert, update, delete => ps.executeUpdate()
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				V1_Member vo = new V1_Member();
				vo.setMem_id(rs.getString("MEM_ID"));
				vo.setMem_name(rs.getString("MEM_NAME"));
				vo.setMem_age(rs.getInt("MEM_AGE"));
				vo.setMem_email(rs.getString("MEM_EMAIL"));
				return vo; //return이 있으면 굳이 else 가 필요없다.
			}
			return null;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
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
