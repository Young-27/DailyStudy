package com.kh.introduce.model.service;

import static com.kh.common.JDBCTemplate.*;


import java.sql.Connection;

import com.kh.attachment.model.vo.Attachment;
import com.kh.introduce.model.dao.IntroduceDao;
import com.kh.introduce.model.vo.Introduce;

public class IntroduceService {
	
	public Introduce selectIntro(int introNo) {
		Connection conn = getConnection();
		Introduce intro= new IntroduceDao().selectIntro(conn,introNo);
		close(conn);
		return intro;
	} 
	
	public int updateIntro(Introduce intro, Attachment at) {
		Connection conn = getConnection();
		
		int result1= new IntroduceDao().updateIntro(conn,intro);
		int result2=1;		
		if(at!=null) {
			new IntroduceDao().deleteAttachment(conn,at);
			result2=new IntroduceDao().insertAttachment(conn,at);
		} else {
			result2=new IntroduceDao().insertAttachment(conn,at);
		}
		if(result1>0&& result2>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result1*result2;		
	}
	
	public Attachment selectAttachment(int introNo, String refType) {
		Connection conn = getConnection();
		Attachment at = new IntroduceDao().selectAttachment(conn,introNo,refType);
		close(conn);
		return at;	
	}

}
