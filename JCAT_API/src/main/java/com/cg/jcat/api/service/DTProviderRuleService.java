package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.DTProviderRuleDao;
import com.cg.jcat.api.dao.DTProviderRuleModel;
import com.cg.jcat.api.dao.DTProvidersModel;
import com.cg.jcat.api.entity.DTProviderRule;
import com.cg.jcat.api.entity.DTProviderRuleHistory;
import com.cg.jcat.api.exception.JcatExceptions;
@Component
public class DTProviderRuleService implements IDTProviderRuleService{

	@Autowired
	private DTProviderRuleDao dtCloudProviderDao;
	@Override
	public List<DTProvidersModel> getCloudProvider() {
		
		return dtCloudProviderDao.getCloudProvider();
	}
	
	@Override
	public boolean saveCloudProviderRule(List<DTProviderRuleModel> cloudProviderRuleModelList) {
		boolean afterSavedValue = false; 
		
//		for(DTProviderRuleModel cloudProviderRuleModel : cloudProviderRuleModelList)
//		{
			afterSavedValue= dtCloudProviderDao.saveCloudProviderRule(cloudProviderRuleModelList);
//		}
		return afterSavedValue;
	}
	@Override
	///
	public List<DTProviderRuleModel> getCloudProviderRules() {
		return dtCloudProviderDao.getCloudProviderRules();
	}

}
