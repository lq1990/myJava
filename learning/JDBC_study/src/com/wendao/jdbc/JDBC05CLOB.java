package com.wendao.jdbc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * character large object
 * 
 * @author lq2
 *
 */
public class JDBC05CLOB {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reader r = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db02?"
					+ "useUnicode=true&characterEncoding=UTF-8&"
					+ "useSSL=false",
					"lq",
					"123456");
			
			// set Clob
//			ps = conn.prepareStatement("insert into tb_human "
//					+ "(name,myInfo) values "
//					+ "(?,?)");
//			ps.setObject(1, "雷雷");
//			ps.setClob(2, new FileReader(new File("/home/lq2/Documents/myJava/learning/JDBC_study/src/info.txt")));
//			ps.setObject(1, "棍棍");
//			ps.setClob(2,
//					new BufferedReader(
//					new InputStreamReader(
//							new ByteArrayInputStream(
//									"简介：宇宙第一人。".getBytes()))));
			
			// get Clob
			ps = conn.prepareStatement("select name,myInfo from tb_human order by id desc limit 5");
			rs = ps.executeQuery();
			while(rs.next()) {
				String name = (String) rs.getObject("name");
				System.out.println("--- "+name+" ---");
				
				Clob cl = rs.getClob("myInfo");
				r = cl.getCharacterStream();
				
				int tmp = 0;
				while((tmp = r.read()) != -1) {
					System.out.print((char)tmp);
				}
				System.out.println();
			}
			
			
			
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != r) {
				try {
					r.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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











