package com.wendao.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * BLOB: 
 * 
 * @author lq2
 *
 */
public class JDBC06Blob {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InputStream is = null;
		OutputStream os = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db02?"
					+ "useUnicode=true&characterEncoding=UTF-8&"
					+ "useSSL=false",
					"lq",
					"123456");
//			ps = conn.prepareStatement("insert into tb_human "
//					+ "(name,headImg) values "
//					+ "(?,?)");
//			ps.setObject(1, "王使命");
//			ps.setBlob(2, new FileInputStream("/home/lq2/Pictures/dog2.jpg"));
			
			ps = conn.prepareStatement("select id,headImg from tb_human order by id desc limit 1");
			rs = ps.executeQuery();
			os = new FileOutputStream(new File("/home/lq2/Pictures/dog2cp.jpg"));
			
			while(rs.next()) {
				 Blob bl = rs.getBlob("headImg");
				 if (bl == null) {
					continue;
				}
				 is = bl.getBinaryStream();
				 int tmp = 0;
				 while((tmp = is.read()) != -1) {
//					 System.out.print((char)tmp);
					 os.write(tmp);
				 }
				 os.flush();
				 System.out.println();
			}
			
			
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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
		
		
		
		
		
		System.out.println("\n------ over ------");
	}
}













