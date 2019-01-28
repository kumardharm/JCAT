package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.DTCloudableRuleDAO;
import com.cg.jcat.api.dao.DTCloudableRuleModel;
import com.cg.jcat.api.entity.DTCloudableRule;
import com.cg.jcat.api.exception.SystemExceptions;

@Component
public class DTCloudableRuleService implements IDTCloudableRuleService {

	@Autowired DTCloudableRuleDAO dTCloudableRuleDAO;
	@Override
	public List<DTCloudableRuleModel> getCloudableRule() {
		
		return dTCloudableRuleDAO.getCloudableRule();
	}
	@Override
	public DTCloudableRuleModel getCloudableRuleById(int cloudableRuleId) {
			return dTCloudableRuleDAO.getCloudableRuleById(cloudableRuleId);
	}
	@Override
	public boolean saveCloudableRule(List<DTCloudableRuleModel> dTCloudableRuleModelList) throws SystemExceptions {
		// TODO Auto-generated method stub
		return dTCloudableRuleDAO.saveCloudableRule(dTCloudableRuleModelList);
	}
	

	
}
