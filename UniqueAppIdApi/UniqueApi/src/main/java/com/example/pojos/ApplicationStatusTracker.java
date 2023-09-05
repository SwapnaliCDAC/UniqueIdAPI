package com.example.pojos;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * TODO : Write a short summary of this type
 *
 * @author anna
 *
 */
@Entity
@Table(name="duplicate_app_status_tracker")
public class ApplicationStatusTracker {
	
	private long id;

	private String appStatusCode;
	private ServiceRequest serviceRequest;
	private Citizen citizen;
	private ServiceDeptCodeMap serviceDeptCodeMap;
	
	/**
	 * @return the serviceDeptCodeMap
	 */
	@ManyToOne
	@JoinColumn(name="service_code", referencedColumnName="service_code")
	public ServiceDeptCodeMap getServiceDeptCodeMap() {
		return serviceDeptCodeMap;
	}

	/**
	 * @param serviceDeptCodeMap the serviceDeptCodeMap to set
	 */
	public void setServiceDeptCodeMap(ServiceDeptCodeMap serviceDeptCodeMap) {
		this.serviceDeptCodeMap = serviceDeptCodeMap;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the citizen
	 */
	@ManyToOne
	@JoinColumn(name="czn_id")
	public Citizen getCitizen() {
		return citizen;
	}
	/**
	 * @param citizen the citizen to set
	 */
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	/**
	 * @return the serviceRequest
	 */
	@OneToOne
	@JoinColumn(name="correlation_id",referencedColumnName="correlation_id")
	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}
	/**
	 * @param serviceRequest the serviceRequest to set
	 */
	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}
	
	/**
	 * @return the appStatusCode
	 */
	@Column(name="app_status_code")
	public String getAppStatusCode() {
		return appStatusCode;
	}
	/**
	 * @param appStatusCode the appStatusCode to set
	 */
	public void setAppStatusCode(String appStatusCode) {
		this.appStatusCode = appStatusCode;
	}
	
}
