package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.DTCloudableRuleDAO;
import com.cg.jcat.api.dao.DTCloudableRuleModel;
import com.cg.jcat.api.entity.DTCloudableRule;

@Component
public class DTCloudableRuleService implements IDTCloudableRuleService {

	@Autowired DTCloudableRuleDAO dTCloudableRuleDAO;
	@Override
	public List<DTCloudableRuleModel> getCloudableRule() {
		
		return dTCloudableRuleDAO.getCloudableRule();
	}
	@Override
	public boolean saveCloudableRule(DTCloudableRuleModel dTCloudableRuleModel) {
		return dTCloudableRuleDAO.saveCloudableRule(dTCloudableRuleModel);
	}
	@Override
	public boolean updateCloudablerule(DTCloudableRuleModel dTCloudableRuleModel) {
		return dTCloudableRuleDAO.updateCloudablerule(dTCloudableRuleModel);
	}
	@Override
	public boolean deleteCloudableRule(int cloudabelRuleId) {
		
		return dTCloudableRuleDAO.deleteCloudableRule(cloudabelRuleId);
	}
}
