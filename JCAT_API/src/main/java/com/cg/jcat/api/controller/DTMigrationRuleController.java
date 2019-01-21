package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.DTMigrationRuleModel;
import com.cg.jcat.api.exception.JcatExceptions;
import com.cg.jcat.api.service.IDTMigrationRuleService;

@Component
public class DTMigrationRuleController implements IDTMigrationRuleController{
	
	@Autowired
	IDTMigrationRuleService dtMigrationRuleService;
	
	@Override
	public List<DTMigrationRuleModel> getMigrationRule() {
		try {
			return dtMigrationRuleService.getMigrationRule();
		} catch (JcatExceptions e) {
			System.out.println("Error in getting users" + e);
			return null;
		}
	}

	@Override
	public void saveMigrationRule(DTMigrationRuleModel dtMigrationRuleModel) {
		try {
			dtMigrationRuleService.saveMigrationRule(dtMigrationRuleModel);
		} catch (JcatExceptions e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateMigrationRule(DTMigrationRuleModel dtMigrationRuleModel) {
		try {
			dtMigrationRuleService.updateMigrationRule(dtMigrationRuleModel);
		} catch (JcatExceptions e) {
			e.printStackTrace();
		}
	}

}
