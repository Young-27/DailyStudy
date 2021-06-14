package com.kh.volunteer.model.dao;

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
import com.kh.volunteer.model.vo.Volunteer;

public class VolunteerDao {
	
	private Properties prop = new Properties();
	
	public VolunteerDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(VolunteerDao.class.getResource("/sql/volunteer/volunteer-mapper.xml").getPath()));
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
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
		
	}
	
	public ArrayList<Volunteer> selectList(Connection conn, PageInfo pi) {
		
		ArrayList<Volunteer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Volunteer(rset.getInt("VOL_NO"),
									   rset.getString("VOL_TITLE"),
									   rset.getDate("VOL_WRITEDATE"),
									   rset.getString("MEM_ID"),
									   rset.getInt("VOL_COUNT")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}

	
	public int increaseCount(Connection conn, int volNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, volNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public Volunteer selectVolunteer(Connection conn, int volNo) {
		
		Volunteer v = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectVolunteer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, volNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				v = new Volunteer(rset.getString("VOL_TITLE"),
						rset.getString("SH_NAME"),
						rset.getString("SPERIOD"),
						rset.getString("SH_PHONE"),
						rset.getString("SH_ADDRESS"),
						rset.getString("VOL_CONTENT"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return v;
		
	}
	
	public int selectListCountByKeyword(Connection conn, String keyword) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountByKeyword");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
		
	}
	
	public ArrayList<Volunteer> selectByKeyword(Connection conn, PageInfo pi, String keyword) {
		
		ArrayList<Volunteer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectByKeyword");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Volunteer(rset.getInt("VOL_NO"),
									   rset.getString("VOL_TITLE"),
									   rset.getDate("VOL_WRITEDATE"),
									   rset.getString("MEM_ID"),
									   rset.getInt("VOL_COUNT")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
public ArrayList<Volunteer> selectVolunteerList(Connection conn){
		
		ArrayList<Volunteer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectVolunteerList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Volunteer(rset.getInt("vol_no"),
						               rset.getString("vol_title"),
						               rset.getDate("vol_writedate"),
						               rset.getString("mem_no"),
						               rset.getInt("vol_count")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}

}
