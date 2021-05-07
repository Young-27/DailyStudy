package com.kh.notice.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

public class NoticeService {

	public ArrayList<Notice> selectNoticeList(){
		
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
		
		close(conn);
		
		return list;
		
		
	}
	
	public Notice insertNotice(Notice n) {
		
		Connection conn = getConnection();
		int result = new NoticeDao().insertNotice(conn, n);
		
		Notice list = null;
		
		if(result > 0) {
			commit(conn);
			list = new Notice(
							 n.getNoticeNo(),
							 n.getNoticeTitle(),
							 n.getNoticeContent(),
							 n.getNoticeWriter()); 
		} else {
			rollback(conn);
		}
		
		return list;
		
		
	}
	
}
