package com.cg.jcat.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.DTCloudProviderRuleModel;
import com.cg.jcat.api.dao.DTCloudProvidersModel;
import com.cg.jcat.api.entity.DTProviderRule;
import com.cg.jcat.api.entity.DTProviderRuleHistory;
import com.cg.jcat.api.exception.JcatExceptions;
import com.cg.jcat.api.service.IDTCloudProviderRuleService;
@Component
public class DTCloudProviderRuleController implements IDTCloudProviderRuleController{
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IDTCloudProviderRuleService dtCloudProviderService;

	@Override
	public List<DTCloudProvidersModel> getCloudProvider() {
		try {
		return dtCloudProviderService.getCloudProvider();
		}catch (Exception e) {
			LOGGER.error("Error in getting all cloud providers : getCloudProvider()", e);
			throw e;
		}
	}

	@Override
	public boolean updateCloudProviderRules(DTCloudProviderRuleModel cloudProviderRuleModel) throws JcatExceptions {
		boolean modifiedValue = false;
		try {
			modifiedValue = dtCloudProviderService.updateCloudProviderRules(cloudProviderRuleModel);
		}catch (JcatExceptions e) {
			LOGGER.error("Error while updating cloud provider rules " + cloudProviderRuleModel.getProviderId(), e);
			throw e;
		}
		return modifiedValue;
		
	}

	@Override
	public boolean saveCloudProviderRule(DTCloudProviderRuleModel cloudProviderRuleModel) {
		
		return dtCloudProviderService.saveCloudProviderRule(cloudProviderRuleModel);
	}

	@Override
	public List<DTCloudProviderRuleModel> getCloudProviderRules() {
		
		return dtCloudProviderService.getCloudProviderRules();
	}

}
