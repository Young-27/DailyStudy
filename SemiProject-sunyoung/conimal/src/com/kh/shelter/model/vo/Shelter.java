package com.kh.shelter.model.vo;

public class Shelter {
	
	private int memNo;
	private String shelterName;
	private String shelterPhone;
	private String shelterAddress;
	private String shelterAbout;
	private String admission;		// 승인여부
	private String shelterLocal;
	private String refType;
	
	public Shelter() {}
	
	public Shelter(int memNo, String shelterName, String shelterPhone, String shelterAddress, String shelterAbout,
			String admission, String shelterLocal, String refType) {
		super();
		this.memNo = memNo;
		this.shelterName = shelterName;
		this.shelterPhone = shelterPhone;
		this.shelterAddress = shelterAddress;
		this.shelterAbout = shelterAbout;
		this.admission = admission;
		this.shelterLocal = shelterLocal;
		this.refType = refType;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getShelterName() {
		return shelterName;
	}

	public void setShelterName(String shelterName) {
		this.shelterName = shelterName;
	}

	public String getShelterPhone() {
		return shelterPhone;
	}

	public void setShelterPhone(String shelterPhone) {
		this.shelterPhone = shelterPhone;
	}

	public String getShelterAddress() {
		return shelterAddress;
	}

	public void setShelterAddress(String shelterAddress) {
		this.shelterAddress = shelterAddress;
	}

	public String getShelterAbout() {
		return shelterAbout;
	}

	public void setShelterAbout(String shelterAbout) {
		this.shelterAbout = shelterAbout;
	}

	public String getAdmission() {
		return admission;
	}

	public void setAdmission(String admission) {
		this.admission = admission;
	}

	public String getShelterLocal() {
		return shelterLocal;
	}

	public void setShelterLocal(String shelterLocal) {
		this.shelterLocal = shelterLocal;
	}

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
	}

	@Override
	public String toString() {
		return "Shelter [memNo=" + memNo + ", shelterName=" + shelterName + ", shelterPhone=" + shelterPhone
				+ ", shelterAddress=" + shelterAddress + ", shelterAbout=" + shelterAbout + ", admission=" + admission
				+ ", shelterLocal=" + shelterLocal + ", refType=" + refType + "]";
	}
	
	
	
}
