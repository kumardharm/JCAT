package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.CloudProviderDao;
import com.cg.jcat.api.dao.CloudProvidersModel;
@Component
public class CloudProviderService implements ICloudProviderService{

	@Autowired
	private CloudProviderDao cloudProviderDao;
	@Override
	public List<CloudProvidersModel> getCloudProvider() {
		
		return cloudProviderDao.getCloudProvider();
	}

}
