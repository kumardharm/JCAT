package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.jcat.api.dao.DTMigrationRuleModel;
import com.cg.jcat.api.exception.JcatExceptions;

@Service
public interface IDTMigrationRuleService {
	
	public List<DTMigrationRuleModel> getMigrationRule() throws JcatExceptions;
	
	public boolean saveMigrationRule(DTMigrationRuleModel dtMigrationRuleModel)  throws JcatExceptions;
	
	public boolean updateMigrationRule(DTMigrationRuleModel dtMigrationRuleModel) throws JcatExceptions;

}
