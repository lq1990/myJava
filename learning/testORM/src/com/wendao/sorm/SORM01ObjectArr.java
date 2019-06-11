package com.wendao.sorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * db => java
 * 1. a record => Object[], list<Object> stores many records.
 * 
 * </pre>
 * @author lq2
 *
 */
public class SORM01ObjectArr {
	public static void main(String[] args) {
//		Object[] objs = null; // 优点：即使下面jdbc操作关闭了，一条记录，数据依然保留下来了。
		List<Object[]> list = new ArrayList<Object[]>();
		
		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"select empname,salary,age from tb_emp");
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Object[] objs = new Object[3]; // 注意：objs的new必须放到循环内部。
				// 用Object[] stores fields
//				System.out.println(rs.getObject(1)+
//						", "+rs.getObject(2)+
//						", "+rs.getObject(3));
				objs[0] = rs.getObject(1);
				objs[1] = rs.getObject(2);
				objs[2] = rs.getObject(3);
				list.add(objs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
		// show list
		for (Object[] objs : list) {
			System.out.println(""+objs[0]+", "+objs[1]+", "+objs[2]);
		}
		
		System.out.println("\n--- over ---");
	}
	
}
