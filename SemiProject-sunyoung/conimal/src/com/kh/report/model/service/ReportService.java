package com.kh.report.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.PageInfo;
import com.kh.report.model.dao.ReportDao;
import com.kh.report.model.vo.Report;

public class ReportService {

	public int reportListCount() {
		Connection conn = getConnection();
		int listCount = new ReportDao().reportListCount(conn);
		close(conn);
		return listCount;
	}
	
	
	/**
	 * 관리자가 신고 조회 할 수 있는 창
	 * @return list
	 */
	public ArrayList<Report> selectReportList(PageInfo pi){
		Connection conn = getConnection();
		ArrayList<Report> list = new ReportDao().selectReportList(conn, pi);
		close(conn);
		return list;
	}
	
	
}
