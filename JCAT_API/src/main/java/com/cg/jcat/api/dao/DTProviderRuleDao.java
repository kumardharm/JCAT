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
import com.cg.jcat.api.exception.SystemExceptions;
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

	/*
	 * GET ALL PROVIDERS PRESENT IN DATABASE
	 * 
	 */
	
	public List<DTProvidersModel> getCloudProvider() {
		List<DTProviders> CloudProviderList = cloudProviderRepository.findAll();
		List<DTProvidersModel> CloudProvidersModelList = new ArrayList<DTProvidersModel>();
		return toCloudProviderModelList(CloudProviderList, CloudProvidersModelList);
	}
	
	/*
	 * CONVERTING ALL PROVIDERS LIST TO PROVIDERMODEL LIST AND ADD PROVIDERMODE TO PROVIDERMODELIST
	 * 
	 */
	private List<DTProvidersModel> toCloudProviderModelList(List<DTProviders> cloudProviderList,
			List<DTProvidersModel> cloudProvidersModelList) {
		for (DTProviders cloudProviders : cloudProviderList) {
			cloudProvidersModelList.add(toCloudProviderMode(cloudProviders));
		}
		return cloudProvidersModelList;
	}

	/*
	 * CONVERTING ALL PROVIDERS TO PROVIDERMODEL 
	 * 
	 */
	
	private DTProvidersModel toCloudProviderMode(DTProviders cloudProviders) {
		DTProvidersModel cloudProvidersModel = new DTProvidersModel();
		cloudProvidersModel.setProviderId(cloudProviders.getProviderId());
		cloudProvidersModel.setEvaluationOrder(cloudProviders.getEvaluationOrder());
		cloudProvidersModel.setProviderName(cloudProviders.getProviderName());
		return cloudProvidersModel;
	}

	/*
	 * GET ALL PROVIDERS RULES BASED ON THE ID PRESENT IN DATABASE
	 * IN CASE NO ID IS PRESENT ALL RULES WILL BE SEND
	 * 
	 */

	public List<DTProviderRuleModel> getCloudProviderRules() {
		List<DTProviderRule> cloudProviderRuleList = cloudProviderRuleRepository.findAll();
		List<DTProviderRuleModel> cloudProviderRuleModelList = new ArrayList<DTProviderRuleModel>();
		return toCloudProviderRuleModelList(cloudProviderRuleList, cloudProviderRuleModelList);
	}
	

	/*
	 * CONVERTING ALL PROVIDERMODEL LIST TO PROVIDERS LIST AND ADD PROVIDER TO PROVIDERLIST
	 * 
	 */
	
	private List<DTProviderRuleModel> toCloudProviderRuleModelList(List<DTProviderRule> cloudProviderRuleList,
			List<DTProviderRuleModel> cloudProviderRuleModelList) {
		for (DTProviderRule cloudProviderRule : cloudProviderRuleList) {
			cloudProviderRuleModelList.add(toCloudProviderRuleModel(cloudProviderRule));
		}
		return cloudProviderRuleModelList;
	}
	
	/*
	 * CONVERTING ALL PROVIDERMODEL TO PROVIDERS 
	 * 
	 */

	private DTProviderRuleModel toCloudProviderRuleModel(DTProviderRule cloudProviderRule) {
		DTProviderRuleModel cloudProviderRuleModel = new DTProviderRuleModel();
		cloudProviderRuleModel.setProviderId(cloudProviderRule.getProviderId());
		cloudProviderRuleModel.setProviderRuleId(cloudProviderRule.getProviderRuleId());
		cloudProviderRuleModel.setQuestionId(cloudProviderRule.getQuestionId());
		cloudProviderRuleModel.setEvaluationOrder(cloudProviderRule.getExecutionOrder());
		cloudProviderRuleModel.setQuestiontextEN(cloudProviderRule.getQuestiontextEN());
		cloudProviderRuleModel.setRuleOptionIds(cloudProviderRule.getRuleOptionIds());
		cloudProviderRuleModel.setRuleOptionTextEN(cloudProviderRule.getRuleOptionTextEN());
		return cloudProviderRuleModel;
	}
	
	/*
	 * SAVE PROVIDERS TO THE DATABASE WHICH ACCEPTS LIST OF PROVIDERMODEL AND CHECK 
	 * IF PREVIOUSLY ANY RULE IS PRESENT IN THE RULE TABLE AND IF NOT PRESENT IT WILL SAVE 
	 * THE LIST TO THE DATA BASE AND IF ALREADY SOME ARE PRESENT THEN 1ST MOVE THEM TO
	 * THE HISTORY TABLE THEN SAVE THE RULES TO THE DATABASE
	 * 
	 */

	public boolean saveProviderRule(List<DTProviderRuleModel> cloudProviderRuleModel) throws SystemExceptions {
		int countOfHistoryRule = getCountOfProviderRuleHistoryRule();
		List<DTProviderRule> cloudProviderRuleList = getProviderRules();
		if (countOfHistoryRule != 0 || getCountOfProviderRule() != 0) {
			saveProviderRuleHistory(cloudProviderRuleList);
		}
		cloudProviderRuleRepository.deleteAll();
		return saveDTCloudProviderRule(cloudProviderRuleModel);
	}
	
	/*
	 * GET HOW MANY PROVIDERS ARE PRESENT IN THE HISTORY TABLE 
	 * 
	 */
	
	public int getCountOfProviderRuleHistoryRule() throws SystemExceptions {
			int count = 0;
			try {
				count = ProviderRuleHistory.findAll().size();
			} catch (Exception e) {
				throw new SystemExceptions("getCountOfProviderRuleHistoryRule()");
			}
		return count;
	}
	
	/*
	 * GET ALL PROVIDERS PRESENT IN BATABSE IN PROVIDER RULE TABLE
	 * 
	 */

	
	private List<DTProviderRule> getProviderRules() {

		return cloudProviderRuleRepository.findAll();
	}
	
	/*
	 * GET HOW MANY PROVIDERS ARE PRESENT IN BATABSE IN PROVIDER RULE TABLE
	 * 
	 */

	
	public int getCountOfProviderRule() {

		return cloudProviderRuleRepository.findAll().size();
	}
	
	/*
	 * MOVE ALL THE PROVIDERS PRESENT IN THE PROVIDERS HISTORY TABLE 
	 * ADD EACH PROVIDERS TO PROVIDERS HISTORY TABLE AND THEN ADD TO THE PROVIDER HISTORY
	 * 
	 */


	private void saveProviderRuleHistory(List<DTProviderRule> cloudProviderRule) {
		List<DTProviderRuleHistory> providerRuleHistory = new ArrayList<DTProviderRuleHistory>();
		for (DTProviderRule providerRule : cloudProviderRule) {
			providerRuleHistory.add(toProviderHistory(providerRule));
		}
		ProviderRuleHistory.saveAll(providerRuleHistory);
	}
	


	private DTProviderRuleHistory toProviderHistory(DTProviderRule providerRule) {
		Date date = new Date();
		DTProviderRuleHistory providerRuleHistory = new DTProviderRuleHistory();
		providerRuleHistory.setProviderId(providerRule.getProviderId());
		providerRuleHistory.setProviderRuleId(providerRule.getProviderRuleId());
		providerRuleHistory.setExecutionOrder(providerRule.getExecutionOrder());
		providerRuleHistory.setQuestionId(providerRule.getQuestionId());
		providerRuleHistory.setQuestionTextEN(providerRule.getRuleOptionIds());
		providerRuleHistory.setRuleOptionIds(providerRule.getRuleOptionTextEN());
		providerRuleHistory.setRuleOptionTextEN(providerRule.getRuleOptionTextEN());
		providerRuleHistory.setCreatedBy(providerRule.getCreatedBy());
		providerRuleHistory.setCreatedTime(providerRule.getCreatedTime());
		return providerRuleHistory;
	}



	public boolean saveDTCloudProviderRule(List<DTProviderRuleModel> cloudProviderRuleModel) {
		boolean saveResult = false;
		try {
			List<DTProviderRule> cloudProviderRule = new ArrayList<DTProviderRule>();
			List<DTProviderRule> cloudProvidersaved = cloudProviderRuleRepository
					.saveAll(toCloudProviderRuleList(cloudProviderRuleModel, cloudProviderRule));
			if (cloudProvidersaved != null) {
				saveResult = true;
			}
		} catch (Exception e) {

		}
		return saveResult;
	}

	private List<DTProviderRule> toCloudProviderRuleList(List<DTProviderRuleModel> cloudProviderRuleModel,
			List<DTProviderRule> cloudProviderRule) {
		for (DTProviderRuleModel providerRuleModel : cloudProviderRuleModel) {
			DTProviderRule providerRule = new DTProviderRule();
			cloudProviderRule.add(toCloudProviderRule(providerRuleModel, providerRule));
		}

		return cloudProviderRule;
	}
	
	

	private DTProviderRule toCloudProviderRule(DTProviderRuleModel cloudProviderRuleModel,
			DTProviderRule cloudProviderRule) {

		Date date = new Date();
		cloudProviderRule.setProviderId(cloudProviderRuleModel.getProviderId());
		cloudProviderRule.setExecutionOrder(cloudProviderRuleModel.getEvaluationOrder());
		cloudProviderRule.setQuestionId(cloudProviderRuleModel.getQuestionId());
		cloudProviderRule.setQuestiontextEN(cloudProviderRuleModel.getQuestiontextEN());
		cloudProviderRule.setRuleOptionIds(cloudProviderRuleModel.getRuleOptionIds());
		cloudProviderRule.setRuleOptionTextEN(cloudProviderRuleModel.getRuleOptionTextEN());
		cloudProviderRule.setCreatedBy("Admin");
		cloudProviderRule.setCreatedTime(date);
		// cloudProviderRule.setModifiedBy(modifiedBy);
		// cloudProviderRule.setModifiedTime(modifiedTime);
		return cloudProviderRule;
	}
	
	

	

}
