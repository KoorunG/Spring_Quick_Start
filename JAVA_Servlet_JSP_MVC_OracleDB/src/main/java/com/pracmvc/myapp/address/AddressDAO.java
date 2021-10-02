package com.pracmvc.myapp.address;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pracmvc.myapp.common.JDBCUtil;

public class AddressDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	
	// insert 쿼리
	private static final String INSERT_ADDRESS = "insert into jsp_address values(idx_seq.nextVal, ?, ?)";
	
	// insert 메소드
	public void insertAddress(AddressVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(INSERT_ADDRESS);
			stmt.setString(1, vo.getMainAddress());
			stmt.setString(2, vo.getSubAddress());
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}
