package com.example.controller;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.example.dao.DBUtils;
import com.example.pojos.ApplicationStatusTracker;
import com.example.service.DeptService;



@Controller
@RequestMapping("/service")
public class CustomerController {	
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	
	public CustomerController() {
		super();
	}
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private DeptService deptService;
	
	
	@ResponseBody
	@GetMapping(value = "/apiRun")
	public String apiRun() {
		System.out.println("Api running successfully");
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/prefillForm", method = RequestMethod.POST)
		public String prefillForm(@RequestBody Map<String, Object> details) {
		logger.info("inside prefillForm  of  controller ");
		
//		String applicationId = null;
		String errorString = null;
		// http://localhost:8080/customer/getTehsil?districtCode=D01

		
		Map<String, Object> jsonReqData = new HashMap<String, Object>(details);
		
		String citizenId = (String) jsonReqData.get("cznId");
		logger.info("citizen id is " + citizenId);
		
		String applicationId = (String) jsonReqData.get("applicationId");
		logger.info("applicationId id is " + applicationId);
		
		String serviceCode = (String) jsonReqData.get("serviceCode");
		logger.info("serviceCode is " + serviceCode);		
			
		
		//To check the domicile status of the applicationid
		
		String status = deptService.checkStatus(applicationId, serviceCode);
		logger.info("status is - "+status);
		
		String sts = checkDuplicateApplicationSubmission1(citizenId, serviceCode);

		String jsonString = "";
		String finals = null;
		// String a="sdsds" + "sds";
		logger.info("sts is " + sts);
		
		if (sts != null) {
			if (sts.equals("INPROCESS") || sts.equals("FORWARD") || sts.equals("LOOPBACK") || sts.equals("BACKWARD")
					|| sts.equals("COMPLETION") || sts.equals("REJECTION") || sts.equals("FAILED")
					|| sts.equals("PAYFAILED")) {
				
				JSONObject obj = new JSONObject();
				obj.put("Status", "Failed");
				obj.put("Description", "One similar application is already submitted ");
				return obj.toString();
				// return "Application is already in " + sts + " state ";
			}
		}
		logger.info("test 1");
		
		if (sts == null || sts.startsWith("PROCEED_FOR_RESUBMIT")  || sts.equalsIgnoreCase("RESUBMIT"))
			
		{
			try {
				List<PrefillForm> prefill = new ArrayList<>();
				prefill = deptService.prefillForm(citizenId);
				logger.info("prefill " + prefill);
				if (!prefill.isEmpty()) {
					logger.info("json = " + new Gson().toJson(prefill));
					jsonString = new Gson().toJson(prefill);
					String newString = jsonString.substring(1, jsonString.length() - 1);
					logger.info("newString is " + newString);
					// String applications = jsonString.getString("stateApplicationId");

					JSONObject jsonObject = new JSONObject(newString);
					String curDistrictFormId = jsonObject.getString("curDistrictFormId");
					String curTehsilFormId = jsonObject.getString("curTehsilFormId");
					logger.info("curDistrictFormId is " + curDistrictFormId);
					logger.info("curTehsilFormId is " + curTehsilFormId);
					// SAPEnrolledService ses =new SAPEnrolledService();
					String ses = findClassId1(serviceCode);
					logger.info("service code after method is " + ses);

					ApplicationIdResponseDetails aResponseDetails = new ApplicationIdResponseDetails();
//					aResponseDetails = deptService.getApplicationId1(ses, curTehsilFormId, curDistrictFormId);

					errorString = aResponseDetails.getErrorString();
					applicationId = aResponseDetails.getApplicationId();
					if (applicationId != null) {
						logger.info("Successfully received application Id.");
						logger.info("applicationId ::" + applicationId.trim());
					}

					JSONObject jsonObject1 = new JSONObject(newString);
					jsonObject1.put("applicationId", applicationId);
					finals = jsonObject1.toString();
					return finals;
				} else {
					JSONObject obj2 = new JSONObject();
					obj2.put("Status", "Failed");
					obj2.put("Description", "Citizen-id not found. Please register yourself");
					return obj2.toString();
					// return "czn id not found";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			JSONObject obj3 = new JSONObject();
			obj3.put("Status", "Failed");
			obj3.put("Description", "Some error occured.Please try again ");
			return obj3.toString();
			
		}
		
		return null;
	}

	
	public String checkDuplicateApplicationSubmission1(String cznId, String serviceCode) {

		/*
		 * Map<String, Object> jsonReqData = new HashMap<String, Object>(details);
		 * String cznId = (String) jsonReqData.get("cznId"); String serviceCode =
		 * (String) jsonReqData.get("serviceCode");
		 */
		// String cznId,String serviceCode
		try {
			logger.info("Inside checkDuplicateApplicationSubmission()::");
			logger.info("Citizen-Id::" + cznId);
			logger.info("serviceCode::" + serviceCode);
//			ApplicationStatusTracker aTracker = new ApplicationStatusTracker();
			List<ApplicationStatusTracker> aTrackerList = new ArrayList<ApplicationStatusTracker>();
			Query query = manager.createQuery(
					"from com.app.pojos.ApplicationStatusTracker a where a.citizen.cznId=:cznId and a.serviceDeptCodeMap.serviceCode=:serviceCode");
			query.setParameter("cznId", cznId);
			query.setParameter("serviceCode", serviceCode);
			/*
			 * qList = query.getResultList();
			 * 
			 * logger.info("qList size :"+qList.size()); if (qList.size() == 0) return null;
			 */
			aTrackerList = query.getResultList();
			logger.info("qList size :" + aTrackerList.size());
			if (aTrackerList.size() == 0)
				return null;
			String status_type = null;
			String duplicate_appId = null;
			boolean duplicateFlag = false;

			for (ApplicationStatusTracker e : aTrackerList) {
				status_type = e.getAppStatusCode();

				logger.info(" status_type in method is " + status_type);

				
				
				//PRANJALI ADDED CODE FOR RESUBMIT AND REJECTED ON 17/09/2022 START
				
				if((status_type.equalsIgnoreCase("COMPLETION")) || 
						(status_type.equalsIgnoreCase("REJECTION")) ||
				(status_type.equalsIgnoreCase("FAILED")||
						(status_type.equalsIgnoreCase("PAYFAILED"))) ){
					
					
					if(serviceCode.equalsIgnoreCase("DOM") && status_type.equalsIgnoreCase("COMPLETION")){
						 logger.info("Duplicate application found with status :" +status_type);
							duplicateFlag=true;
							//duplicate_appId = e.getApplicationId().trim();
							duplicate_appId = e.getServiceRequest().getApplicationId().trim();
					}
					/*if(serviceCode.equalsIgnoreCase("MUM") && 
							((status_type.equalsIgnoreCase("REJECTION")) || 
									(status_type.equalsIgnoreCase("RESUBMIT")))){
						 logger.info("application found with status : " +status_type+", need to remove entries from uidrecord and driving license record");
						 removeLicenseRecord(e.getServiceRequest().getApplicationId());
						 removeUIDRecord(e.getServiceRequest().getApplicationId());
					}*/
				}
					else if((status_type.equalsIgnoreCase("INPROCESS")) 
							|| (status_type.equalsIgnoreCase("FORWARD"))
							|| (status_type.equalsIgnoreCase("LOOPBACK"))
							||(status_type.equalsIgnoreCase("BACKWARD"))){
						    logger.info("Duplicate application found with status :" +status_type);
							duplicateFlag=true;
							//duplicate_appId = e.getApplicationId().trim();
							duplicate_appId = e.getServiceRequest().getApplicationId().trim();
						}
					
					else if(status_type.equalsIgnoreCase("RESUBMIT")){
						logger.info("Duplicate application found with status :" +status_type);
						logger.info("Returning RESUBMIT");
						if(serviceCode.equalsIgnoreCase("MUM")){
							 logger.info("application found with status : " +status_type+", need to remove entries from uidrecord and driving license record");
							// removeLicenseRecord(e.getServiceRequest().getApplicationId());
							 //removeUIDRecord(e.getServiceRequest().getApplicationId());
						}
						// Commented on 03-01-2019 for pmp application where citizen allowed to apply multiple applications even if status is inprocess
						
						
						
						
//						if(!duplicateFlag)   
							return "PROCEED_FOR_RESUBMIT"+e.getServiceRequest().getApplicationId().trim();
					}	
					
				}
				
				//PRANJALI ADDED CODE FOR RESUBMIT AND REJECTED ON 17/09/2022 START
				// 2 line are commented on 17-09
			//	return status_type;
			//}

			if (duplicateFlag == true) {
				logger.info(
						"Citizen has submitted the same application already which is still under processing at backoffice.");
				//return duplicate_appId;
				return status_type;
			} else {
				// logger.info("Deleted applications COMPLETED/REJECTED if any.");
				logger.info("No applications submitted by citizen are INPROCESS");
				return "PROCEED";
			}

		} catch (NoResultException e) {
			logger.info("No such result present!!");
			return null;
		}

	}


	public String findClassId1(String serviceCode) {
		logger.info("inside findClassId1");
		String classId = null;
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBUtils.fetchDBConnection();

			stmt = con.createStatement();
			String query = "select class_id from sap_enrolled_services where service_code= '" + serviceCode + "'";
			ResultSet rs = stmt.executeQuery(query.toString());

			while (rs.next()) {
				classId = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classId;
	}

	

}
