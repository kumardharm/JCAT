package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.DTCloudProviderRuleDao;
import com.cg.jcat.api.dao.DTCloudProviderRuleModel;
import com.cg.jcat.api.dao.DTCloudProvidersModel;
import com.cg.jcat.api.entity.DTCloudProviderRule;
import com.cg.jcat.api.entity.DTProviderRuleHistory;
import com.cg.jcat.api.exception.JcatExceptions;
@Component
public class DTCloudProviderRuleService implements IDTCloudProviderRuleService{

	@Autowired
	private DTCloudProviderRuleDao dtCloudProviderDao;
	@Override
	public List<DTCloudProvidersModel> getCloudProvider() {
		
		return dtCloudProviderDao.getCloudProvider();
	}
	@Override
	public boolean updateCloudProviderRules(DTCloudProviderRuleModel cloudProviderRuleModel) throws JcatExceptions {
		
		return dtCloudProviderDao.updateCloudProviderRules(cloudProviderRuleModel);
	}
	@Override
	public boolean saveCloudProviderRule(List<DTCloudProviderRuleModel> cloudProviderRuleModelList) {
		boolean afterSavedValue = false; 
		for(DTCloudProviderRuleModel cloudProviderRuleModel : cloudProviderRuleModelList)
		{
			afterSavedValue= dtCloudProviderDao.saveCloudProviderRule(cloudProviderRuleModel);
		}
		return afterSavedValue;
	}
	@Override
	///
	public List<DTCloudProviderRuleModel> getCloudProviderRules() {
		return dtCloudProviderDao.getCloudProviderRules();
	}

}
