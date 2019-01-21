package com.cg.jcat.api.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.entity.DTCloudableRule;
import com.cg.jcat.api.repository.IDTCloudableRuleRepository;
@Component
public class DTCloudableRuleDAO {

	@Autowired IDTCloudableRuleRepository iDTCloudableRuleRepository;
	
	public List<DTCloudableRuleModel> getCloudableRule() {
		List<DTCloudableRule> dTCloudableRuleList=new ArrayList<DTCloudableRule>();
		 dTCloudableRuleList=iDTCloudableRuleRepository.findAll();
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
		dTCloudableRuleModel.setQuestionId(dTCloudableRule.getQuestionId());
		dTCloudableRuleModel.setExecutionOrder(dTCloudableRule.getExecutionOrder());
		dTCloudableRuleModel.setOptionTextsEN(dTCloudableRule.getOptionTextsEN());
		dTCloudableRuleModel.setQuestionTextEN(dTCloudableRule.getQuestionTextEN());
		return dTCloudableRuleModel;
	}

	public boolean saveCloudableRule(DTCloudableRuleModel dTCloudableRuleModel) {
			return toSaveCloudableRule(dTCloudableRuleModel);
	}
	private boolean toSaveCloudableRule(DTCloudableRuleModel dTCloudableRuleModel) {
		return iDTCloudableRuleRepository.save(toCloudablerule(dTCloudableRuleModel)) != null;
		
	}
	private DTCloudableRule toCloudablerule(DTCloudableRuleModel dTCloudableRuleModel) {
		DTCloudableRule dTCloudableRule=new DTCloudableRule();
		dTCloudableRule.setCloudableRuleId(dTCloudableRuleModel.getCloudableRuleId());
		dTCloudableRule.setOptionIds(dTCloudableRuleModel.getOptionIds());
		dTCloudableRule.setOptionTextsEN(dTCloudableRuleModel.getOptionTextsEN());
		dTCloudableRule.setQuestionId(dTCloudableRuleModel.getQuestionId());
		dTCloudableRule.setQuestionTextEN(dTCloudableRuleModel.getQuestionTextEN());
		dTCloudableRule.setExecutionOrder(dTCloudableRuleModel.getExecutionOrder());
		dTCloudableRule.setCreatedBy("user1");
		dTCloudableRule.setCreatedTime(new Date());
		return dTCloudableRule;
	}

	

	public boolean updateCloudablerule(DTCloudableRuleModel dTCloudableRuleModel) {
		
		return toUpdateCloudableRule(dTCloudableRuleModel);
	}

	private boolean toUpdateCloudableRule(DTCloudableRuleModel dTCloudableRuleModel) {
		return iDTCloudableRuleRepository.saveAndFlush(toCloudablerule(dTCloudableRuleModel)) != null;
	}

	public boolean deleteCloudableRule(int cloudabelRuleId) {
				return deleteCloudableRuleById(cloudabelRuleId);
	}

	private boolean deleteCloudableRuleById(int cloudabelRuleId) {
		DTCloudableRule dTCloudableRule=findByCloudableRuleId(cloudabelRuleId);
		dTCloudableRule.setDelete(true);
		return iDTCloudableRuleRepository.save(dTCloudableRule) != null;
	}

	private DTCloudableRule findByCloudableRuleId(int cloudabelRuleId) {
		// TODO Auto-generated method stub
		return iDTCloudableRuleRepository.findByCloudableRuleId(cloudabelRuleId);
	}

	}
