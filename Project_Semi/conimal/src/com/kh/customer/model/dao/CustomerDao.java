package com.kh.customer.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.model.vo.PageInfo;
import com.kh.customer.model.vo.Customer;

public class CustomerDao {
	
	private Properties prop = new Properties();
	
	public CustomerDao() {
		
		String fileName = CustomerDao.class.getResource("/sql/customer/customer-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int selectListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	public ArrayList<Customer> selectCustomerList(Connection conn, PageInfo pi){
		// 여러행 조회 => ResultSet
		/*
		 *  1 ~ 10 => 1 / 10
		 *  11 ~ 20 => 11 / 20
		 */
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		ArrayList<Customer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCustomerList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Customer(rset.getInt("que_no"),
									  rset.getString("mem_id"),
									  rset.getString("que_title"),
									  rset.getDate("que_date"),
									  rset.getString("ans_status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public Customer selectCustomerDetail(Connection conn, int queNo) {
		// 한 행 조회 => ResultSet
		Customer c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCustomerDetail");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, queNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				c = new Customer(rset.getInt("que_no"),
						         rset.getString("mem_id"),
						         rset.getString("que_title"),
						         rset.getString("que_content"),
						         rset.getDate("que_date"),
						         rset.getString("ans_status"),
						         rset.getString("ans_content"),
						         rset.getDate("ans_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return c;
	}
	
	public int updateAnswer(Connection conn, Customer c) {
		// insert문 => int result
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAnswer");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getAnsContent());
			pstmt.setInt(2, c.getQueNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
