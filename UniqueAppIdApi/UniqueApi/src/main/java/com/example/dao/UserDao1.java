package com.example.dao;

import java.util.List;



import com.example.controller.PrefillForm;




public interface UserDao1 {

	
	List<PrefillForm> prefillForm(String citizenId);

	String checkStatus(String applicationId, String serviceCode);
	
	
	}