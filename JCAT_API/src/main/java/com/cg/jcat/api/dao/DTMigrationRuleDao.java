	package com.cg.jcat.api.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.entity.DTMigrationRule;
import com.cg.jcat.api.exception.ExceptionMessages;
import com.cg.jcat.api.repository.IDTMigrationRepository;
import com.cg.jcat.api.repository.IDTMigrationRuleRepository;

@Component
public class DTMigrationRuleDao {
	
	@Autowired
	IDTMigrationRuleRepository dtMigrationRuleRepository;
	
	@Autowired
	IDTMigrationRepository dtMigrationRepository;
	
	public List<DTMigrationRuleModel> getMigrationRule(){
		List<DTMigrationRuleModel> dtMigrationRuleModelIST=new ArrayList<DTMigrationRuleModel>();
		List<DTMigrationRule> dtMigrationRuleLIST=dtMigrationRuleRepository.findAll();
		return toGetMigrationRule(dtMigrationRuleLIST,dtMigrationRuleModelIST);
	}
	
	public List<DTMigrationRuleModel> toGetMigrationRule(List<DTMigrationRule> dtMigrationRuleLIST,List<DTMigrationRuleModel> dtMigrationRuleModelIST){
		
		for(DTMigrationRule assessmentQuestion:dtMigrationRuleLIST)
		{
			dtMigrationRuleModelIST.add(toGetMigrationRuleModel(assessmentQuestion));
		}
		return dtMigrationRuleModelIST;
	}
	
	public boolean saveMigrationRule(DTMigrationRuleModel dtMigrationRuleModel) {
		try {
			return saveDTMigrationRule(dtMigrationRuleModel);
		}catch (Exception e) {
			System.out.print(ExceptionMessages.SaveUsersToDB + e);
			return false;
		}
	}

	public boolean saveDTMigrationRule(DTMigrationRuleModel dtMigrationRuleModel) {
		boolean saveResult = false;
		saveResult= dtMigrationRuleRepository.save(toGetMigrationRule(dtMigrationRuleModel)) != null;
		return  saveResult;
	}
	
	public boolean updateMigrationRule(DTMigrationRuleModel dtMigrationRuleModel) {
		System.out.println(dtMigrationRuleModel);
		boolean updateResult = false;
		updateResult = dtMigrationRuleRepository.saveAndFlush(toGetMigrationRule(dtMigrationRuleModel)) != null;
		System.out.println(updateResult);
		return updateResult;
	}
	
	public DTMigrationRuleModel toGetMigrationRuleModel(DTMigrationRule dtMigrationRule)
	{
		DTMigrationRuleModel dtMigrationRuleModel = new DTMigrationRuleModel();
		dtMigrationRuleModel.setEvaluationOrder(dtMigrationRule.getEvaluationOrder());
		dtMigrationRuleModel.setMigrationId(dtMigrationRule.getMigrationId());
		dtMigrationRuleModel.setMigrationRuleId(dtMigrationRule.getMigrationRuleId());
		dtMigrationRuleModel.setQuestionId(dtMigrationRule.getQuestionId());
		dtMigrationRuleModel.setQuestiontextEN(dtMigrationRule.getRuleOptionTextEN());
		dtMigrationRuleModel.setRuleOptionIds(dtMigrationRule.getRuleOptionIds());
		dtMigrationRuleModel.setRuleOptionTextEN(dtMigrationRule.getRuleOptionTextEN());
		return dtMigrationRuleModel;
	}

	public DTMigrationRule toGetMigrationRule(DTMigrationRuleModel dtMigrationRuleModel)
	{
		Date date=new Date();
		System.out.println(dtMigrationRuleModel);
		DTMigrationRule dtMigrationRule = new DTMigrationRule();
		dtMigrationRule.setEvaluationOrder(dtMigrationRuleModel.getEvaluationOrder());
		dtMigrationRule.setMigrationId(dtMigrationRuleModel.getMigrationId());
		dtMigrationRule.setMigrationRuleId(dtMigrationRuleModel.getMigrationRuleId());
		dtMigrationRule.setQuestionId(dtMigrationRuleModel.getQuestionId());
		dtMigrationRule.setQuestiontextEN(dtMigrationRuleModel.getQuestiontextEN());
		dtMigrationRule.setRuleOptionIds(dtMigrationRuleModel.getRuleOptionIds());
		dtMigrationRule.setRuleOptionTextEN(dtMigrationRuleModel.getRuleOptionTextEN());
		dtMigrationRule.setCreatedBy("Admin");
		dtMigrationRule.setCreatedTtime(date);
		return dtMigrationRule;
	}
}
