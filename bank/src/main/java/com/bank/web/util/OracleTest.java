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
			conn = DriverManager.getConnection(
					Constants.ORACLE_URL, 
					Constants.ORACLE_ID, 
					Constants.ORACLE_PASS
					);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT email FROM employees");
			String name = null;
			while (rs.next()) {
				name = rs.getString("email");
			}
			System.out.println("이름 : " + name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
