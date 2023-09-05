package com.example.dao;


import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.pojos.Citizen;
import com.example.controller.PrefillForm;
import org.apache.commons.codec.binary.Base64;

@Repository
@Transactional
public class UserDaoImpl1 implements UserDao1 {
	//private static Logger logger =Logger.getLogger(UserDaoImpl1.class);
	Logger logger = LoggerFactory.getLogger(UserDaoImpl1.class);
	
	@Autowired
	private EntityManager manager;


	

	@Override
	public List<PrefillForm> prefillForm(String citizenId) {
		logger.info("inside prefillForm() of  UserDaoImpl1  ");
		List<PrefillForm> prefill = new ArrayList<>();
		PrefillForm prefillForm = null;
		Connection con = null;
		Statement stmt = null;
		Citizen citizen = null;
		try {
		//	con = DriverManager.getConnection("jdbc:postgresql://10.210.0.220:5432/stag_jnk_eservices_dev","jkeservices", "jkeservices");
		//	con = DriverManager.getConnection("jdbc:postgresql://192.168.0.28:5432/laservices","laservice","laservice");
			//con = DriverManager.getConnection("jdbc:postgresql://192.168.13.126:5432/stag_jnk_eservices_dev","laservice","laservice");
			
			con=DBUtils.fetchDBConnection();
			
			stmt = con.createStatement();
			String query="select czn_id, czn_name, parentage_name, phonenumber, cell_no, dob, gender, email, uid, curadddresline1, curaddressline2, curdistrictformid, curpincode, curtehsilformid, "
					+ "  prmadddresline1 , prmaddressline2, prmdistrictformid, prmpincode, prmtehsilformid, photo_data from citizen where czn_id = '" + citizenId + "'";
			ResultSet rs = stmt.executeQuery(query.toString());
			while (rs.next()) {
				prefillForm = new PrefillForm();
				
				prefillForm.setCznId(rs.getString(1));
				prefillForm.setName(rs.getString(2));
				prefillForm.setParentagename(rs.getString(3));
				prefillForm.setPhoneNumber(rs.getString(4));
				prefillForm.setCellNo(rs.getString(5));
				
				prefillForm.setDob(rs.getDate(6));
				prefillForm.setGender(rs.getString(7));
				prefillForm.setEmail(rs.getString(8));
				prefillForm.setUid(rs.getString(9));
			
				prefillForm.setCurAdddresLine1(rs.getString(10));
				prefillForm.setCurAddressLine2(rs.getString(11));
				prefillForm.setCurDistrictFormId(rs.getString(12));
				prefillForm.setCurPincode(rs.getString(13));
				prefillForm.setCurTehsilFormId(rs.getString(14));				
				
				
				prefillForm.setPrmAdddresLine1(rs.getString(15));
				prefillForm.setPrmAddressLine2(rs.getString(16));
				prefillForm.setPrmDistrictFormId(rs.getString(17));  
				prefillForm.setPrmPincode(rs.getString(18));
				prefillForm.setPrmTehsilFormId(rs.getString(19));
				
				byte[] photo=rs.getBytes(20);
			
				
				logger.info("photo data from table is "+photo);
				  String s = new String(photo, StandardCharsets.UTF_16);
				  logger.info("final the  value is "+s);

				prefillForm.setPhotoData(s);

				logger.info("prefill form photo is "+prefillForm.getPhotoData());
				logger.info(" prefill form object is "+prefillForm.toString());
				String encodedString = Base64.encodeBase64String(rs.getBytes(20));
				logger.info("encoded string is  "+new String(encodedString.getBytes()));
				
				
				logger.info("test 1111");
				
				
				prefill.add(prefillForm);

			}
			
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return prefill;
	}




	@Override
	public String checkStatus(String applicationId, String serviceCode) {
		logger.info("inside checkStatus() of  UserDaoImpl1  ");
		Connection con = null;
		Statement stmt = null;
		String status = null;
		
		try {
			logger.info("applicationId - "+applicationId);
			logger.info("serviceCode - "+serviceCode);
			
			con = DriverManager.getConnection("jdbc:postgresql://10.210.0.173:42022/stag_jkoffice_dev","jkoffice", "jkof%87#");
			stmt = con.createStatement();
			String query="select esigned from  jksp_dom_appdata where  application_id = '" + applicationId + "'";
			ResultSet rs = stmt.executeQuery(query.toString());
			
			while (rs.next()) {
	            status = rs.getString("esigned");	           
	        }			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
		return status;
	}
	
	
	
}
