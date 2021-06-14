package com.kh.community.cPost.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.model.vo.PageInfo;
import com.kh.community.cPost.model.vo.Attachment;
import com.kh.community.cPost.model.vo.Cpost;
import com.kh.community.cPost.model.vo.Reply;

public class cPostDao {

	private Properties prop = new Properties();
	
	public cPostDao() {
			
			try {
				prop.loadFromXML(new FileInputStream(cPostDao.class.getResource("/sql/community/cPost-mapper.xml").getPath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
	public int selectListCount(Connection conn, String keyword) {
		// select문 사용해서  ResultSet객체 
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT"); // 여기에 sql에서 별칭사용했으면 별칭명으로 적어줘야함 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	
	
	public ArrayList<Cpost> selectList(Connection conn,String keyword, PageInfo pi){
		// select문 => ResultSet(여러행)
		ArrayList<Cpost> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);


			pstmt.setString(1,"%"+keyword+"%");
	        pstmt.setString(2,"%"+keyword+"%");

			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit() +1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Cpost(rset.getInt("cpost_no"),
								   rset.getString("cuser_name"),
						           rset.getString("cpost_title"),
								   rset.getString("cpost_content"),
						           rset.getInt("cpost_count"),
						           rset.getDate("cpost_date")
						           ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int increaseCount(Connection conn , int cPostNo) {
		
		int result = 0;
		PreparedStatement pstmt =null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cPostNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public Cpost selectCpost(Connection conn,int cPostNo) {
		// select문 => ResultSet (한행)
		Cpost c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCpost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cPostNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Cpost(rset.getInt("cpost_no"),
						      rset.getString("cuser_name"),
						      rset.getString("cpost_title"),
						      rset.getInt("cpost_count"),
						      rset.getString("cpost_content"),
						      rset.getDate("cpost_date")
						      );
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return c;
	}
	
	
	public ArrayList<Attachment> selectAttachmentList(Connection conn, int cPostNo) {
		// select문 => ResultSet(한행)
		ArrayList<Attachment> list = new ArrayList<>(); // ArrayList 생성
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cPostNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Attachment at = new Attachment();
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("change_name"));
				at.setFilePath(rset.getString("file_path"));
				list.add(at);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	//CPOST게시판 등록용 DAO
	public int insertCpost(Connection conn, Cpost c) {
		// insert문 => 처리된 행수를 받을거지 (ResultSet이 필요없다는 거지
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCpost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(c.getcUserId()));
			pstmt.setString(2, c.getcUserName());
			pstmt.setString(3, c.getcPostTitle());
			pstmt.setString(4, c.getcPostContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int insertAttachmentList(Connection conn, ArrayList<Attachment> list) {
		// insert문 여러번 =>(할때마다)처리된 행수가 돌아옴
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachmentList");
		
		try {
			
			for(Attachment at : list) {
				
				// 반복문 돌 때 마다 미완성된 sql문을 담은 pstmt 객체 생성
				pstmt = conn.prepareStatement(sql);
				
				// 완성형태로 만들기
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setInt(4, at.getFileLevel());
				
				// 실행 => 결과받기
				result = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public ArrayList<Reply> selectReplyList(Connection conn, int cPostNo){
		// select문 => ResultSet (여러행)
		ArrayList<Reply> list = new ArrayList<>();
		PreparedStatement pstmt =null;
		ResultSet rset =null;
		String sql = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cPostNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Reply(rset.getInt("re_no"),
								   rset.getString("cuser_name"),
								   rset.getString("written_date"),
								   rset.getString("reply_content")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
	public int insertReply(Connection conn, Reply r) {
		// insert문 => 처리된 행수
		int result=0;
		PreparedStatement pstmt =null;
		String sql = prop.getProperty("insertReply");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, r.getReNo());
			pstmt.setInt(2, r.getMemNo());
			pstmt.setString(3, r.getcUserName());
			pstmt.setString(4, r.getReplyContent());
			
			result= pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateCpost(Connection conn, Cpost c) {
		// update문 => 처리된 행수가 돌아옴 
		int result =0 ;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateCpost");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,c.getcPostTitle());
			pstmt.setString(2, c.getcPostContent());
			pstmt.setInt(3,c.getcPostNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	
	}
	
	public int updateAttachment(Connection conn, Attachment at) {
		// update문 => 처리된 행수
		int result=0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			pstmt.setInt(4, at.getFileNo());
			
			result= pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertNewAttachment(Connection conn, Attachment at) {
		// insert문 => 처리된 행수
		int result=0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNewAttachment");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, at.getRefNo());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	
	public Attachment selectAttachment(Connection conn, int cPostNo) {
		// select문 => ResultSet(한행)
		Attachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cPostNo);
			// 첨부파일이 없을 수도 있지
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				at = new Attachment();
				at.setFileNo(rset.getInt("file_no"));
				at.setOriginName(rset.getString("origin_name"));
				at.setChangeName(rset.getString("change_name"));
				at.setFilePath(rset.getString("file_path"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return at;
		
	}
	
	public int deleteCpost(Connection conn, int cPostNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteCpost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cPostNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteAttachment(Connection conn, int cPostNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cPostNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteReply(Connection conn, int cPostNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cPostNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
