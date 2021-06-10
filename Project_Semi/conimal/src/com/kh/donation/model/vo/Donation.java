package com.kh.donation.model.vo;

import java.sql.Date;
import com.kh.attachment.model.vo.Attachment;

public class Donation extends Attachment{
	
	private int doNo;
	private String doTitle;
	private String doContent;
	private Date doWriteDate;
	private String doAdmission;
	private String memNo;
	private String refType;
	private int doCount;
	private String shName;
	private String shPhone;
	private String shAddress; 
	
	
	public Donation() {
		
	}


	public Donation(int doNo, String doTitle, String doContent, Date doWriteDate, String doAdmission, String memNo,
			String refType, int doCount, String shName, String shPhone) {
		super();
		this.doNo = doNo;
		this.doTitle = doTitle;
		this.doContent = doContent;
		this.doWriteDate = doWriteDate;
		this.doAdmission = doAdmission;
		this.memNo = memNo;
		this.refType = refType;
		this.doCount = doCount;
		this.shName = shName;
		this.shPhone = shPhone;
	}
public Donation(int doNo, String doTitle, String memNo, int doCount, Date doWriteDate) {
		super();
		this.doNo = doNo;
		this.doTitle = doTitle;
		this.memNo = memNo;
		this.doCount = doCount;
		this.doWriteDate = doWriteDate;
		
	}
public Donation(String doTitle, String shName, String shPhone, String shAddress, String doContent) {
		super();
		this.doTitle = doTitle;
		this.shName = shName;
		this.shPhone = shPhone;
		this.shAddress = shAddress;
		this.doContent = doContent;
	}

	
	public Donation(int doNo, String doTitle, String doContent, Date doWriteDate, String doAdmission, String memNo,
			String refType, int doCount) {
		super();
		this.doNo = doNo;
		this.doTitle = doTitle;
		this.doContent = doContent;
		this.doWriteDate = doWriteDate;
		this.doAdmission = doAdmission;
		this.memNo = memNo;
		this.refType = refType;
		this.doCount = doCount;
	}
	
	public Donation(int doNo, String doTitle, String doContent, Date doWriteDate, String doAdmission, String memNo,
			String refType, int doCount, String shName, String shPhone,int fileNo, 
			int refNo, String originName, String changeName, String filePath,
			Date uploadDate) {
		super();
		this.doNo = doNo;
		this.doTitle = doTitle;
		this.doContent = doContent;
		this.doWriteDate = doWriteDate;
		this.doAdmission = doAdmission;
		this.memNo = memNo;
		this.refType = refType;
		this.doCount = doCount;
		this.shName = shName;
		this.shPhone = shPhone;
		super.setFileNo(fileNo);
		super.setRefNo(refNo);
		super.setOriginName(originName);
		super.setChangeName(changeName);
		super.setFilePath(filePath);
		super.setUploadDate(uploadDate);
	}



	public int getDoNo() {
		return doNo;
	}

	public void setDoNo(int doNo) {
		this.doNo = doNo;
	}

	public String getDoTitle() {
		return doTitle;
	}

	public void setDoTitle(String doTitle) {
		this.doTitle = doTitle;
	}

	public String getDoContent() {
		return doContent;
	}

	public void setDoContent(String doContent) {
		this.doContent = doContent;
	}

	public Date getDoWriteDate() {
		return doWriteDate;
	}

	public void setDoWriteDate(Date doWriteDate) {
		this.doWriteDate = doWriteDate;
	}

	public String getDoAdmission() {
		return doAdmission;
	}

	public void setDoAdmission(String doAdmission) {
		this.doAdmission = doAdmission;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
	}

	public int getDoCount() {
		return doCount;
	}

	public void setDoCount(int doCount) {
		this.doCount = doCount;
	}

	public String getShName() {
		return shName;
	}

	public void setShName(String shName) {
		this.shName = shName;
	}
	

	public String getShPhone() {
		return shPhone;
	}


	public void setShPhone(String shPhone) {
		this.shPhone = shPhone;
	}
public String getShAddress() {
		return shAddress;
	}

	public void setShAddress(String shAddress) {
		this.shAddress = shAddress;
	}


	@Override
	public String toString() {
		return "Donation [doNo=" + doNo + ", doTitle=" + doTitle + ", doContent=" + doContent + ", doWriteDate="
				+ doWriteDate + ", doAdmission=" + doAdmission + ", memNo=" + memNo + ", refType=" + refType
				+ ", doCount=" + doCount + "]";
	}
	
	
	

}
