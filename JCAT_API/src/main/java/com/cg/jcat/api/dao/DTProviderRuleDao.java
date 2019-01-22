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

	public List<DTCProvidersModel> getCloudProvider() {
		List<DTProviders> CloudProviderList = cloudProviderRepository.findAll();
		List<DTCProvidersModel> CloudProvidersModelList = new ArrayList<DTCProvidersModel>();
		return toCloudProviderModelList(CloudProviderList,CloudProvidersModelList);
	}

	private List<DTCProvidersModel> toCloudProviderModelList(List<DTProviders> cloudProviderList,
			List<DTCProvidersModel> cloudProvidersModelList) {
			for(DTProviders cloudProviders:cloudProviderList)
			{
				cloudProvidersModelList.add(toCloudProviderMode(cloudProviders));
			}
		return cloudProvidersModelList;
	}

	private DTCProvidersModel toCloudProviderMode(DTProviders cloudProviders) {
		DTCProvidersModel cloudProvidersModel = new DTCProvidersModel();
		cloudProvidersModel.setProviderId(cloudProviders.getProviderId());
		cloudProvidersModel.setEvaluationOrder(cloudProviders.getEvaluationOrder());
		cloudProvidersModel.setProviderName(cloudProviders.getProviderName());
		return cloudProvidersModel;
	}

public boolean updateCloudProviderRules(DTProviderRuleModel cloudProviderRuleModel) throws JcatExceptions {
		
		boolean updatedResult = false;
		try {
			DTProviderRule cloudProviderRule = new DTProviderRule();
			cloudProviderRule.setModifiedBy("Admin");
			cloudProviderRule.setModifiedTime(new Date());
			cloudProviderRule.setProviderRuleId(cloudProviderRuleModel.getProviderRuleId());
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
	
//	public boolean updateCloudProviderRules(DTCloudProviderRuleModel cloudProviderRuleModel) throws JcatExceptions {
//		
//		boolean updatedResult = false;
//		try {
//			DTProviderRule cloudProviderRule = new DTProviderRule();
//			cloudProviderRule.setModifiedBy("Admin");
//			cloudProviderRule.setModifiedTime(new Date());
//<<<<<<< HEAD
//			cloudProviderRule.setProviderRuleId(cloudProviderRuleModel.getProviderRuleId());
//		DTCloudProviderRule modifiedCloudProviderRule =  cloudProviderRuleRepository.saveAndFlush(toCloudProviderRuleModel(cloudProviderRuleModel,cloudProviderRule));
//=======
//		DTProviderRule modifiedCloudProviderRule =  cloudProviderRuleRepository.saveAndFlush(toCloudProviderRuleModel(cloudProviderRuleModel,cloudProviderRule));
//>>>>>>> refs/remotes/origin/master
//		if(modifiedCloudProviderRule != null)
//		{
//			updatedResult = true;
//		}
//		}catch (Exception e) {
//			LOGGER.error("Error while updating cloud provider rules " + cloudProviderRuleModel.getProviderId() + " ErrorMessage: " + e.getMessage(), e);
//			throw new JcatExceptions(
//					"Exception while saving user " + cloudProviderRuleModel.getProviderId() + " ErrorMessage: " + e.getMessage());
//		}
//		return updatedResult;
//		
//	}

	private DTProviderRule toCloudProviderRuleModel(DTProviderRuleModel cloudProviderRuleModel,DTProviderRule cloudProviderRule) {
		
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
	
	public boolean saveCloudProviderRule(DTProviderRuleModel cloudProviderRuleModel) {
		boolean saveResult = false;
		try
		{
			DTProviderRule cloudProviderRule = new DTProviderRule();
			List<DTProviderRule> cloudProviderRuleList = cloudProviderRuleRepository.findAll();
			if(cloudProviderRuleList != null)
			{
				
			}
			DTProviderRule	cloudProvidersaved = cloudProviderRuleRepository.save(toCloudProviderRuleModel(cloudProviderRuleModel,cloudProviderRule));
			if(cloudProvidersaved!=null)
			{
				saveResult = true;
			}
		}catch (Exception e) {
			
		}
		return saveResult;
	}


//	public boolean saveCloudProviderRule(DTCloudProviderRuleModel cloudProviderRuleModel) {
//		boolean saveResult = false;
//		try
//		{
//<<<<<<< HEAD
//			DTCloudProviderRule cloudProviderRule = new DTCloudProviderRule();
//			List<DTCloudProviderRule> cloudProviderRuleList = cloudProviderRuleRepository.findAll();
//			if(cloudProviderRuleList != null)
//			{
//				
//			}
//			DTCloudProviderRule	cloudProvidersaved = cloudProviderRuleRepository.save(toCloudProviderRuleModel(cloudProviderRuleModel,cloudProviderRule));
//=======
//			DTProviderRule cloudProviderRule = new DTProviderRule();
//			DTProviderRule	cloudProvidersaved = cloudProviderRuleRepository.save(toCloudProviderRuleModel(cloudProviderRuleModel,cloudProviderRule));
//>>>>>>> refs/remotes/origin/master
//			if(cloudProvidersaved!=null)
//			{
//				saveResult = true;
//			}
//		}catch (Exception e) {
//			
//		}
//		return saveResult;
//	}

	public List<DTProviderRuleModel> getCloudProviderRules() {
		List<DTProviderRule> cloudProviderRuleList = cloudProviderRuleRepository.findAll();
		List<DTProviderRuleModel> cloudProviderRuleModelList = new ArrayList<DTProviderRuleModel>();
		return toCloudProviderRuleModelList(cloudProviderRuleList,cloudProviderRuleModelList);
	}

	private List<DTProviderRuleModel> toCloudProviderRuleModelList(List<DTProviderRule> cloudProviderRuleList,
			List<DTProviderRuleModel> cloudProviderRuleModelList) {
		for(DTProviderRule cloudProviderRule:cloudProviderRuleList)
		{
			cloudProviderRuleModelList.add(toCloudProviderRuleModel(cloudProviderRule));
		}
		return cloudProviderRuleModelList;
	}

	private DTProviderRuleModel toCloudProviderRuleModel(DTProviderRule cloudProviderRule) {
		DTProviderRuleModel cloudProviderRuleModel = new DTProviderRuleModel();
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
