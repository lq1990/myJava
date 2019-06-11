package com.wendao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 取出一个时间段的数据
 * @author lq2
 *
 */
public class JDBC04Select {
	
	/**
	 * convert strDate to long which represents a date
	 * 格式：yyyy-MM-dd hh:mm:ss
	 * @param strDate
	 * @return
	 * @throws ParseException 
	 */
	private static long str2DateLong(String strDate) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(strDate).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// load Driver class
			Class.forName("com.mysql.jdbc.Driver");
			// connect
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db02?"
					+ "useUnicode=true&characterEncoding=UTF-8&"
					+ "useSSL=false", 
					"lq", 
					"123456");
			ps = conn.prepareStatement(
					"select * from tb_human where "
					+ "lastLoginTime>? and lastLoginTime<? order by lastLoginTime");
			java.sql.Timestamp start = new Timestamp(str2DateLong("2019-06-04 00:00:00"));
			java.sql.Timestamp end = new Timestamp(str2DateLong("2019-06-05 00:00:00"));
			ps.setObject(1, start);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			
			while(rs.next()) { // next() 移动游标
				System.out.println(rs.getObject("id")+"\t"+
						rs.getObject("name")+"\t"+
						rs.getObject("lastLoginTime"));
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
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		System.out.println("over");
	}
	
	
}











