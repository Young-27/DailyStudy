package com.kh.adopt.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.adopt.model.vo.Adopt;
import com.kh.adopt.model.vo.Attachment;
import com.kh.common.model.vo.PageInfo;

public class AdoptDao {

	private Properties prop = new Properties();
	
	public AdoptDao() {
			
			try {
				prop.loadFromXML(new FileInputStream(AdoptDao.class.getResource("/sql/adopt/adopt-mapper.xml").getPath()));
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
	
	
	
	public ArrayList<Adopt> selectList(Connection conn, String keyword, PageInfo pi){
		// select문 => ResultSet(여러행)
		ArrayList<Adopt> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*
			 *  ex) boardLimit : 10이라는 가정하에
			 *  currentPage = 1 => 시작값 : 1     끝값 : 10
			 * 	currentPage = 2 => 시작값 : 11   끝값 : 20
			 *  currentPage = 3 => 시작값 : 21   끝값 : 30
			 * 
			 * 	시작값 = (currentPage - 1) * boardLimit + 1
			 *  끝값 = 시작값 + boardLimit -1 
			 */
			 pstmt.setString(1,"%"+keyword+"%");
	         pstmt.setString(2,"%"+keyword+"%");

			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit() +1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			 pstmt.setInt(3, startRow);
	         pstmt.setInt(4, endRow);

			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Adopt(rset.getInt("adopt_no"),
								   rset.getString("mem_name"),
						           rset.getString("adopt_title"),
						           rset.getString("adopt_content"),
						           rset.getDate("adopt_date"),
						           rset.getInt("count")
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
	
	
	public int increaseCount(Connection conn , int adoptNo) {
			
			int result = 0;
			PreparedStatement pstmt =null;
			String sql = prop.getProperty("increaseCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, adoptNo);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
		
	public Adopt selectAdopt(Connection conn,int adoptNo) {
		// select문 => ResultSet (한행)
		Adopt a = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAdopt");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adoptNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				a = new Adopt(rset.getInt("adopt_no"),
						      rset.getString("adopt_writer"),
						      rset.getString("mem_no"),
						      rset.getString("adopt_title"),
						      rset.getString("adopt_content"),
						      rset.getDate("adopt_date"),
						      rset.getInt("count")
						      );
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return a;
	}	
	
	public Attachment selectAttachment(Connection conn, int adoptNo) {
		// select문 => ResultSet(한행)
		Attachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adoptNo);
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
	
	public ArrayList<Attachment> selectAttachmentList(Connection conn, int adoptNo) {
		// select문 => ResultSet(한행)
		ArrayList<Attachment> list = new ArrayList<>(); // ArrayList 생성
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adoptNo);
			
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
	
	
	
	
	//----------------------------
	 /**
	 * Adopt 게시글 등록을 위한 Service
	 */
	public int insertAdopt(Connection conn, Adopt a) {
		// insert문 => 처리된 행수를 받을거지 (ResultSet이 필요없다는 거지
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAdopt");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(a.getAdoptWriter()));
			pstmt.setInt(2, Integer.parseInt(a.getMemNo()));
			pstmt.setString(3, a.getAdoptTitle());
			pstmt.setString(4, a.getAdoptContent());
			
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
	
	
	public int updateCpost(Connection conn, Adopt a) {
		// update문 => 처리된 행수가 돌아옴 
		int result =0 ;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAdopt");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(a.getMemNo()));
			pstmt.setString(2, a.getAdoptTitle());
			pstmt.setString(3, a.getAdoptContent());
			pstmt.setInt(4,a.getAdoptNo());
			
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
	
	
	
	
	
	
	
	
	
	
	
}
