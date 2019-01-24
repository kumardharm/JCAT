package com.cg.jcat.api.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jcat.api.exception.SystemExceptions;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@TestPropertySource(
		  locations = "classpath:application-integrationtest.properties")
public class TestMigrationRuleDao {
	
	@Autowired
	DTMigrationRuleDao dtMigrationRuleDao;
	
	@Test
	public void testGetMigrationPattern()
	{
		List<DTMigrationModel> migrationRuleList = new ArrayList<>();
		migrationRuleList = dtMigrationRuleDao.getMigrationPattern();
		assertNotNull(migrationRuleList);
	}
	
	
	@Test
	@Ignore
	public void testSaveQuestionOption() throws SystemExceptions {
		
		List<DTMigrationRuleModel> migrationRuleList = new ArrayList<>();
		migrationRuleList.add(toGetMigrationRule());
		migrationRuleList.add(toGetMigrationRule());
		assertEquals(true, dtMigrationRuleDao.saveDTMigrationRule(migrationRuleList)); // saving 2 migration rule
		assertEquals(2, dtMigrationRuleDao.toGetMigrationRule().size()); // count of row in migration rule should be 2 because 2 records are inserted
		assertEquals(0, dtMigrationRuleDao.getCountOfMigrationRuleHistoryRule()); // Initially no value in history table
		migrationRuleList.add(toGetMigrationRule());
		assertEquals(true, dtMigrationRuleDao.saveDTMigrationRule(migrationRuleList));
		assertEquals(3, dtMigrationRuleDao.toGetMigrationRule().size());
		assertEquals(2, dtMigrationRuleDao.getCountOfMigrationRuleHistoryRule());
	}
	
	@Test
	public void testGetMigrationRule() throws SystemExceptions
	{
		List<DTMigrationRuleModel> migrationRuleList = new ArrayList<>();
		migrationRuleList.add(toGetMigrationRule());
		assertEquals(true, dtMigrationRuleDao.saveDTMigrationRule(migrationRuleList));
		assertEquals(1,dtMigrationRuleDao.getMigrationRule(1).size());
		
		DTMigrationRuleModel dtMigrationRuleModel = toGetMigrationRule();
		dtMigrationRuleModel.setMigrationId(0);
		migrationRuleList.add(dtMigrationRuleModel);
		
		assertEquals(true, dtMigrationRuleDao.saveDTMigrationRule(migrationRuleList));
		assertEquals(1,dtMigrationRuleDao.getMigrationRule(1).size());
		assertEquals(2,dtMigrationRuleDao.toGetMigrationRule().size());
	}
	
	
	private DTMigrationRuleModel toGetMigrationRule() {

		DTMigrationRuleModel dtMigrationRuleModel = new DTMigrationRuleModel();
		dtMigrationRuleModel.setExecutionOrder(1);
		dtMigrationRuleModel.setMigrationId(1);
		dtMigrationRuleModel.setQuestionId(1);
		dtMigrationRuleModel.setQuestiontextEN("Eng");
		dtMigrationRuleModel.setRuleOptionIds("1,2,3,4");
		dtMigrationRuleModel.setRuleOptionTextEN("option1, option2, option3");
		return dtMigrationRuleModel;
	}

}
