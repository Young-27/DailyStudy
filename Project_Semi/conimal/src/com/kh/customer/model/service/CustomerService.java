package com.kh.customer.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.PageInfo;
import com.kh.customer.model.dao.CustomerDao;
import com.kh.customer.model.vo.Customer;

public class CustomerService {
	
	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new CustomerDao().selectListCount(conn);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Customer> selectCustomerList(PageInfo pi){
		Connection conn = getConnection();
		ArrayList<Customer> list = new CustomerDao().selectCustomerList(conn, pi);
		close(conn);
		return list;
	}
	
	public Customer selectCustomerDetail(int queNo) {
		Connection conn = getConnection();
		Customer c = new CustomerDao().selectCustomerDetail(conn, queNo);
		close(conn);
		return c;
	}
	
	public int updateAnswer(Customer c) {
		Connection conn = getConnection();
		int result = new CustomerDao().updateAnswer(conn, c);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	
	
	
	
	
	
}
