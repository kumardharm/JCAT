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
	public boolean saveCloudableRule(DTCloudableRuleModel dTCloudableRuleModel) {
			return iDTCloudableRuleService.saveCloudableRule(dTCloudableRuleModel);
	}

	@Override
	public boolean updateCloudablerule(DTCloudableRuleModel dTCloudableRuleModel) {
		return iDTCloudableRuleService.updateCloudablerule(dTCloudableRuleModel);
	}

	@Override
	public boolean deleteCloudableRule(int cloudabelRuleId) {
		System.out.println(cloudabelRuleId+"************************");
		return iDTCloudableRuleService.deleteCloudableRule(cloudabelRuleId);
	}

}
