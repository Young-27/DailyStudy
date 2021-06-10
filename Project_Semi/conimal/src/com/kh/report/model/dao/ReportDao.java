package com.kh.report.model.dao;

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
import com.kh.report.model.vo.Report;

public class ReportDao {

	private Properties prop = new Properties();
	
	public ReportDao() {
		String fileName = ReportDao.class.getResource("/sql/report/report-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int reportListCount(Connection conn) {
		// 한 행 조회 => listCount에 담기
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reportListCount");
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

	
	/**
	 * 관리자가 신고 조회 할 수 있는 창
	 * @return list
	 */
	public ArrayList<Report> selectReportList(Connection conn, PageInfo pi){
		// 여러행 조회 =>  ReultSet
		ArrayList<Report> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		String sql = prop.getProperty("selectReportList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Report(rset.getInt("report_unique"),
									rset.getString("mem_id"),
									rset.getString("ref_type"),
									rset.getInt("ref_no"),
									rset.getString("cpost_title"),
									rset.getString("adopt_title"),
									rset.getString("an_title"),
									rset.getString("do_title"),
									rset.getString("vol_title"),
									rset.getString("report_reason"),
									rset.getDate("report_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}

public int insertReport(Connection conn, Report r) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getMemNo());
			pstmt.setString(2, r.getRefType());
			pstmt.setInt(3, r.getRefNo());
			pstmt.setInt(4, r.getReportNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
