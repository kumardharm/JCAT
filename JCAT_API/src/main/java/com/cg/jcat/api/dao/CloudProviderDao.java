package com.cg.jcat.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.entity.CloudProviders;
import com.cg.jcat.api.repository.CloudProviderRepository;

@Component
public class CloudProviderDao {

	@Autowired
	private CloudProviderRepository cloudProviderRepository;

	public List<CloudProvidersModel> getCloudProvider() {
		List<CloudProviders> CloudProviderList = cloudProviderRepository.findAll();
		List<CloudProvidersModel> CloudProvidersModelList = new ArrayList<CloudProvidersModel>();
		return toCloudProviderModelList(CloudProviderList,CloudProvidersModelList);
	}

	private List<CloudProvidersModel> toCloudProviderModelList(List<CloudProviders> cloudProviderList,
			List<CloudProvidersModel> cloudProvidersModelList) {
			for(CloudProviders cloudProviders:cloudProviderList)
			{
				cloudProvidersModelList.add(toCloudProviderMode(cloudProviders));
			}
		return cloudProvidersModelList;
	}

	private CloudProvidersModel toCloudProviderMode(CloudProviders cloudProviders) {
		CloudProvidersModel cloudProvidersModel = new CloudProvidersModel();
		cloudProvidersModel.setProviderId(cloudProviders.getProviderId());
		cloudProvidersModel.setEvaluationOrder(cloudProviders.getEvaluationOrder());
		cloudProvidersModel.setProviderName(cloudProviders.getProviderName());
		return cloudProvidersModel;
	}
	
	
	
}
