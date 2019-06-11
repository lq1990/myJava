package com.wendao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

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
			
			for(int i=0; i<1000; i++) {
				if (i% 100 == 0) {
					System.out.println(i);
				}
				
				String sql = "insert into tb_human (name,lastLoginTime) "
						+ "values (?,?)";
				ps = conn.prepareStatement(sql);
				
				int rand = 100000000 + new Random().nextInt(1000000000);
				java.sql.Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis()-rand);
				ps.setObject(1, "天天"+i);
				ps.setTimestamp(2, ts);
				
				ps.execute();
			}
			
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
















