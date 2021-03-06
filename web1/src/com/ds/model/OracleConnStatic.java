package com.ds.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnStatic {

		public static Connection getConn() {
			try {
				//1.Driver 설치 -ojdbc6.jar파일이 있어야 함.
				Class.forName("oracle.jdbc.driver.OracleDriver");

				//2.DB 접속(접속할 서버주소, 아이디, 암호)필요
				Connection conn = DriverManager.getConnection(Config.dburl, Config.dbid, Config.dbpw);
				System.out.println("오라클 접속 성공");
				return conn;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
}
