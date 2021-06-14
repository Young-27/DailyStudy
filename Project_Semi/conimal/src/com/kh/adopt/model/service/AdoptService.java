package com.kh.adopt.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.adopt.model.dao.AdoptDao;
import com.kh.adopt.model.vo.Adopt;
import com.kh.adopt.model.vo.Attachment;
import com.kh.common.model.vo.PageInfo;

public class AdoptService {

	
	public int selectListCount(String keyword) {
		Connection conn = getConnection();
		int listCount = new AdoptDao().selectListCount(conn, keyword);
		
		close(conn);
		return listCount;
	}
	
	public ArrayList<Adopt> selectList(String keyword,PageInfo pi){
		Connection conn = getConnection();
		ArrayList<Adopt> list = new AdoptDao().selectList(conn,keyword,pi);
		close(conn);
		return list;
	}
	
	public int increaseCount(int adoptNo) {
		Connection conn = getConnection();
		int result = new AdoptDao().increaseCount(conn, adoptNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Adopt selectAdopt(int adoptNo) {
		Connection conn = getConnection();
		Adopt a = new AdoptDao().selectAdopt(conn,adoptNo);
		close(conn);
		return a;
	}
	
	public Attachment selectAttachment(int adoptNo) {
		Connection conn = getConnection();
		Attachment at = new AdoptDao().selectAttachment(conn,adoptNo);
		close(conn);
		return at;
		
	}
	public ArrayList<Attachment> selectAttachmentList(int adoptNo) {
		Connection conn = getConnection();
		ArrayList<Attachment> list = new AdoptDao().selectAttachmentList(conn, adoptNo);
		
		close(conn);
		return list;
		
	}
	/**
	 * Adopt 게시글 등록을 위한 Service
	 */
	public int insertAdopt(Adopt a, ArrayList<Attachment> list) {
		Connection conn = getConnection();
		// CPOST테이블 먼저 처리해줘야함
		int result1 = new AdoptDao().insertAdopt(conn,a);
		//list에 담긴 attachment만큼 
		int result2 = new AdoptDao().insertAttachmentList(conn,list);
		
		// 성공적일 경우에만 commit 아니면 rollback
		if(result1 > 0 && result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result1*result2;
	}
	
	
	public int updateAdopt(Adopt a, Attachment at) {
		Connection conn = getConnection();
		
		int result1 = new AdoptDao().updateCpost(conn,a);
		
		int result2 = 1; //0으로 초기화 하면 안됨
		if(at != null) { // 새로이 첨부된 파일이 있을 경우
			
			if(at.getFileNo() != 0) {	// 기존의 첨부파일이 있었을 경우 => Attachment Update
				result2 = new AdoptDao().updateAttachment(conn,at);
				
			}else { // 기존의 첨부파일이 없었을 경우 => Attachment Insert
				result2 = new AdoptDao().insertNewAttachment(conn,at);
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
	
	
	
	
	
	
}
