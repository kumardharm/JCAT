package com.cg.jcat.api.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.entity.AssessmentQuestion;
import com.cg.jcat.api.entity.DTCloudableRule;
import com.cg.jcat.api.entity.DTCloudableRuleHistory;
import com.cg.jcat.api.repository.IAssessmentQuestionRepository;
import com.cg.jcat.api.repository.IDTCloudableRuleHistoryRepository;
import com.cg.jcat.api.repository.IDTCloudableRuleRepository;
@Component
public class DTCloudableRuleDAO {

	@Autowired
	IDTCloudableRuleRepository dtCloudableRuleRepository;
	@Autowired
	IDTCloudableRuleHistoryRepository  cloudableRuleHistoryRepository;
	@Autowired
	IAssessmentQuestionRepository assessmentQuestionRepository;
	
	public List<DTCloudableRuleModel> getCloudableRule() {
		List<DTCloudableRule> dTCloudableRuleList=new ArrayList<DTCloudableRule>();
		 dTCloudableRuleList=dtCloudableRuleRepository.findAll();
		 List<DTCloudableRuleModel> DTCloudableRuleModelList=new ArrayList<DTCloudableRuleModel>();
		 		return getCloudableModelRule(dTCloudableRuleList,DTCloudableRuleModelList);
	}

	private List<DTCloudableRuleModel> getCloudableModelRule(List<DTCloudableRule> dTCloudableRuleList,
			List<DTCloudableRuleModel> dTCloudableRuleModelList) {
		     for(DTCloudableRule dTCloudableRule:dTCloudableRuleList ) {
		    	 dTCloudableRuleModelList.add(toDTCloudableRuleModel(dTCloudableRule));
		     }
		return dTCloudableRuleModelList;
	}

	private DTCloudableRuleModel toDTCloudableRuleModel(DTCloudableRule dTCloudableRule) {
		DTCloudableRuleModel dTCloudableRuleModel=new DTCloudableRuleModel();
		dTCloudableRuleModel.setCloudableRuleId(dTCloudableRule.getCloudableRuleId());
		dTCloudableRuleModel.setOptionIds(dTCloudableRule.getOptionIds());
		dTCloudableRuleModel.setExecutionOrder(dTCloudableRule.getExecutionOrder());
		dTCloudableRuleModel.setOptionTextsEN(dTCloudableRule.getOptionTextsEN());
		dTCloudableRuleModel.setQuestionTextEN(dTCloudableRule.getQuestionTextEN());
		dTCloudableRuleModel.setQuestionId(dTCloudableRule.getAssessmentQuestion().getQuestionId());
		return dTCloudableRuleModel;
	}

		private DTCloudableRule toCloudablerule(DTCloudableRuleModel dTCloudableRuleModel) {
			Optional<AssessmentQuestion> assessmentQuestionOptional=assessmentQuestionRepository.findById(dTCloudableRuleModel.getQuestionId());
			AssessmentQuestion assessmentQuestion=assessmentQuestionOptional.get();
		DTCloudableRule dTCloudableRule=new DTCloudableRule();
		dTCloudableRule.setCloudableRuleId(dTCloudableRuleModel.getCloudableRuleId());
		dTCloudableRule.setOptionIds(dTCloudableRuleModel.getOptionIds());
		dTCloudableRule.setOptionTextsEN(dTCloudableRuleModel.getOptionTextsEN());
		//System.out.println(assessmentQuestionRepository.findById(1));
	dTCloudableRule.setAssessmentQuestion(assessmentQuestion);
		//dTCloudableRule.setQuestionId(dTCloudableRuleModel.getQuestionId());
		dTCloudableRule.setQuestionTextEN(dTCloudableRuleModel.getQuestionTextEN());
		dTCloudableRule.setExecutionOrder(dTCloudableRuleModel.getExecutionOrder());
		dTCloudableRule.setCreatedBy("user1");
		dTCloudableRule.setCreatedTime(new Date());
		return dTCloudableRule;
	}

	private DTCloudableRule findByCloudableRuleId(int cloudableRuleId) {
			return dtCloudableRuleRepository.findByCloudableRuleId(cloudableRuleId);
	}

	public DTCloudableRuleModel getCloudableRuleById(int cloudableRuleId) {
				return getCloudableRuleModelbyId(cloudableRuleId);
	}

	private DTCloudableRuleModel getCloudableRuleModelbyId(int cloudableRuleId) {
		
		return toDTCloudableRuleModel(findByCloudableRuleId(cloudableRuleId));
	}

	public boolean saveCloudableRule(List<DTCloudableRuleModel> dTCloudableRuleModelList) {
			return toSaveCloudablerule(dTCloudableRuleModelList);
	}

	private boolean toSaveCloudablerule(List<DTCloudableRuleModel> dTCloudableRuleModelList) {
		int cloudabeRuleLength=0;
		cloudabeRuleLength=dtCloudableRuleRepository.findAll().size();
		if(cloudabeRuleLength!=0)
		{
			saveCloudableRuleHistory();
			dtCloudableRuleRepository.deleteAll();
			//saveCloudableRuleList(dTCloudableRuleModelList);
		}else {
			saveCloudableRuleList(dTCloudableRuleModelList);
		}
		return false;
	}

	private void saveCloudableRuleList(List<DTCloudableRuleModel> dTCloudableRuleModelList) {
	 List<DTCloudableRule> dtCloudableRuleList=new ArrayList<DTCloudableRule>();
	 for(DTCloudableRuleModel cloudableRuleModel:dTCloudableRuleModelList) {
		 dtCloudableRuleList.add(toCloudablerule(cloudableRuleModel));
	 }
	 dtCloudableRuleRepository.saveAll(dtCloudableRuleList);
	}

	private void saveCloudableRuleHistory() {
		List<DTCloudableRule> dtCloudableRuleList=new ArrayList<DTCloudableRule>();
		List<DTCloudableRuleHistory> dtCloudableRuleHistoryList=new ArrayList<DTCloudableRuleHistory>();
		dtCloudableRuleList=dtCloudableRuleRepository.findAll();
		for(DTCloudableRule cloudableRule:dtCloudableRuleList) {
			dtCloudableRuleHistoryList.add(toCloudableRuleHistory(cloudableRule));
			cloudableRuleHistoryRepository.save(toCloudableRuleHistory(cloudableRule));
		}
		System.out.println(dtCloudableRuleHistoryList);
		cloudableRuleHistoryRepository.saveAll(dtCloudableRuleHistoryList);
	}

	private DTCloudableRuleHistory toCloudableRuleHistory(DTCloudableRule cloudableRule) {
		Date date=new Date();
		DTCloudableRuleHistory dtCloudableRuleHistory=new DTCloudableRuleHistory();
		
		dtCloudableRuleHistory.setCloudableRuleId(cloudableRule.getCloudableRuleId());
		dtCloudableRuleHistory.setAssessmentQuestion(cloudableRule.getAssessmentQuestion());
		dtCloudableRuleHistory.setQuestiontTextEN(cloudableRule.getQuestionTextEN());
		dtCloudableRuleHistory.setRuleOptionIds(cloudableRule.getOptionIds());
		dtCloudableRuleHistory.setRuleOptionTextEN(cloudableRule.getOptionTextsEN());
		dtCloudableRuleHistory.setExecutionOrder(cloudableRule.getExecutionOrder());
		dtCloudableRuleHistory.setCreatedBy("Admin");
		return dtCloudableRuleHistory;
	}

	}
