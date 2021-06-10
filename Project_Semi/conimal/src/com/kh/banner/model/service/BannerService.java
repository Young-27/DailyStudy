package com.kh.banner.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;


import com.kh.attachment.model.vo.Attachment;
import com.kh.banner.model.dao.BannerDao;


public class BannerService {
	
	public int updateBanner(Attachment at) {
		Connection conn = getConnection();
		
		int result2 = new BannerDao().updateAttachment(conn, at);			
		
		
		if(result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result2;
	}
	
	public Attachment selectBanner(String refType){
		
		Connection conn = getConnection();
		Attachment at = new BannerDao().selectAttachment(conn,refType);
		close(conn);
		return at;		
	}
}
