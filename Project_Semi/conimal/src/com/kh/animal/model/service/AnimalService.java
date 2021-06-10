package com.kh.animal.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.animal.model.dao.AnimalDao;
import com.kh.animal.model.vo.Animal;
import com.kh.animal.model.vo.Bookmark;
import com.kh.attachment.model.vo.Attachment;
import com.kh.common.model.vo.PageInfo;

public class AnimalService {
	
	public int selectDogCount() {
		
		Connection conn = getConnection();
		
		int listCount = new AnimalDao().selectDogCount(conn);
		
		close(conn);
		
		return listCount;
		
	}
public ArrayList<Animal> selectAnimalList(){
		
		Connection conn = getConnection();
		ArrayList<Animal> list = new AnimalDao().selectAnimalList(conn);

		close(conn);
		return list;
	
	}
	
	public int selectCatCount() {
		
		Connection conn = getConnection();
		
		int listCount = new AnimalDao().selectCatCount(conn);
		
		close(conn);
		
		return listCount;
		
	}
	
	public ArrayList<Animal> selectDogList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Animal> list = new AnimalDao().selectDogList(conn, pi);
		
		close(conn);
		
		return list;
		
	}
	
	public ArrayList<Animal> selectCatList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Animal> list = new AnimalDao().selectCatList(conn, pi);
		
		close(conn);
		
		return list;
		
	}
	
	public int increaseCount(int animalNo) {
		
		Connection conn = getConnection();
		
		int result = new AnimalDao().increaseCount(conn, animalNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public Animal selectAnimal(int animalNo) {
		
		Connection conn = getConnection();
		
		Animal a = new AnimalDao().selectAnimal(conn, animalNo);
		
		close(conn);
		
		return a;
		
	}
	
	public int insertBookMark(Bookmark bk) {
		
		Connection conn = getConnection();
		
		int result = new AnimalDao().insertBookMark(conn, bk);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int selectDogCountByKeyword(String keyword) {
		
		Connection conn = getConnection();
		
		int listCount = new AnimalDao().selectDogCountByKeyword(conn, keyword);
		
		close(conn);
		
		return listCount;
		
	}
	
	public ArrayList<Animal> selectDogListByKeyword(PageInfo pi, String keyword) {
		
		Connection conn = getConnection();
		
		ArrayList<Animal> list = new AnimalDao().selectDogListByKeyword(conn, pi, keyword);
		
		close(conn);
		
		return list;
		
	}
	
	public int selectCatCountByKeyword(String keyword) {
		
		Connection conn = getConnection();
		
		int listCount = new AnimalDao().selectCatCountByKeyword(conn, keyword);
		
		close(conn);
		
		return listCount;
		
	}
	
	public ArrayList<Animal> selectCatListByKeyword(PageInfo pi, String keyword) {
		
		Connection conn = getConnection();
		
		ArrayList<Animal> list = new AnimalDao().selectCatListByKeyword(conn, pi, keyword);
		
		close(conn);
		
		return list;
		
	}
	
	public int insertAnimal(Animal an, Attachment at) {
		
		Connection conn = getConnection();
		
		int result1 = new AnimalDao().insertAnimal(conn, an);
		
		int result2 = 1; // 0으로 해서는 안됨
		if(at != null) {
			result2 = new AnimalDao().insertAttachment(conn, at);
		}
		
		// 트랜잭션 처리
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 * result2;
		
	}

}
