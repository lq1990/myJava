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
 * List<javabean>
 * 
 * @author lq2
 *
 */
public class SORM03Javabean {
	public static void main(String[] args) {
		List<Emp> list = new ArrayList<Emp>();

		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("select empname,salary,age from tb_emp");
			rs = ps.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpname(rs.getString("empname"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setAge(rs.getInt("age"));
				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}

		// show list
		for (Emp emp : list) {
			System.out.println("javabean -> "+emp.getEmpname()+", "+
					emp.getSalary()+", "+emp.getAge());
		}

		System.out.println("\n--- over ---");
	}
}
