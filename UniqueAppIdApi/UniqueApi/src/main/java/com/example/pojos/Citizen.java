package com.example.pojos;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TODO : Write a short summary of this type
 *
 * @author user
 *
 */
@Entity
@Table(name = "citizen")
public class Citizen implements Serializable {

	public Citizen() {

	}

	private String uid;
	private String cznId;
	private String name;
	private String parentage;
	private String parentagename;
	private Date dob;
	private String age;
	private String gender;

	private String curAdddresLine1;
	private String curAddressLine2;
	private String curDistrictFormId;
	private String curTehsilFormId;
	private String curVillageOrCity;
	private String curPincode;

	private String addressSameOrNotVarValue;

	private String prmAdddresLine1;
	private String prmAddressLine2;
	private String prmDistrictFormId;
	private String prmTehsilFormId;
	private String prmVillageOrCity;
	private String prmPincode;

	private String areaCode;
	private String phoneNumber;
	private String cellNo;
	private String email;

	private String imageType;
	private byte[] photoData;
	// private String photoData;

	private Date registeredDate;
	private String testCitizen;
	private String createdBy;
	private Collection<ServiceRequest> serviceRequests;
	private Collection<ApplicationStatusTracker> applicationStatusTrackers;

	/**
	 * @return the serviceRequests
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, fetch = FetchType.EAGER, mappedBy = "citizen")
	public Collection<ServiceRequest> getServiceRequests() {
		return serviceRequests;
	}

	/**
	 * @param serviceRequests the serviceRequests to set
	 */
	public void setServiceRequests(Collection<ServiceRequest> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}

	/**
	 * @return the applicationStatusTrackers
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY, mappedBy = "citizen")
	public Collection<ApplicationStatusTracker> getApplicationStatusTrackers() {
		return applicationStatusTrackers;
	}

	/**
	 * @param applicationStatusTrackers the applicationStatusTrackers to set
	 */
	public void setApplicationStatusTrackers(Collection<ApplicationStatusTracker> applicationStatusTrackers) {
		this.applicationStatusTrackers = applicationStatusTrackers;
	}

	/**
	 * @return the cellNo
	 */
	@Column(name = "cell_no")
	public String getCellNo() {
		return cellNo;
	}

	/**
	 * @return the email
	 */
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	/**
	 * @param cellNo the cellNo to set
	 */
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Id
	@Column(name = "czn_id")
	public String getCznId() {
		return cznId;
	}

	public void setCznId(String cznId) {
		this.cznId = cznId;
	}

	@Column(name = "uid")
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "czn_name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "parentage", nullable = false)
	public String getParentage() {
		return parentage;
	}

	public void setParentage(String parentage) {
		this.parentage = parentage;
	}

	@Column(name = "parentage_name", nullable = false)
	public String getParentagename() {
		return parentagename;
	}

	public void setParentagename(String parentagename) {
		this.parentagename = parentagename;
	}

	@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "dob", nullable = false)
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "age")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the curAdddresLine1
	 */
	@Column(name = "curadddresline1")
	public String getCurAdddresLine1() {
		return curAdddresLine1;
	}

	/**
	 * @param curAdddresLine1 the curAdddresLine1 to set
	 */
	public void setCurAdddresLine1(String curAdddresLine1) {
		this.curAdddresLine1 = curAdddresLine1;
	}

	/**
	 * @return the curAddressLine2
	 */
	@Column(name = "curaddressline2")
	public String getCurAddressLine2() {
		return curAddressLine2;
	}

	/**
	 * @param curAddressLine2 the curAddressLine2 to set
	 */
	public void setCurAddressLine2(String curAddressLine2) {
		this.curAddressLine2 = curAddressLine2;
	}

	/**
	 * @return the curDistrictFormId
	 */
	@Column(name = "curdistrictformid")
	public String getCurDistrictFormId() {
		return curDistrictFormId;
	}

	/**
	 * @param curDistrictFormId the curDistrictFormId to set
	 */
	public void setCurDistrictFormId(String curDistrictFormId) {
		this.curDistrictFormId = curDistrictFormId;
	}

	/**
	 * @return the curTehsilFormId
	 */
	@Column(name = "curtehsilformid")
	public String getCurTehsilFormId() {
		return curTehsilFormId;
	}

	/**
	 * @param curTehsilFormId the curTehsilFormId to set
	 */
	public void setCurTehsilFormId(String curTehsilFormId) {
		this.curTehsilFormId = curTehsilFormId;
	}

	/**
	 * @return the curVillageOrCity
	 */
	@Column(name = "curvillageorcity")
	public String getCurVillageOrCity() {
		return curVillageOrCity;
	}

	/**
	 * @param curVillageOrCity the curVillageOrCity to set
	 */
	public void setCurVillageOrCity(String curVillageOrCity) {
		this.curVillageOrCity = curVillageOrCity;
	}

	/**
	 * @return the curPincode
	 */
	@Column(name = "curpincode")
	public String getCurPincode() {
		return curPincode;
	}

	/**
	 * @param curPincode the curPincode to set
	 */
	public void setCurPincode(String curPincode) {
		this.curPincode = curPincode;
	}

	/**
	 * @return the prmAdddresLine1
	 */
	@Column(name = "prmadddresline1")
	public String getPrmAdddresLine1() {
		return prmAdddresLine1;
	}

	/**
	 * @param prmAdddresLine1 the prmAdddresLine1 to set
	 */
	public void setPrmAdddresLine1(String prmAdddresLine1) {
		this.prmAdddresLine1 = prmAdddresLine1;
	}

	/**
	 * @return the prmAddressLine2
	 */
	@Column(name = "prmaddressline2")
	public String getPrmAddressLine2() {
		return prmAddressLine2;
	}

	/**
	 * @param prmAddressLine2 the prmAddressLine2 to set
	 */
	public void setPrmAddressLine2(String prmAddressLine2) {
		this.prmAddressLine2 = prmAddressLine2;
	}

	/**
	 * @return the prmDistrictFormId
	 */
	@Column(name = "prmdistrictformid")
	public String getPrmDistrictFormId() {
		return prmDistrictFormId;
	}

	/**
	 * @param prmDistrictFormId the prmDistrictFormId to set
	 */
	public void setPrmDistrictFormId(String prmDistrictFormId) {
		this.prmDistrictFormId = prmDistrictFormId;
	}

	/**
	 * @return the prmTehsilFormId
	 */
	@Column(name = "prmtehsilformid")
	public String getPrmTehsilFormId() {
		return prmTehsilFormId;
	}

	/**
	 * @param prmTehsilFormId the prmTehsilFormId to set
	 */
	public void setPrmTehsilFormId(String prmTehsilFormId) {
		this.prmTehsilFormId = prmTehsilFormId;
	}

	/**
	 * @return the prmVillageOrCity
	 */
	@Column(name = "prmvillageorcity")
	public String getPrmVillageOrCity() {
		return prmVillageOrCity;
	}

	/**
	 * @param prmVillageOrCity the prmVillageOrCity to set
	 */
	public void setPrmVillageOrCity(String prmVillageOrCity) {
		this.prmVillageOrCity = prmVillageOrCity;
	}

	/**
	 * @return the prmPincode
	 */
	@Column(name = "prmpincode")
	public String getPrmPincode() {
		return prmPincode;
	}

	/**
	 * @param prmPincode the prmPincode to set
	 */
	public void setPrmPincode(String prmPincode) {
		this.prmPincode = prmPincode;
	}

	@Column(name = "addresssameornotvarvalue")
	public String getAddressSameOrNotVarValue() {
		return addressSameOrNotVarValue;
	}

	/**
	 * @param addressSameOrNotVarValue the addressSameOrNotVarValue to set
	 */
	public void setAddressSameOrNotVarValue(String addressSameOrNotVarValue) {
		this.addressSameOrNotVarValue = addressSameOrNotVarValue;
	}

	/**
	 * @return the areaCode
	 */
	@Column(name = "areacode")
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * @return the phoneNumber
	 */
	@Column(name = "phonenumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "image_type", nullable = false)
	public String getImageType() {
		return imageType;
	}

	@Column(name = "photo_data", nullable = false)
	public byte[] getPhotoData() {
		return photoData;
	}

	public void setPhotoData(byte[] photoData) {
		this.photoData = photoData;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	/*
	 * public String getPhotoData() { return photoData; }
	 * 
	 * public void setPhotoData(String photoData) { this.photoData = photoData; }
	 */
	@Column(name = "registered_date", nullable = false)
	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	@Column(name = "test_citizen", nullable = false)
	public String getTestCitizen() {
		return testCitizen;
	}

	public void setTestCitizen(String testCitizen) {
		this.testCitizen = testCitizen;
	}

	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "Citizen [uid=" + uid + ", cznId=" + cznId + ", name=" + name + ", parentage=" + parentage
				+ ", parentagename=" + parentagename + ", dob=" + dob + ", age=" + age + ", gender=" + gender
				+ ", curAdddresLine1=" + curAdddresLine1 + ", curAddressLine2=" + curAddressLine2
				+ ", curDistrictFormId=" + curDistrictFormId + ", curTehsilFormId=" + curTehsilFormId
				+ ", curVillageOrCity=" + curVillageOrCity + ", curPincode=" + curPincode
				+ ", addressSameOrNotVarValue=" + addressSameOrNotVarValue + ", prmAdddresLine1=" + prmAdddresLine1
				+ ", prmAddressLine2=" + prmAddressLine2 + ", prmDistrictFormId=" + prmDistrictFormId
				+ ", prmTehsilFormId=" + prmTehsilFormId + ", prmVillageOrCity=" + prmVillageOrCity + ", prmPincode="
				+ prmPincode + ", areaCode=" + areaCode + ", phoneNumber=" + phoneNumber + ", cellNo=" + cellNo
				+ ", email=" + email + ", imageType=" + imageType + ", photoData=" + Arrays.toString(photoData)
				+ ", registeredDate=" + registeredDate + ", testCitizen=" + testCitizen + ", createdBy=" + createdBy
				+ ", serviceRequests=" + serviceRequests + ", applicationStatusTrackers=" + applicationStatusTrackers
				+ "]";
	}

}
