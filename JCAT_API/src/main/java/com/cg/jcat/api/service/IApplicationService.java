package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.jcat.api.dao.ApplicationModel;
import com.cg.jcat.api.exception.SystemExceptions;

@Service
public interface IApplicationService {

	public List<ApplicationModel> getApplications() throws SystemExceptions;
	public void save(String createdBy,ApplicationModel application);

}
