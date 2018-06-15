package com.ds.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ds.vo.V1_Member;

public class TableDAO {
	public V1_Member[] view() {
		
		try {
			V1_Member[] vo = null;
			String sql2 = "SELECT COUNT(MEM_ID) FROM V1_MEMBER";
			PreparedStatement ps2 = OracleConnStatic.getConn().prepareStatement(sql2);
			ResultSet rs2 = ps2.executeQuery();
			if(rs2.next()) {
				vo = new V1_Member[rs2.getInt(1)];
			}
			
			String sql = "SELECT * FROM V1_MEMBER ";
			PreparedStatement ps = OracleConnStatic.getConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			for(int i=0;i<rs2.getInt(1);i++) {
			while(rs.next()) {
				vo[i] = new V1_Member();
				vo[i].setMem_id(rs.getString("MEM_ID"));
				vo[i].setMem_pw(rs.getString("MEM_PW"));
				vo[i].setMem_name(rs.getString("MEM_NAME"));
				vo[i].setMem_age(rs.getInt("MEM_AGE"));
				//vo[i].setMem_date(rs.getDate("MEM_DATE"));
				vo[i].setMem_email(rs.getString("MEM_EMAIL"));
				
			}
			}
			return vo;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
