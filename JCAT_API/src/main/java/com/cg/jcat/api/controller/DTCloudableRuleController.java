package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.DTCloudableRuleModel;
import com.cg.jcat.api.entity.DTCloudableRule;
import com.cg.jcat.api.service.IDTCloudableRuleService;

@Component
public class DTCloudableRuleController implements IDTCloudableRuleController {

	@Autowired IDTCloudableRuleService iDTCloudableRuleService;
	 
	@Override
	public List<DTCloudableRuleModel> getCloudableRule() {
		
		return iDTCloudableRuleService.getCloudableRule();
	}

	@Override
	public DTCloudableRuleModel getCloudableRuleById(int cloudableRuleId) {
		
		return iDTCloudableRuleService.getCloudableRuleById(cloudableRuleId);
	}

	@Override
	public boolean saveCloudableRule(List<DTCloudableRuleModel> dTCloudableRuleModelList) {
		
		return iDTCloudableRuleService.saveCloudableRule(dTCloudableRuleModelList);
	}
	
	

}
