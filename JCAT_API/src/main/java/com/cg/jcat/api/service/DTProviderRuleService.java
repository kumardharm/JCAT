package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.DTCloudProviderRuleDao;
import com.cg.jcat.api.dao.DTProviderRuleModel;
import com.cg.jcat.api.dao.DTCProvidersModel;
import com.cg.jcat.api.entity.DTProviderRule;
import com.cg.jcat.api.entity.DTProviderRuleHistory;
import com.cg.jcat.api.exception.JcatExceptions;
@Component
public class DTCloudProviderRuleService implements IDTCloudProviderRuleService{

	@Autowired
	private DTCloudProviderRuleDao dtCloudProviderDao;
	@Override
	public List<DTCProvidersModel> getCloudProvider() {
		
		return dtCloudProviderDao.getCloudProvider();
	}
	@Override
	public boolean updateCloudProviderRules(DTProviderRuleModel cloudProviderRuleModel) throws JcatExceptions {
		
		return dtCloudProviderDao.updateCloudProviderRules(cloudProviderRuleModel);
	}
	@Override
	public boolean saveCloudProviderRule(List<DTProviderRuleModel> cloudProviderRuleModelList) {
		boolean afterSavedValue = false; 
		for(DTProviderRuleModel cloudProviderRuleModel : cloudProviderRuleModelList)
		{
			afterSavedValue= dtCloudProviderDao.saveCloudProviderRule(cloudProviderRuleModel);
		}
		return afterSavedValue;
	}
	@Override
	///
	public List<DTProviderRuleModel> getCloudProviderRules() {
		return dtCloudProviderDao.getCloudProviderRules();
	}

}
