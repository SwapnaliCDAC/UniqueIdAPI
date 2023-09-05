package com.example.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="application_status")
public class ApplicationStatus implements Serializable{

	
	private long id;
	private String responseBody;
	private ServiceRequest serviceRequest;
	
	public ApplicationStatus(){}
	
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
	 * @return the responseBody
	 */
	@Column(name="response_body", columnDefinition="text")
	public String getResponseBody() {
		return responseBody;
	}
	
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	
	@Override
	public String toString(){
		StringBuilder mBuffer = new StringBuilder();
		mBuffer.append(getClass().getName());
		mBuffer.append('@');
		mBuffer.append(Integer.toHexString(hashCode()));
		mBuffer.append('[');
		mBuffer.append("applicationId=");
		mBuffer.append(serviceRequest.getApplicationId());
		mBuffer.append(",serviceCode=");
		mBuffer.append(serviceRequest.getServiceDeptCodeMap().getServiceCode());
		mBuffer.append(']');

		return mBuffer.toString();
	}
	
	

}
