package com.wendao.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * jdbc util
 * 
 * @author lq2
 *
 */
public class JDBCUtil {
	
	static Properties pros = null; // 可以帮助读取和处理资源文件中的信息
	
	static {
		pros = new Properties();
		try {
			pros.load(Thread.currentThread()
					.getContextClassLoader()
					.getResourceAsStream(
							"db.properties"));
			
			System.out.println("static -> "+ pros.getProperty("mysqlURL"));
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static java.sql.Connection getMysqlConn() {
		try {
			Class.forName(pros.getProperty("mysqlDriver"));

			return DriverManager.getConnection(
					pros.getProperty("mysqlURL"),
					pros.getProperty("mysqlUser"), 
					pros.getProperty("mysqlPwd"));
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void close(AutoCloseable... args) {
		for (AutoCloseable arg : args) {
			System.out.println("close: " + arg);
			try {
				arg.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("------ close all over ------");
	}

//	public static void main(String[] args) throws Exception {
//		System.out.println("main");
//
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection conn = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306/db02?" + "useUnicode=true&characterEncoding=UTF-8&" + "useSSL=false", "lq",
//				"123456");
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("select * from tb_human");
//
//		close(rs, stmt, conn);
//	}

}
