package com.example.pojos;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/*
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;*/

/**
 * TODO : Write a short summary of this type
 *
 * @author jitendra
 * @author anna
 *
 */
@Entity
@Table(name="sap_requests")
public class ServiceRequest implements Serializable{

	

	private static final long serialVersionUID = 1L;
	private volatile int hashCode = 0;

	private String applicationId;
	private String requestBody;
	private String transactionId;
	private String correlationId;
	private Date requestSentTime;
	private String status;
	private String responseEndPoint;
	private String pollInterval;
	
	
	
	private String loginId;
	private String loginType;
	
	//added for A4 print
	private String printXml;
	
	private Citizen citizen;
    
	private SAPEnrolledService sapEnrolledService;
	private Collection<ServiceResponse> serviceResponses=new ArrayList<ServiceResponse>();
	private ApplicationStatus applicationStatus;
	private ServiceDeptCodeMap serviceDeptCodeMap;
    public ServiceRequest(){}
    
    /**
	 * @return the serviceDeptCodeMap
	 */
    @ManyToOne
    @JoinColumn(name="service_code",referencedColumnName="service_code")
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
	 * @return the citizen
	 */
    @ManyToOne
    @JoinColumn(name="czn_id",referencedColumnName="czn_id")
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
	 * @return the printXml
	 */
	@Column(name="print_xml" , columnDefinition="text")
	public String getPrintXml() {
		return printXml;
	}

	/**
	 * @param printXml the printXml to set
	 */
	public void setPrintXml(String printXml) {
		this.printXml = printXml;
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the applicationId
	 */
	@Id
	@Column(name="application_id")
	public String getApplicationId() {
		return applicationId;
	}
	
	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
	/**
	 * @return the pollInterval
	 */
	@Column(name="poll_interval")
	public String getPollInterval() {
		return pollInterval;
	}

	/**
	 * @param pollInterval the pollInterval to set
	 */
	public void setPollInterval(String pollInterval) {
		this.pollInterval = pollInterval;
	}
	/**
	 * @return the status
	 */
	@Column(name="application_status")
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the responseEndPoint
	 */
	@Column(name="response_end_point")
	public String getResponseEndPoint() {
		return responseEndPoint;
	}
	/**
	 * @param responseEndPoint the responseEndPoint to set
	 */
	public void setResponseEndPoint(String responseEndPoint) {
		this.responseEndPoint = responseEndPoint;
	}
	
	/**
	 * @return the correlationId
	 */

	@Column(name="correlation_id",nullable=false)
	public String getCorrelationId() {
		return correlationId;
	}
	/**
	 * @param correlationId the correlationId to set
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	
	
	/**
	 * @return the sapEnrolledService
	 */
	
	@ManyToOne
	@JoinColumn(name="class_id")
	public SAPEnrolledService getSapEnrolledService(){
		return sapEnrolledService;
	}
	/**
	 * @param sapEnrolledService the sapEnrolledService to set
	 */
	public void setSapEnrolledService(SAPEnrolledService sapEnrolledService) {
		this.sapEnrolledService = sapEnrolledService;
	}
	
	/**
	 * @return the requestBody
	 */
	@Column(name="request_body", columnDefinition="text")
	public String getRequestBody() {
		return requestBody;
	}
	/**
	 * @param requestBody the requestBody to set
	 */
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}
	/**
	 * @return the transactionId
	 */
	@Column(name="transaction_id")
	public String getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the serviceResponses
	 */

	@OneToMany(cascade={CascadeType.ALL},mappedBy="serviceRequest")
	public Collection<ServiceResponse> getServiceResponses() {
		return serviceResponses;
	}
	/**
	 * @return the loginId
	 */
	@Column(name="login_id")
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the loginType
	 */
	@Column(name="logintype")
	public String getLoginType() {
		return loginType;
	}

	/**
	 * @param loginType the loginType to set
	 */
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	/**
	 * @param serviceResponses the serviceResponses to set
	 */
	public void setServiceResponses(Collection<ServiceResponse> serviceResponses) {
		this.serviceResponses = serviceResponses;
	}
	
	/**
	 * @return the requestSentTime
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="request_sent_time")
	public Date getRequestSentTime() {
		return requestSentTime;
	}
	/**
	 * @param requestSentTime the requestSentTime to set
	 */
	public void setRequestSentTime(Date requestSentTime) {
		this.requestSentTime = requestSentTime;
	}
	
	
	@Override
	public String toString(){
		StringBuilder mBuffer = new StringBuilder();
		mBuffer.append(getClass().getName());
		mBuffer.append('@');
		mBuffer.append(Integer.toHexString(hashCode()));
		mBuffer.append('[');
		mBuffer.append("applicationId=");
		mBuffer.append(applicationId);
		mBuffer.append(",serviceCode=");
		mBuffer.append(serviceDeptCodeMap.getServiceCode());
		mBuffer.append(",citizenId=");
		mBuffer.append(citizen.getCznId());
		mBuffer.append(",correlationId=");
		mBuffer.append(correlationId);
		mBuffer.append(']');

		return mBuffer.toString();
	}

	/**
	 * @return the applicationStatus
	 */
	@OneToOne(cascade={CascadeType.ALL},mappedBy="serviceRequest")
	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}

	/**
	 * @param applicationStatus the applicationStatus to set
	 */
	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	
	
}
