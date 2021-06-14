package com.kh.banner.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.attachment.model.vo.Attachment;


public class BannerDao {
	
private Properties prop = new Properties();
	
	public BannerDao() {
		try {
			prop.loadFromXML(new FileInputStream(BannerDao.class.getResource("/sql/banner/banner-mapper.xml").getPath()));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	public Attachment selectAttachment(Connection conn, String refType) {
		Attachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		String sql= prop.getProperty("selectAttachment");
		
		try {
			
			pstmt=conn.prepareStatement(sql);			
			pstmt.setString(1,refType);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				at = new Attachment(); 
				at.setFileNo(rset.getInt("file_no"));
				at.setRefType(rset.getString("ref_type"));
				at.setRefNo(rset.getInt("ref_no"));
				at.setChangeName(rset.getString("change_name"));
				at.setFilePath(rset.getString("file_path"));
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return at;
		
	}

	public int updateAttachment(Connection conn, Attachment at ) {
		
		PreparedStatement pstmt=null;
		int result=0;
		String sql= prop.getProperty("updateAttachment");
		
		try {
			
			pstmt=conn.prepareStatement(sql);				
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			pstmt.setString(4, at.getRefType());
					
			
			result = pstmt.executeUpdate();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}

}
