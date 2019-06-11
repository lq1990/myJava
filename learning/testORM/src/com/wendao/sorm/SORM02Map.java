package com.wendao.sorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map stores a record.
 * 
 * @author lq2
 *
 */
public class SORM02Map {
	public static void main(String[] args) {
		List<Map<String, Object>> list = 
				new ArrayList<Map<String, Object>>();

		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("select empname,salary,age from tb_emp");
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> mp = new HashMap<String, Object>();
				mp.put("empname", rs.getObject(1));
				mp.put("salary", rs.getObject(2));
				mp.put("age", rs.getObject(3));
				list.add(mp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}

		// show list
		for (Map<String, Object> mp : list) {
			
			for(String k : mp.keySet()) {
				System.out.print(k + ": "+mp.get(k)+"    ");
			}
			System.out.println();
		}

		System.out.println("\n--- over ---");
	}
}
