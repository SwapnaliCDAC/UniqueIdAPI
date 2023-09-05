package com.example.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="service_responses")
public class ServiceResponse implements Serializable  {

	

	private long id;

	private String responseBody;
	private String pollInterval;
	private String returnDocument;
	private String status;
	private String responseEndPoint;
	private Date responseRecievedTime;
	private String[] errorStringArray;
	private String reason;
	private ServiceRequest serviceRequest;
	/**
	 * @return the reason
	 */
	@Column(name="reason")
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the errorStringArray
	 */
	@Column(name="error_array")
	public String[] getErrorStringArray() {
		return errorStringArray;
	}
	/**
	 * @param errorStringArray the errorStringArray to set
	 */
	public void setErrorStringArray(String[] errorStringArray) {
		this.errorStringArray = errorStringArray;
	}
	/**
	 * @return the id
	 */
	@Id @GeneratedValue
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
	 * @return the responseBody
	 */
	@Column(name="response_body", columnDefinition="text")
	public String getResponseBody() {
		return responseBody;
	}
	/**
	 * @param responseBody the responseBody to set
	 */
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
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
	 * @return the returnDocumet
	 */
	@Column(name="return_document")
	public String getReturnDocument() {
		return returnDocument;
	}
	/**
	 * @param returnDocumet the returnDocumet to set
	 */
	public void setReturnDocument(String returnDocument) {
		this.returnDocument = returnDocument;
	}
	/**
	 * @return the status
	 */
	@Column(name="status")
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
	 * @return the responseRecievedTime
	 */
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="response_received_time")
	public Date getResponseRecievedTime() {
		return responseRecievedTime;
	}
	/**
	 * @param responseRecievedTime the responseRecievedTime to set
	 */
	public void setResponseRecievedTime(Date responseRecievedTime) {
		this.responseRecievedTime = responseRecievedTime;
	}
	/**
	 * @return the serviceRequest
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns({
        @JoinColumn(name="application_id", referencedColumnName="application_id"),
        @JoinColumn(name="correlation_id", referencedColumnName="correlation_id")
    })

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}
	/**
	 * @param serviceRequest the serviceRequest to set
	 */
	
	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}
}
