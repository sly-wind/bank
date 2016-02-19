package com.bank.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleTest {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL,
					Constants.ORACLE_ID,
					Constants.ORACLE_PASS
					);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM test");
			String name = null;
			while (rs.next()) {
				name = rs.getString("name");
			}
			System.out.println(name);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
