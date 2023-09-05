package com.example.service;



import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.dao.UserDao1;
import com.example.controller.PrefillForm;


@Service
@Transactional
public class DeptServiceImp implements DeptService {
	// private static Logger logger =Logger.getLogger(DeptServiceImp.class);
	Logger logger = LoggerFactory.getLogger(DeptServiceImp.class);

	@Autowired
	private UserDao1 userDao;

	

	@Override
	public List<PrefillForm> prefillForm(String citizenId) {
		logger.info(" inside service of prefillForm() ");
		return userDao.prefillForm(citizenId);
	}

	@PersistenceContext
	private EntityManager manager;



	@Override
	public String checkStatus(String applicationId, String serviceCode) {
		logger.info(" inside service of checkStatus() ");
		
		return userDao.checkStatus(applicationId,serviceCode);
	}



}
