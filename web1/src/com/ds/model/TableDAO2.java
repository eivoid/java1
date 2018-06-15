package com.ds.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ds.vo.V1_Board;
import com.ds.vo.V1_Member;

public class TableDAO2 {
	public List<V1_Member> view() {

		V1_Member vo = null;
		try {

			String sql = "SELECT * FROM V1_MEMBER ";
			PreparedStatement ps = OracleConnStatic.getConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<V1_Member> list = new ArrayList<V1_Member>();
			while (rs.next()) {
				vo = new V1_Member();
				vo.setMem_id(rs.getString("MEM_ID"));
				vo.setMem_pw(rs.getString("MEM_PW"));
				vo.setMem_name(rs.getString("MEM_NAME"));
				vo.setMem_age(rs.getInt("MEM_AGE"));
				vo.setMem_date(rs.getString("MEM_DATE"));
				vo.setMem_email(rs.getString("MEM_EMAIL"));
				list.add(vo);
			}
			if (list.size() > 0) {
				return list;
			}
			return null;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
