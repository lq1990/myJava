package com.wendao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * java.sql.Date
 * java.sql.Time
 * java.sql.Timestamp
 * 
 * @author lq2
 *
 */
public class JDBC03Date {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db02?useUnicode=true&characterEncoding=UTF-8&useSSL=false", 
					"lq", 
					"123456");
			
			String sql = "insert into tb_human (name,regTime) "
					+ "values (?,?)";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "花花");
			ps.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
			
			ps.executeUpdate();
			
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		System.out.println("over");
	}
}
















