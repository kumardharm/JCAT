package com.cg.jcat.api.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.entity.DTProviderRule;
import com.cg.jcat.api.entity.DTProviderRuleHistory;
import com.cg.jcat.api.entity.DTProviders;
import com.cg.jcat.api.exception.JcatExceptions;
import com.cg.jcat.api.repository.IDTProviderRepository;
import com.cg.jcat.api.repository.IDTProviderRuleHistory;
import com.cg.jcat.api.repository.IDTProviderRuleRepository;

@Component
public class DTProviderRuleDao {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IDTProviderRuleRepository cloudProviderRuleRepository;
	
	@Autowired
	private IDTProviderRepository cloudProviderRepository;
	
	@Autowired
	private IDTProviderRuleHistory ProviderRuleHistory;

	public List<DTProvidersModel> getCloudProvider() {
		List<DTProviders> CloudProviderList = cloudProviderRepository.findAll();
		List<DTProvidersModel> CloudProvidersModelList = new ArrayList<DTProvidersModel>();
		return toCloudProviderModelList(CloudProviderList,CloudProvidersModelList);
	}

	private List<DTProvidersModel> toCloudProviderModelList(List<DTProviders> cloudProviderList,
			List<DTProvidersModel> cloudProvidersModelList) {
			for(DTProviders cloudProviders:cloudProviderList)
			{
				cloudProvidersModelList.add(toCloudProviderMode(cloudProviders));
			}
		return cloudProvidersModelList;
	}

	private DTProvidersModel toCloudProviderMode(DTProviders cloudProviders) {
		DTProvidersModel cloudProvidersModel = new DTProvidersModel();
		cloudProvidersModel.setProviderId(cloudProviders.getProviderId());
		cloudProvidersModel.setEvaluationOrder(cloudProviders.getEvaluationOrder());
		cloudProvidersModel.setProviderName(cloudProviders.getProviderName());
		return cloudProvidersModel;
	}
	

	private DTProviderRule toCloudProviderRule(DTProviderRuleModel cloudProviderRuleModel,DTProviderRule cloudProviderRule) {
		
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
	

	public boolean saveProviderRule(List<DTProviderRuleModel> cloudProviderRuleModel)
	{
		int countOfHistoryRule = getCountOfMigrationRuleHistoryRule();
		if(countOfHistoryRule != 0 || getCountOfMigrationRule()!=0)
		{
			saveProviderRuleHistory(cloudProviderRuleModel);
		}
		cloudProviderRuleRepository.deleteAll();
		return saveCloudProviderRule(cloudProviderRuleModel);
	}
	
	
	private void saveProviderRuleHistory(List<DTProviderRuleModel> cloudProviderRuleModel) {
		
		cloudProviderRuleModel
		
	}

	private int getCountOfMigrationRule() {
		
		return cloudProviderRuleRepository.findAll().size();
	}

	private int getCountOfMigrationRuleHistoryRule() {
		
		return ProviderRuleHistory.findAll().size();
	}

	public boolean saveCloudProviderRule(List<DTProviderRuleModel> cloudProviderRuleModel) {
		boolean saveResult = false;
		try
		{
			List<DTProviderRule> cloudProviderRule = new ArrayList<DTProviderRule>();
			List<DTProviderRule> cloudProviderRuleList = cloudProviderRuleRepository.findAll();
			if(cloudProviderRuleList != null)
			{
				List<DTProviderRuleHistory> providerRuleHistoryList = new ArrayList<DTProviderRuleHistory>(); 
				ProviderRuleHistory.saveAll(toProviderHistoryList(cloudProviderRuleList,providerRuleHistoryList));
			}
			cloudProviderRuleRepository.deleteAll();
			List<DTProviderRule>	cloudProvidersaved = cloudProviderRuleRepository.saveAll(toCloudProviderRuleList(cloudProviderRuleModel,cloudProviderRule));
			if(cloudProvidersaved!=null)
			{
				saveResult = true;
			}
		}catch (Exception e) {
			
		}
		return saveResult;
	}



	
	private List<DTProviderRule> toCloudProviderRuleList(List<DTProviderRuleModel> cloudProviderRuleModel,
			List<DTProviderRule> cloudProviderRule) {
    	for(DTProviderRuleModel providerRuleModel : cloudProviderRuleModel)
    	{
    		DTProviderRule providerRule = new DTProviderRule();
    		cloudProviderRule.add(toCloudProviderRule(providerRuleModel,providerRule));
    	}
		
		return cloudProviderRule;
	}

	private Iterable toProviderHistoryList(List<DTProviderRule> cloudProviderRuleList,
			List<DTProviderRuleHistory> providerRuleHistoryList) {
		
		for(DTProviderRule providerRule:cloudProviderRuleList)
		{
			providerRuleHistoryList.add(toProviderHistory(providerRule));
		}
		
		return providerRuleHistoryList;
	}

	private DTProviderRuleHistory toProviderHistory(DTProviderRule providerRule) {
		DTProviderRuleHistory providerRuleHistory = new DTProviderRuleHistory();
		providerRuleHistory.setProviderId(providerRule.getProviderId());
		providerRuleHistory.setProviderRuleId(providerRule.getProviderRuleId());
		providerRuleHistory.setEvaluationOrder(providerRule.getEvaluationOrder());
		providerRuleHistory.setQuestionId(providerRule.getQuestionId());
		providerRuleHistory.setQuestionTextEN(providerRule.getRuleOptionIds());
		providerRuleHistory.setRuleOptionIds(providerRule.getRuleOptionTextEN());
		providerRuleHistory.setRuleOptionTextEN(providerRule.getRuleOptionTextEN());
		providerRuleHistory.setCreatedBy(providerRule.getCreatedBy());
		providerRuleHistory.setCreatedTime(providerRule.getCreatedTime());
		return providerRuleHistory;
	}

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
