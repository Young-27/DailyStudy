package com.kh.volunteer.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.PageInfo;
import com.kh.volunteer.model.dao.VolunteerDao;
import com.kh.volunteer.model.vo.Volunteer;

public class VolunteerService {
	
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new VolunteerDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
		
	}
	
	public ArrayList<Volunteer> selectList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Volunteer> list = new VolunteerDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
		
	}
	
	public int increaseCount(int volNo) {
		
		Connection conn = getConnection();
		
		int result = new VolunteerDao().increaseCount(conn, volNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public Volunteer selectVolunteer(int volNo) {
		
		Connection conn = getConnection();
		
		Volunteer v = new VolunteerDao().selectVolunteer(conn, volNo);
		
		close(conn);
		
		return v;
		
	}
	
	public int selectListCountByKeyword(String keyword) {
		
		Connection conn = getConnection();
		
		int listCount = new VolunteerDao().selectListCountByKeyword(conn, keyword);
		
		close(conn);
		
		return listCount;
		
	}
	
	public ArrayList<Volunteer> selectByKeyword(PageInfo pi, String keyword) {
		
		Connection conn = getConnection();
		
		ArrayList<Volunteer> list = new VolunteerDao().selectByKeyword(conn, pi, keyword);
		
		close(conn);
		
		return list;
		
	}
	public ArrayList<Volunteer> selectVolunteerList(){
		
		Connection conn = getConnection();
		ArrayList<Volunteer> list = new VolunteerDao().selectVolunteerList(conn);
		
		close(conn);
		return list;
		
	}
}
