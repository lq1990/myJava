package com.wendao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * use util
 * 
 * @author lq2
 *
 */
public class JDBC07UseUtil {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCUtil.getMysqlConn();
			ps = conn.prepareStatement("insert into tb_human "
					+ "(name) values "
					+ "(?)");
			ps.setObject(1, "灵龟");
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, conn);
		}

	}
}
