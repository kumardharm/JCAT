package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.CloudProvidersModel;
import com.cg.jcat.api.service.ICloudProviderService;
@Component
public class CloudProviderController implements ICloudProviderController{
	
	@Autowired
	private ICloudProviderService cloudProviderService;

	@Override
	public List<CloudProvidersModel> getCloudProvider() {
		
		return cloudProviderService.getCloudProvider();
	}

}
