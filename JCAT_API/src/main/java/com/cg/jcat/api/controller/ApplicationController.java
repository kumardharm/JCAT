package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.ApplicationModel;
import com.cg.jcat.api.service.IApplicationService;

@Component
public class ApplicationController implements IApplicationController {
	@Autowired
	private IApplicationService applicationService;

	@Override
	public List<ApplicationModel> getApplications() {
			return applicationService.getApplications();
	}
	
	@Override
	public void save(String createdBy,ApplicationModel application) {
		applicationService.save(createdBy,application);
	}
	

}
