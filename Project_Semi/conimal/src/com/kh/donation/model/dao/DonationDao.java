package com.kh.donation.model.dao;

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
import com.kh.donation.model.vo.Donation;

public class DonationDao {
	
private Properties prop = new Properties();
	
	public DonationDao() {
		try {
			prop.loadFromXML(new FileInputStream(DonationDao.class.getResource("/sql/donation/donation-mapper.xml").getPath()));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectListCount1(Connection conn, String keyword) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount1");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+keyword+"%");
			pstmt.setString(2,"%"+keyword+"%");
			pstmt.setString(3,"%"+keyword+"%");
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

	
	public ArrayList<Donation> selectPostList(Connection conn){
		
		ArrayList<Donation> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPostList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Donation(rset.getInt("do_no"),
                        rset.getString("do_title"),
                        rset.getString("do_content"),
                        rset.getDate("do_writedate"),
                        rset.getString("do_admission"),
                        rset.getString("mem_no"),
                        rset.getString("ref_type"),
                        rset.getInt("do_count")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public ArrayList<Donation> selectDonationList(Connection conn,String keyword,PageInfo pi){
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Donation> list = new ArrayList<>();
		String sql = prop.getProperty("selectDonationList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"%"+keyword+"%");
			pstmt.setString(2,"%"+keyword+"%");
			pstmt.setString(3,"%"+keyword+"%");
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Donation(rset.getInt("do_no"),
									rset.getString("do_title"),
									rset.getString("do_content"),
									rset.getDate("do_writedate"),
									rset.getString("do_admission"),
									rset.getString("mem_no"),
									rset.getString("ref_type"),
									rset.getInt("do_count"),
									rset.getString("sh_name"),
									rset.getString("sh_phone"),
									rset.getInt("file_no"),
									rset.getInt("ref_no"),
									rset.getString("origin_name"),
									rset.getString("change_name"),
									rset.getString("file_path"),
									rset.getDate("upload_date")									
									));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public Donation selectDonation1(Connection conn, int donationNo) {
		
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		Donation dona =null;
		String sql = prop.getProperty("selectDonation1");
		
		try {
			
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, donationNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				dona=new Donation(rset.getInt("do_no"),
						rset.getString("do_title"),
						rset.getString("do_content"),
						rset.getDate("do_writedate"),
						rset.getString("do_admission"),
						rset.getString("mem_no"),
						rset.getString("ref_type"),
						rset.getInt("do_count"),
						rset.getString("sh_name"),
						rset.getString("sh_phone"),
						rset.getInt("file_no"),
						rset.getInt("ref_no"),
						rset.getString("origin_name"),
						rset.getString("change_name"),
						rset.getString("file_path"),
						rset.getDate("upload_date")		);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return dona;
		
		
	}
	
	
	
public int approveDonation(Connection conn, int doNo, String admission) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("approveDonation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admission);
			pstmt.setInt(2, doNo);
			
			
			result = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}	

	
	public int deleteDonation(Connection conn, int doNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteDonation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, doNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

public ArrayList<Donation> selectList(Connection conn, PageInfo pi) {
		
		ArrayList<Donation> list = new ArrayList<>();
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
				list.add(new Donation(rset.getInt("DO_NO"),
									  rset.getString("DO_TITLE"),
									  rset.getString("MEM_ID"),
									  rset.getInt("DO_COUNT"),
									  rset.getDate("DO_WRITEDATE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int increaseCount(Connection conn, int doNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, doNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public Donation selectDontion(Connection conn, int doNo) {
		
		Donation d = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDontion");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, doNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				d = new Donation(rset.getString("DO_TITLE"),
								 rset.getString("SH_NAME"),
								 rset.getString("SH_PHONE"),
								 rset.getString("SH_ADDRESS"),
								 rset.getString("DO_CONTENT"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return d;
		
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
	
	public ArrayList<Donation> selectByKeyword(Connection conn, PageInfo pi, String keyword) {
		
		ArrayList<Donation> list = new ArrayList<>();
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
				list.add(new Donation(rset.getInt("DO_NO"),
									   rset.getString("DO_TITLE"),
									   rset.getString("MEM_ID"),
									   rset.getInt("DO_COUNT"),
									   rset.getDate("DO_WRITEDATE")));
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
