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
import com.cg.jcat.api.exception.SystemExceptions;
@Component
public class DTProviderRuleService implements IDTProviderRuleService{

	@Autowired
	private DTProviderRuleDao dtCloudProviderDao;
	@Override
	public List<DTProvidersModel> getCloudProvider() {
		
		return dtCloudProviderDao.getCloudProvider();
	}
	
	@Override
	public boolean saveCloudProviderRule(List<DTProviderRuleModel> cloudProviderRuleModelList) throws SystemExceptions {
		boolean afterSavedValue = false; 
		int count = 0;
		
		for(DTProviderRuleModel cloudProviderRuleModel : cloudProviderRuleModelList)
		{
			if(cloudProviderRuleModel.getRuleOptionTextEN() != null)
			{
				String optionText[] = cloudProviderRuleModel.getRuleOptionTextEN().split(",");
				String optionIds[] = cloudProviderRuleModel.getRuleOptionIds().split(",");
				if(optionText.length==optionIds.length)
				{
					count++;
				}
			}
		}
		try {
		if(count==cloudProviderRuleModelList.size())
		{
			afterSavedValue= dtCloudProviderDao.saveProviderRule(cloudProviderRuleModelList);
		}
		}catch (Exception e) {
			
		}

		return afterSavedValue;
	}
	@Override
	///
	public List<DTProviderRuleModel> getCloudProviderRules() {
		return dtCloudProviderDao.getCloudProviderRules();
	}

}
