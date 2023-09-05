package com.example.pojos;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="service_dept")
public class ServiceDeptCodeMap implements Serializable{

	private String serviceCode;
	private String serviceName;
	private String deptCode;

	private Collection <ServiceRequest> serviceRequests;
	private Collection <ApplicationStatusTracker> appStatusTrackers;

	private SAPEnrolledService service;

	/**
	 * @return the appStatusTrackers
	 *//**
	 * 
	 */
	public ServiceDeptCodeMap() {
		// TODO Auto-generated constructor stub
	}
	@OneToMany(mappedBy="serviceDeptCodeMap")
	public Collection<ApplicationStatusTracker> getAppStatusTrackers() {
		return appStatusTrackers;
	}
	/**
	 * @param appStatusTrackers the appStatusTrackers to set
	 */
	public void setAppStatusTrackers(
			Collection<ApplicationStatusTracker> appStatusTrackers) {
		this.appStatusTrackers = appStatusTrackers;
	}
	/**
	 * @return the service
	 */
	@OneToOne(mappedBy="serviceDeptCodeMap")
	public SAPEnrolledService getService() {
		return service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(SAPEnrolledService service) {
		this.service = service;
	}
	/**
	 * @return the serviceRequests
	 */
	@OneToMany(mappedBy="serviceDeptCodeMap")
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
	 * @return the serviceName
	 */
	@Column(name="servicename")
	public String getServiceName() {
		return serviceName;
	}
	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/**
	 * @return the serviceCode
	 */
	@Id
	@Column(name="service_code")
	public String getServiceCode() {
		return serviceCode;
	}
	/**
	 * @param serviceCode the serviceCode to set
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	/**
	 * @return the deptCode
	 */
	@Column(name="dept_code")
	public String getDeptCode() {
		return deptCode;
	}
	/**
	 * @param deptCode the deptCode to set
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

}
