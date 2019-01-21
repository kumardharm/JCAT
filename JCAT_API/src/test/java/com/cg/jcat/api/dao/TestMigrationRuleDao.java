package com.cg.jcat.api.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@TestPropertySource(
		  locations = "classpath:application-integrationtest.properties")
public class TestMigrationRuleDao {
	
	@Autowired
	DTMigrationRuleDao dtMigrationRuleDao;
	
	@Test
	@Ignore
	public void testSaveQuestionOption() {
		DTMigrationRuleModel dtMigrationRuleModel = toGetMigrationRule();
		assertEquals(true, dtMigrationRuleDao.saveDTMigrationRule(dtMigrationRuleModel));
	}
	
	@Test
	public void getQuestionOption() {
		
		DTMigrationRuleModel dtMigrationRuleModel = toGetMigrationRule();
		assertEquals(true, dtMigrationRuleDao.saveMigrationRule(dtMigrationRuleModel));
	}
	
	@Test
	public void getUpdateQuestionOption()
	{
		DTMigrationRuleModel dtMigrationRuleModel = toGetMigrationRule();
		dtMigrationRuleModel.setQuestiontextEN("new text");
		assertEquals(true, dtMigrationRuleDao.updateMigrationRule(dtMigrationRuleModel));
	}
	
	private DTMigrationRuleModel toGetMigrationRule() {

		DTMigrationRuleModel dtMigrationRuleModel = new DTMigrationRuleModel();
		dtMigrationRuleModel.setEvaluationOrder(1);
		dtMigrationRuleModel.setMigrationId(1);
		dtMigrationRuleModel.setMigrationRuleId(1);
		dtMigrationRuleModel.setQuestionId(1);
		dtMigrationRuleModel.setQuestiontextEN("Eng");
		dtMigrationRuleModel.setRuleOptionIds(1);
		dtMigrationRuleModel.setRuleOptionTextEN("op text");
		return dtMigrationRuleModel;
	}

}
