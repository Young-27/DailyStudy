package com.kh.introduce.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.attachment.model.vo.Attachment;
import com.kh.introduce.model.vo.Introduce;

public class IntroduceDao {
	private Properties prop = new Properties();
	public IntroduceDao() {
		try {
			prop.loadFromXML(new FileInputStream(IntroduceDao.class.getResource("/sql/introduce/introduce-mapper.xml").getPath() ));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Introduce selectIntro(Connection conn, int introNo) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			Introduce intro= null;
			String sql= prop.getProperty("selectIntroduce");
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, introNo);
				rset=pstmt.executeQuery();
				
				if(rset.next()) {
					intro = new Introduce(rset.getInt("intro_no"),
										  rset.getString("intro_content"),
										  rset.getString("intro_title"),
										  rset.getString("ref_type"));
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return intro;
	
	}
	
	public int updateIntro(Connection conn, Introduce intro) {
		
		PreparedStatement pstmt =null;
		int result=0;
		String sql= prop.getProperty("updateIntroduce");
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1,intro.getIntroTitle());
			pstmt.setString(2, intro.getIntroContent());
			pstmt.setInt(3, intro.getIntroNo());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertAttachment(Connection conn, Attachment at) {
		
		PreparedStatement pstmt=null;
		int result=0;
		String sql= prop.getProperty("insertAttachment");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, at.getRefNo());
			pstmt.setString(2, at.getRefType());
			pstmt.setString(3, at.getOriginName());
			pstmt.setString(4, at.getChangeName());
			pstmt.setString(5, at.getFilePath());
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int deleteAttachment(Connection conn, Attachment at) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql= prop.getProperty("deleteAttachment");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, at.getRefNo());
			pstmt.setString(2, at.getRefType());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public Attachment selectAttachment(Connection conn, int introNo, String refType) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Attachment at= null;
		String sql= prop.getProperty("selectAttachment");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,introNo);
			pstmt.setString(2,refType);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				at = new Attachment (rset.getInt("file_no"),
									  rset.getString("ref_type"),
									  rset.getInt("ref_no"),
									  rset.getString("origin_name"),
									  rset.getString("change_name"),
									  rset.getString("file_path"),
									  rset.getDate("upload_date"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return at;
		
	}

}
