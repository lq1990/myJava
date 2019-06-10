package com.wendao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC02Transaction {
	public static void main(String[] args) throws InterruptedException {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		
		try {
			// load Driver class
			Class.forName("com.mysql.jdbc.Driver");
			// connect
			String url = "jdbc:mysql://localhost:3306/db01?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
			String user = "lq";
			String password = "123456";
			conn = DriverManager.getConnection(url, user, password);
			
			conn.setAutoCommit(false); // true as default, 默认是自动提交
			
			// execute sql
			String sql = "insert into tb_human (id,name,salary) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 1003);
			ps.setObject(2, "王五");
			ps.setObject(3, 10000.0);
			ps.execute();
			System.out.println("insert 1");
			
			Thread.sleep(3000);
			
			sql = "insert into tb_human (id,name) values (?,?,?)";
			ps2 = conn.prepareStatement(sql);
			ps2.setObject(1, 1004);
			ps2.setObject(2, "王6");
			ps2.execute();
			System.out.println("insert 2");
			
			conn.commit();
			
			// commit前若出现error，则所有的操作作废，回滚到操作前的数据状态
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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














