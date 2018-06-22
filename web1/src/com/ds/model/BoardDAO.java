package com.ds.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ds.vo.V1_Board;

public class BoardDAO {
	
	public int updateBoardOne(V1_Board vo) {
		try {
			String sql = null;
			if(vo.getBrd_file()!=null) {
			sql = "UPDATE V1_BOARD "
					+" SET BRD_TITLE=?,"
					+" BRD_CONTENT=?,"
					+" BRD_WRITER=?,"
					+" BRD_FILE=? "
					+" WHERE BRD_NO=?";
			PreparedStatement ps = OracleConnStatic.getConn().prepareStatement(sql);
			ps.setString(1, vo.getBrd_title());
			ps.setString(2, vo.getBrd_content());
			ps.setString(3, vo.getBrd_writer());
			ps.setString(4, vo.getBrd_file());
			ps.setInt(5, vo.getBrd_no());
			return ps.executeUpdate();
			}
			else {
				sql = "UPDATE V1_BOARD"
						+" SET BRD_TITLE=?,"
						+" BRD_CONTENT=?,"
						+" BRD_WRITER=?,"
						+" WHERE BRD_NO=?";
				PreparedStatement ps = OracleConnStatic.getConn().prepareStatement(sql);
				ps.setString(1, vo.getBrd_title());
				ps.setString(2, vo.getBrd_content());
				ps.setString(3, vo.getBrd_writer());
				ps.setInt(4, vo.getBrd_no());
				return ps.executeUpdate();
			}
					
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
		
	}
	
	public int nextBoardNo(int no) {
		try {
			//NVL : 만약에 결과값이 있다면 앞쪽을 수행, 없으면 뒤쪽 수행 1번글의 경우를 대비하는것
			String sql = "SELECT NVL(MIN(BRD_NO), 0) BNO FROM V1_BOARD WHERE BRD_NO> ?"; 
			PreparedStatement ps = OracleConnStatic.getConn().prepareStatement(sql);
			ps.setInt(1, no);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("BNO");
			}
			return 0;
			
		}
	catch(Exception e) {
		System.out.println(e.getMessage());
		return 0;
	}
}
	
	public int prevBoardNo(int no) {
			try {
				//NVL : 만약에 결과값이 있다면 앞쪽을 수행, 없으면 뒤쪽 수행 1번글의 경우를 대비하는것
				String sql = "SELECT NVL(MAX(BRD_NO), 0) BNO FROM V1_BOARD WHERE BRD_NO< ?"; 
				PreparedStatement ps = OracleConnStatic.getConn().prepareStatement(sql);
				ps.setInt(1, no);
				
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getInt("BNO");
				}
				return 0;
				
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public V1_Board selectBoardOne(int no) {
		try {
			String sql = "SELECT * FROM V1_BOARD WHERE BRD_NO=?";
			PreparedStatement pstmt = OracleConnStatic.getConn().prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {//게시물이 없다면
				V1_Board vo = new V1_Board();
				vo.setBrd_no(rs.getInt("BRD_NO"));
				vo.setBrd_title(rs.getString("BRD_TITLE"));
				vo.setBrd_content(rs.getString("BRD_CONTENT"));
				vo.setBrd_writer(rs.getString("BRD_WRITER"));
				vo.setBrd_hit(rs.getInt("BRD_HIT"));
				vo.setBrd_file(rs.getString("BRD_FILE"));
				vo.setBrd_date(rs.getString("BRD_DATE"));
				return vo;
				
			}
			return null;
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public int updateBoardHit(int no) {
		try {
			//UPDATE 테이블명 set 바꿀필드명=바꿀값
			String sql = "UPDATE V1_BOARD SET BRD_HIT=BRD_HIT+1"
					+" WHERE BRD_NO = ?";
			PreparedStatement ps = OracleConnStatic.getConn().prepareStatement(sql);
			ps.setInt(1, no);
			return ps.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	
	//INSERT, UPDATE, DELETE => 리턴이 int
	public int insertBoard(V1_Board vo) {
		try {
			//INSERT INTO 테이블명(필드명..) VALUES(넣을값..)
			String sql = "INSERT INTO V1_BOARD(BRD_NO, BRD_TITLE, BRD_CONTENT, BRD_WRITER, BRD_HIT, BRD_DATE, BRD_FILE)"
					+ " VALUES(SEQ_V1_BOARD_NO.NEXTVAL,?,?,?,1,SYSDATE,?)";
			PreparedStatement ps = OracleConnStatic.getConn().prepareStatement(sql);
			ps.setString(1, vo.getBrd_title());
			ps.setString(2, vo.getBrd_content());
			ps.setString(3, vo.getBrd_writer());
			ps.setString(4, vo.getBrd_file());
			
			return ps.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
		
	}
	
	public List<V1_Board> selectBoardList(){
		try {
			//DESC 내림차순, ASC 오름차순
			String sql = "SELECT * FROM V1_BOARD ORDER BY BRD_NO DESC";
			PreparedStatement ps
				= OracleConnStatic.getConn().prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			//vo를 여러개 보관하기 위한 객체 생성
			List<V1_Board> list =new ArrayList<V1_Board>(); //list를 한번더 list로 감싸서 여러개의 리스트를 보낼수도 있다.
			while(rs.next()) {
				V1_Board vo = new V1_Board();
				vo.setBrd_no(rs.getInt("BRD_NO"));
				vo.setBrd_title(rs.getString("BRD_TITLE"));
				vo.setBrd_writer(rs.getString("BRD_WRITER"));
				vo.setBrd_hit(rs.getInt("BRD_HIT"));
				vo.setBrd_date(rs.getString("BRD_DATE"));
				vo.setBrd_file(rs.getString("BRD_FILE"));
				list.add(vo);//12
			}
			if(list.size()>0) {
			return list;
			}
			return null;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public List<V1_Board> selectBoardList1(int start){
		try {
			//DESC 내림차순, ASC 오름차순
			String sql = "SELECT * FROM " 
			+" (SELECT BRD_NO, BRD_TITLE, BRD_WRITER," 
			+"	TO_CHAR(BRD_HIT, '999,999,999,999') BRD_HIT1, BRD_FILE, "
			+" TO_CHAR(BRD_DATE, 'YYYY-MM-DD') BRD_DATE, "
			+"	ROW_NUMBER() OVER (ORDER BY BRD_NO DESC) ROWN"
			+"	FROM V1_BOARD)"
			+" WHERE ROWN BETWEEN ? AND ?";
			PreparedStatement ps
				= OracleConnStatic.getConn().prepareStatement(sql);
			ps.setInt(1, start); //1
			ps.setInt(2, start+9); //10
			
			ResultSet rs= ps.executeQuery();
			//vo를 여러개 보관하기 위한 객체 생성
			List<V1_Board> list =new ArrayList<V1_Board>(); //list를 한번더 list로 감싸서 여러개의 리스트를 보낼수도 있다.
			while(rs.next()) {
				V1_Board vo = new V1_Board();
				vo.setBrd_no(rs.getInt("BRD_NO"));
				vo.setBrd_title(rs.getString("BRD_TITLE"));
				vo.setBrd_writer(rs.getString("BRD_WRITER"));
				vo.setBrd_hit1(rs.getString("BRD_HIT1"));
				vo.setBrd_date(rs.getString("BRD_DATE"));
				vo.setBrd_file(rs.getString("BRD_FILE"));
				list.add(vo);//12
			}
			if(list.size()>0) {
			return list;
			}
			return null;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<V1_Board> selectBoardList2(int start, String type, String text){
		try {
			String sql = "SELECT * FROM ("
					+ " SELECT BRD_NO, BRD_FILE, BRD_TITLE, BRD_WRITER, "
					+ " TO_CHAR(BRD_HIT, '999,999,999,999') BRD_HIT1,"
					+ " TO_CHAR(BRD_DATE, 'YYYY-MM-DD') BRD_DATE, "
					+ " ROW_NUMBER() OVER (ORDER BY BRD_NO DESC) ROWN "
					+ " FROM V1_BOARD"
					+ " WHERE "+ type +" LIKE '%' || ? || '%'"
					+ " ) "
					+ " WHERE ROWN  BETWEEN ? AND ? ";
				PreparedStatement ps = OracleConnStatic.getConn().prepareStatement(sql);
				//ps.setString(1, type);
				ps.setString(1, text);
				ps.setInt(2, start);
				ps.setInt(3, start+9);

					
					ResultSet rs= ps.executeQuery();
					//vo를 여러개 보관하기 위한 객체 생성
					List<V1_Board> list =new ArrayList<V1_Board>(); //list를 한번더 list로 감싸서 여러개의 리스트를 보낼수도 있다.
					while(rs.next()) {
						V1_Board vo = new V1_Board();
						vo.setBrd_no(rs.getInt("BRD_NO"));
						vo.setBrd_title(rs.getString("BRD_TITLE"));
						vo.setBrd_writer(rs.getString("BRD_WRITER"));
						vo.setBrd_hit1(rs.getString("BRD_HIT1"));
						vo.setBrd_date(rs.getString("BRD_DATE"));
						vo.setBrd_file(rs.getString("BRD_FILE"));
						list.add(vo);//12
					}
					if(list.size()>0) {
					return list;
					}
					return null;
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public int selectBoardCount() {
		try {
			String sql = "SELECT COUNT(*) CNT FROM V1_BOARD";
			PreparedStatement ps
				= OracleConnStatic.getConn().prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("CNT");
			}
			return 0;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public int boardDelete(int no) {
		try {
			String sql = "DELETE FROM V1_BOARD WHERE BRD_NO=?";
			PreparedStatement ps
				= OracleConnStatic.getConn().prepareStatement(sql);
			ps.setInt(1, no);
			//INSERT, UPDATE, DELETE
			return ps.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
}
