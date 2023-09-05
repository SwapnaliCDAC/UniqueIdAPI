package com.example.controller;

import java.util.Arrays;
import java.util.Date;

public class PrefillForm {

	private String uid;
	private String cznId;
	private String name;
	private String parentagename;
	private String gender;
	private Date dob;
	
	private String phoneNumber;
	private String cellNo;
	private String email;
	
	private String curAdddresLine1;
	private String curAddressLine2;
	private String curDistrictFormId;
	private String curTehsilFormId;
	private String curPincode;
	
	private String prmAdddresLine1;
	private String prmAddressLine2;
	private String prmDistrictFormId;
	private String prmTehsilFormId;
	private String prmPincode;
	private String photoData;
    private String imageType;
    
    public PrefillForm(String uid, String cznId, String name, String parentagename, String gender, Date dob,
			String phoneNumber, String cellNo, String email, String curAdddresLine1, String curAddressLine2,
			String curDistrictFormId, String curTehsilFormId, String curPincode, String prmAdddresLine1,
			String prmAddressLine2, String prmDistrictFormId, String prmTehsilFormId, String prmPincode,
			String photoData, String imageType, String applicationId) {
		super();
		this.uid = uid;
		this.cznId = cznId;
		this.name = name;
		this.parentagename = parentagename;
		this.gender = gender;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.cellNo = cellNo;
		this.email = email;
		this.curAdddresLine1 = curAdddresLine1;
		this.curAddressLine2 = curAddressLine2;
		this.curDistrictFormId = curDistrictFormId;
		this.curTehsilFormId = curTehsilFormId;
		this.curPincode = curPincode;
		this.prmAdddresLine1 = prmAdddresLine1;
		this.prmAddressLine2 = prmAddressLine2;
		this.prmDistrictFormId = prmDistrictFormId;
		this.prmTehsilFormId = prmTehsilFormId;
		this.prmPincode = prmPincode;
		this.photoData = photoData;
		this.imageType = imageType;
		this.applicationId = applicationId;
	}

	private String applicationId;
    
    public PrefillForm() {
		// TODO Auto-generated constructor stub
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCznId() {
		return cznId;
	}

	public void setCznId(String cznId) {
		this.cznId = cznId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentagename() {
		return parentagename;
	}

	public void setParentagename(String parentagename) {
		this.parentagename = parentagename;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCellNo() {
		return cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurAdddresLine1() {
		return curAdddresLine1;
	}

	public void setCurAdddresLine1(String curAdddresLine1) {
		this.curAdddresLine1 = curAdddresLine1;
	}

	public String getCurAddressLine2() {
		return curAddressLine2;
	}

	public void setCurAddressLine2(String curAddressLine2) {
		this.curAddressLine2 = curAddressLine2;
	}

	public String getCurDistrictFormId() {
		return curDistrictFormId;
	}

	public void setCurDistrictFormId(String curDistrictFormId) {
		this.curDistrictFormId = curDistrictFormId;
	}

	public String getCurTehsilFormId() {
		return curTehsilFormId;
	}

	public void setCurTehsilFormId(String curTehsilFormId) {
		this.curTehsilFormId = curTehsilFormId;
	}

	public String getCurPincode() {
		return curPincode;
	}

	public void setCurPincode(String curPincode) {
		this.curPincode = curPincode;
	}

	public String getPrmAdddresLine1() {
		return prmAdddresLine1;
	}

	public void setPrmAdddresLine1(String prmAdddresLine1) {
		this.prmAdddresLine1 = prmAdddresLine1;
	}

	public String getPrmAddressLine2() {
		return prmAddressLine2;
	}

	public void setPrmAddressLine2(String prmAddressLine2) {
		this.prmAddressLine2 = prmAddressLine2;
	}

	public String getPrmDistrictFormId() {
		return prmDistrictFormId;
	}

	public void setPrmDistrictFormId(String prmDistrictFormId) {
		this.prmDistrictFormId = prmDistrictFormId;
	}

	public String getPrmTehsilFormId() {
		return prmTehsilFormId;
	}

	public void setPrmTehsilFormId(String prmTehsilFormId) {
		this.prmTehsilFormId = prmTehsilFormId;
	}

	public String getPrmPincode() {
		return prmPincode;
	}

	public void setPrmPincode(String prmPincode) {
		this.prmPincode = prmPincode;
	}

	/*
	 * public byte[] getPhotoData() { return photoData; }
	 * 
	 * public void setPhotoData(byte[] photoData) { this.photoData = photoData; }
	 */

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getPhotoData() {
		return photoData;
	}

	public void setPhotoData(String photoData) {
		this.photoData = photoData;
	}

	@Override
	public String toString() {
		return "PrefillForm [uid=" + uid + ", cznId=" + cznId + ", name=" + name + ", parentagename=" + parentagename
				+ ", gender=" + gender + ", dob=" + dob + ", phoneNumber=" + phoneNumber + ", cellNo=" + cellNo
				+ ", email=" + email + ", curAdddresLine1=" + curAdddresLine1 + ", curAddressLine2=" + curAddressLine2
				+ ", curDistrictFormId=" + curDistrictFormId + ", curTehsilFormId=" + curTehsilFormId + ", curPincode="
				+ curPincode + ", prmAdddresLine1=" + prmAdddresLine1 + ", prmAddressLine2=" + prmAddressLine2
				+ ", prmDistrictFormId=" + prmDistrictFormId + ", prmTehsilFormId=" + prmTehsilFormId + ", prmPincode="
				+ prmPincode + ", photoData=" + photoData + ", imageType=" + imageType + ", applicationId="
				+ applicationId + "]";
	}

	/*
	 * @Override public String toString() { return "PrefillForm [uid=" + uid +
	 * ", cznId=" + cznId + ", name=" + name + ", parentagename=" + parentagename +
	 * ", gender=" + gender + ", dob=" + dob + ", phoneNumber=" + phoneNumber +
	 * ", cellNo=" + cellNo + ", email=" + email + ", curAdddresLine1=" +
	 * curAdddresLine1 + ", curAddressLine2=" + curAddressLine2 +
	 * ", curDistrictFormId=" + curDistrictFormId + ", curTehsilFormId=" +
	 * curTehsilFormId + ", curPincode=" + curPincode + ", prmAdddresLine1=" +
	 * prmAdddresLine1 + ", prmAddressLine2=" + prmAddressLine2 +
	 * ", prmDistrictFormId=" + prmDistrictFormId + ", prmTehsilFormId=" +
	 * prmTehsilFormId + ", prmPincode=" + prmPincode + ", photoData=" +
	 * Arrays.toString(photoData) + ", imageType=" + imageType + ", applicationId="
	 * + applicationId + "]"; }
	 */
    
    
    
}