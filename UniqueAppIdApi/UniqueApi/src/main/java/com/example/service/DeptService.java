package com.example.service;




import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.controller.PrefillForm;

@Service
@Transactional
public interface DeptService {
	
	public List<PrefillForm> prefillForm(String citizenId);

	public String checkStatus(String applicationId, String serviceCode);

	
	
}
