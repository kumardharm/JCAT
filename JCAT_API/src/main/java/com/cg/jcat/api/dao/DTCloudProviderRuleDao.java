package com.cg.jcat.api.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.entity.DTProviderRule;
import com.cg.jcat.api.entity.DTProviders;
import com.cg.jcat.api.exception.JcatExceptions;
import com.cg.jcat.api.repository.CloudProviderRepository;
import com.cg.jcat.api.repository.ICloudProviderRuleRepository;

@Component
public class DTCloudProviderRuleDao {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ICloudProviderRuleRepository cloudProviderRuleRepository;
	
	@Autowired
	private CloudProviderRepository cloudProviderRepository;

	public List<DTCloudProvidersModel> getCloudProvider() {
		List<DTProviders> CloudProviderList = cloudProviderRepository.findAll();
		List<DTCloudProvidersModel> CloudProvidersModelList = new ArrayList<DTCloudProvidersModel>();
		return toCloudProviderModelList(CloudProviderList,CloudProvidersModelList);
	}

	private List<DTCloudProvidersModel> toCloudProviderModelList(List<DTProviders> cloudProviderList,
			List<DTCloudProvidersModel> cloudProvidersModelList) {
			for(DTProviders cloudProviders:cloudProviderList)
			{
				cloudProvidersModelList.add(toCloudProviderMode(cloudProviders));
			}
		return cloudProvidersModelList;
	}

	private DTCloudProvidersModel toCloudProviderMode(DTProviders cloudProviders) {
		DTCloudProvidersModel cloudProvidersModel = new DTCloudProvidersModel();
		cloudProvidersModel.setProviderId(cloudProviders.getProviderId());
		cloudProvidersModel.setEvaluationOrder(cloudProviders.getEvaluationOrder());
		cloudProvidersModel.setProviderName(cloudProviders.getProviderName());
		return cloudProvidersModel;
	}

	public boolean updateCloudProviderRules(DTCloudProviderRuleModel cloudProviderRuleModel) throws JcatExceptions {
		
		boolean updatedResult = false;
		try {
			DTProviderRule cloudProviderRule = new DTProviderRule();
			cloudProviderRule.setModifiedBy("Admin");
			cloudProviderRule.setModifiedTime(new Date());
		DTProviderRule modifiedCloudProviderRule =  cloudProviderRuleRepository.saveAndFlush(toCloudProviderRuleModel(cloudProviderRuleModel,cloudProviderRule));
		if(modifiedCloudProviderRule != null)
		{
			updatedResult = true;
		}
		}catch (Exception e) {
			LOGGER.error("Error while updating cloud provider rules " + cloudProviderRuleModel.getProviderId() + " ErrorMessage: " + e.getMessage(), e);
			throw new JcatExceptions(
					"Exception while saving user " + cloudProviderRuleModel.getProviderId() + " ErrorMessage: " + e.getMessage());
		}
		return updatedResult;
		
	}

	private DTProviderRule toCloudProviderRuleModel(DTCloudProviderRuleModel cloudProviderRuleModel,DTProviderRule cloudProviderRule) {
		
		Date date=new Date();
		cloudProviderRule.setProviderId(cloudProviderRuleModel.getProviderId());
		cloudProviderRule.setEvaluationOrder(cloudProviderRuleModel.getEvaluationOrder());
		cloudProviderRule.setQuestionId(cloudProviderRuleModel.getQuestionId());
		cloudProviderRule.setQuestiontextEN(cloudProviderRuleModel.getQuestiontextEN());
		cloudProviderRule.setRuleOptionIds(cloudProviderRuleModel.getRuleOptionIds());
		cloudProviderRule.setRuleOptionTextEN(cloudProviderRuleModel.getRuleOptionTextEN());
		cloudProviderRule.setCreatedBy("Admin");
		cloudProviderRule.setCreatedTime(date);
//		cloudProviderRule.setModifiedBy(modifiedBy);
//		cloudProviderRule.setModifiedTime(modifiedTime);
		return cloudProviderRule;
	}

	public boolean saveCloudProviderRule(DTCloudProviderRuleModel cloudProviderRuleModel) {
		boolean saveResult = false;
		try
		{
			DTProviderRule cloudProviderRule = new DTProviderRule();
			DTProviderRule	cloudProvidersaved = cloudProviderRuleRepository.save(toCloudProviderRuleModel(cloudProviderRuleModel,cloudProviderRule));
			if(cloudProvidersaved!=null)
			{
				saveResult = true;
			}
		}catch (Exception e) {
			
		}
		return saveResult;
	}

	public List<DTCloudProviderRuleModel> getCloudProviderRules() {
		List<DTProviderRule> cloudProviderRuleList = cloudProviderRuleRepository.findAll();
		List<DTCloudProviderRuleModel> cloudProviderRuleModelList = new ArrayList<DTCloudProviderRuleModel>();
		return toCloudProviderRuleModelList(cloudProviderRuleList,cloudProviderRuleModelList);
	}

	private List<DTCloudProviderRuleModel> toCloudProviderRuleModelList(List<DTProviderRule> cloudProviderRuleList,
			List<DTCloudProviderRuleModel> cloudProviderRuleModelList) {
		for(DTProviderRule cloudProviderRule:cloudProviderRuleList)
		{
			cloudProviderRuleModelList.add(toCloudProviderRuleModel(cloudProviderRule));
		}
		return cloudProviderRuleModelList;
	}

	private DTCloudProviderRuleModel toCloudProviderRuleModel(DTProviderRule cloudProviderRule) {
		DTCloudProviderRuleModel cloudProviderRuleModel = new DTCloudProviderRuleModel();
		cloudProviderRuleModel.setProviderId(cloudProviderRule.getProviderId());
		cloudProviderRuleModel.setProviderRuleId(cloudProviderRule.getProviderRuleId());
		cloudProviderRuleModel.setQuestionId(cloudProviderRule.getQuestionId());
		cloudProviderRuleModel.setEvaluationOrder(cloudProviderRule.getEvaluationOrder());
		cloudProviderRuleModel.setQuestiontextEN(cloudProviderRule.getQuestiontextEN());
		cloudProviderRuleModel.setRuleOptionIds(cloudProviderRule.getRuleOptionIds());
		cloudProviderRuleModel.setRuleOptionTextEN(cloudProviderRule.getRuleOptionTextEN());
		return cloudProviderRuleModel;
	}
	
	
	
}
