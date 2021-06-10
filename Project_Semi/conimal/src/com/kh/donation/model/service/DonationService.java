package com.kh.donation.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.PageInfo;
import com.kh.donation.model.dao.DonationDao;
import com.kh.donation.model.vo.Donation;


public class DonationService {
	
	public int selectListCount1(String keyword) {
		
		Connection conn = getConnection();
		int listCount = new DonationDao().selectListCount1(conn,keyword);
		
		close(conn);
		return listCount;
		
	}
public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new DonationDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
		
	}
	
	public ArrayList<Donation> selectDonationList(String keyword, PageInfo pi){
		
		Connection conn = getConnection();
		ArrayList<Donation> list = new DonationDao().selectDonationList(conn,keyword,pi);
		close(conn);
		return list;
	}
public ArrayList<Donation> selectList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Donation> list = new DonationDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
		
	}
public int increaseCount(int doNo) {
		
		Connection conn = getConnection();
		
		int result = new DonationDao().increaseCount(conn, doNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
public Donation selectDontion(int doNo) {
		
		Connection conn = getConnection();
		
		Donation d = new DonationDao().selectDontion(conn, doNo);
		
		close(conn);
		
		return d;
		
	}
	
	public Donation selectDonation1(int doNo) {
		Connection conn = getConnection();
		Donation n = new DonationDao().selectDonation1(conn, doNo);		
		close(conn);
		return n;
	}
	
	public int approveDonation(int doNo, String admission) {
		Connection conn = getConnection();
		int result = new DonationDao().approveDonation(conn, doNo, admission);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
		
	
	public int deleteDonation(int doNo) {
		Connection conn = getConnection();
		int result = new DonationDao().deleteDonation(conn, doNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
public int selectListCountByKeyword(String keyword) {
		
		Connection conn = getConnection();
		
		int listCount = new DonationDao().selectListCountByKeyword(conn, keyword);
		
		close(conn);
		
		return listCount;
		
	}
	
	public ArrayList<Donation> selectByKeyword(PageInfo pi, String keyword) {
		
		Connection conn = getConnection();
		
		ArrayList<Donation> list = new DonationDao().selectByKeyword(conn, pi, keyword);
		
		close(conn);
		
		return list;
		
	}

	
	public ArrayList<Donation> selectPostList(){
		
		Connection conn = getConnection();
		ArrayList<Donation> list = new DonationDao().selectPostList(conn);
		
		close(conn);
		return list;
	}

}
