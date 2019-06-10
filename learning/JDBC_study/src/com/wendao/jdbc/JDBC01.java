package com.wendao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBC01 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// load Driver class
			Class.forName("com.mysql.jdbc.Driver");
			// connect
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db01?useUnicode=true&characterEncoding=UTF-8&useSSL=false", 
					"lq", 
					"123456");
			
			stmt = conn.createStatement();
			stmt.executeUpdate(
					"insert into tb_human (id,name) values (1002,'李四')");
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		System.out.println("over");
	}
}



