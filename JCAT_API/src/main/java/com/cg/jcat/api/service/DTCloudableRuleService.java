package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.DTCloudableRuleDao;
import com.cg.jcat.api.dao.DTCloudableRuleModel;
<<<<<<< HEAD
=======
import com.cg.jcat.api.entity.DTCloudableRule;
import com.cg.jcat.api.exception.SystemExceptions;
>>>>>>> refs/remotes/origin/master

@Component
public class DTCloudableRuleService implements IDTCloudableRuleService {

	@Autowired DTCloudableRuleDao dTCloudableRuleDAO;
	@Override
	public List<DTCloudableRuleModel> getCloudableRule() {
		
		return dTCloudableRuleDAO.getCloudableRule();
	}
	@Override
	public DTCloudableRuleModel getCloudableRuleById(int cloudableRuleId) {
		return dTCloudableRuleDAO.getCloudableRuleById(cloudableRuleId);
	}
	@Override
<<<<<<< HEAD
	public boolean saveCloudableRule(List<DTCloudableRuleModel> dTCloudableRuleModelList) {
=======
	public boolean saveCloudableRule(List<DTCloudableRuleModel> dTCloudableRuleModelList) throws SystemExceptions {
		// TODO Auto-generated method stub
>>>>>>> refs/remotes/origin/master
		return dTCloudableRuleDAO.saveCloudableRule(dTCloudableRuleModelList);
	}
	

	
}
