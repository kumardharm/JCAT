package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.DTMigrationRuleDao;
import com.cg.jcat.api.dao.DTMigrationRuleModel;
import com.cg.jcat.api.exception.JcatExceptions;

@Component
public class DTMigrationRuleService implements IDTMigrationRuleService{
	
	@Autowired
	DTMigrationRuleDao dtMigrationRuleDao;

	@Override
	public List<DTMigrationRuleModel> getMigrationRule() throws JcatExceptions {
		return dtMigrationRuleDao.getMigrationRule();
	}

	@Override
	public boolean saveMigrationRule(DTMigrationRuleModel dtMigrationRuleModel) throws JcatExceptions {
		return dtMigrationRuleDao.saveDTMigrationRule(dtMigrationRuleModel);
	}

	@Override
	public boolean updateMigrationRule(DTMigrationRuleModel dtMigrationRuleModel) throws JcatExceptions {
		// TODO Auto-generated method stub
		return dtMigrationRuleDao.updateMigrationRule(dtMigrationRuleModel);
	}

}
