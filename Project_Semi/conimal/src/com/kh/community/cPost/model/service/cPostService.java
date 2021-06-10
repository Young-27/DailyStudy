package com.kh.community.cPost.model.service;

import static com.kh.common.JDBCTemplate.*;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.PageInfo;
import com.kh.community.cPost.model.dao.cPostDao;
import com.kh.community.cPost.model.vo.Attachment;
import com.kh.community.cPost.model.vo.Cpost;
import com.kh.community.cPost.model.vo.Reply;

public class cPostService {

	public int selectListCount(String keyword) {
		Connection conn = getConnection();
		int listCount = new cPostDao().selectListCount(conn, keyword);
		
		close(conn);
		return listCount;
	}
	
	
	public ArrayList<Cpost> selectList(String keyword, PageInfo pi){
		Connection conn = getConnection();
		ArrayList<Cpost> list = new cPostDao().selectList(conn,keyword,pi);
		close(conn);
		return list;
	}
	
	
	public int increaseCount(int cPostNo) {
		Connection conn = getConnection();
		int result = new cPostDao().increaseCount(conn, cPostNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Cpost selectCpost(int cPostNo) {
		Connection conn = getConnection();
		Cpost c = new cPostDao().selectCpost(conn,cPostNo);
		close(conn);
		return c;
	}
	
	public ArrayList<Attachment> selectAttachmentList(int cPostNo) {
		Connection conn = getConnection();
		ArrayList<Attachment> list = new cPostDao().selectAttachmentList(conn, cPostNo);
		
		close(conn);
		return list;
		
	}

	public int insertCpost(Cpost c, ArrayList<Attachment> list) {
		Connection conn = getConnection();
		// CPOST테이블 먼저 처리해줘야함
		int result1 = new cPostDao().insertCpost(conn,c);
		//list에 담긴 attachment만큼 
		int result2 = new cPostDao().insertAttachmentList(conn,list);
		
		// 성공적일 경우에만 commit 아니면 rollback
		if(result1 > 0 && result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result1*result2;
	}
	
	public ArrayList<Reply> selectReplyList(int cPostNo){
		Connection conn = getConnection();
		ArrayList<Reply> list = new cPostDao().selectReplyList(conn,cPostNo);
		close(conn);
		return list;
		
	}
	
	
	public int insertReply(Reply r) {
		Connection conn = getConnection();
		int result = new cPostDao().insertReply(conn,r);
		if(result>0) {
			commit(conn);
			
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	
	public int updateCpost(Cpost c, Attachment at) {
		Connection conn = getConnection();
		
		int result1 = new cPostDao().updateCpost(conn,c);
		
		int result2 = 1; //0으로 초기화 하면 안됨
		if(at != null) { // 새로이 첨부된 파일이 있을 경우
			
			if(at.getFileNo() != 0) {	// 기존의 첨부파일이 있었을 경우 => Attachment Update
				result2 = new cPostDao().updateAttachment(conn,at);
				
			}else { // 기존의 첨부파일이 없었을 경우 => Attachment Insert
				result2 = new cPostDao().insertNewAttachment(conn,at);
			}
			
		}
		
		
		if(result1>0 && result2 >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 * result2;
		
	}
	
	public Attachment selectAttachment(int cPostNo) {
		Connection conn = getConnection();
		Attachment at = new cPostDao().selectAttachment(conn,cPostNo);
		
		
		close(conn);
		return at;
		
	}
	
	
	
	public int deleteCpost(int cPostNo) {
		Connection conn = getConnection();
		
		int result1 = new cPostDao().deleteCpost(conn,cPostNo);
		
		if(result1>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result1;
		
	}
	
	public int deleteAttachment(int cPostNo) {
		Connection conn = getConnection();
		
		int result2 = new cPostDao().deleteAttachment(conn,cPostNo);
		if(result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result2;
		
	}
	
	public int deleteReply(int cPostNo) {
		Connection conn = getConnection();
		
		int result3 = new cPostDao().deleteReply(conn,cPostNo);
		if(result3>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result3;
		
	}
	
}
