package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.DTMigrationModel;
import com.cg.jcat.api.dao.DTMigrationRuleDao;
import com.cg.jcat.api.dao.DTMigrationRuleModel;
import com.cg.jcat.api.exception.JcatExceptions;
import com.cg.jcat.api.exception.SystemExceptions;

@Component
public class DTMigrationRuleService implements IDTMigrationRuleService{
	
	@Autowired
	DTMigrationRuleDao dtMigrationRuleDao;

	@Override
	public List<DTMigrationRuleModel> getMigrationRule() throws JcatExceptions {
		return dtMigrationRuleDao.getMigrationRule();
	}

	@Override
	public boolean saveMigrationRule(List<DTMigrationRuleModel> dtMigrationRuleModels) throws SystemExceptions {
		int count = 0;
		for(DTMigrationRuleModel cloudProviderRuleModel : dtMigrationRuleModels)
		{
			if(cloudProviderRuleModel.getRuleOptionTextEN() != null)
			{
				String optionText[] = cloudProviderRuleModel.getRuleOptionTextEN().split(",");
				String optionIds[] = cloudProviderRuleModel.getRuleOptionIds().split(",");
				if(optionText.length==optionIds.length)
				{
					count++;
				}
			}
		}
		if(count == dtMigrationRuleModels.size())
		{
			return dtMigrationRuleDao.saveDTMigrationRule(dtMigrationRuleModels);
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public List<DTMigrationModel> getMigrationPattern() {
		// TODO Auto-generated method stub
		return dtMigrationRuleDao.getMigrationPattern();
	}

}
