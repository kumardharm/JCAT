package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.ApplicationDao;
import com.cg.jcat.api.dao.ApplicationModel;

@Component
public class ApplicationService implements IApplicationService {

	@Autowired
	ApplicationDao applicationDao;
	
	@Override
	public List<ApplicationModel> getApplications() {
		
		return applicationDao.getApplications();
	}
	
	@Override
	public void save(String createdBy,ApplicationModel application) {
		applicationDao.save(createdBy,application);
	}

}
