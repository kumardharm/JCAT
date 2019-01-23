package com.cg.jcat.api.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jcat.api.repository.IDTMigrationRuleHistoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@TestPropertySource(
		  locations = "classpath:application-integrationtest.properties")
public class TestMigrationRuleDao {
	
	@Autowired
	DTMigrationRuleDao dtMigrationRuleDao;
	
	@Autowired
	IDTMigrationRuleHistoryRepository dtMigrationRuleHistoryRepository;
	
	
	@Test
	public void testSaveQuestionOption() {
		
		List<DTMigrationRuleModel> migrationRuleList = new ArrayList<>();
		migrationRuleList.add(toGetMigrationRule());
		migrationRuleList.add(toGetMigrationRule());
		assertEquals(true, dtMigrationRuleDao.saveDTMigrationRule(migrationRuleList)); // saving 2 migration rule
		assertEquals(2, dtMigrationRuleDao.getMigrationRule().size()); // count of row in migration rule should be 2 because 2 records are inserted
		assertEquals(0, dtMigrationRuleDao.getCountOfMigrationRuleHistoryRule()); // Initially no value in history table
		migrationRuleList.add(toGetMigrationRule());
		assertEquals(true, dtMigrationRuleDao.saveDTMigrationRule(migrationRuleList));
		assertEquals(3, dtMigrationRuleDao.getMigrationRule().size());
		assertEquals(2, dtMigrationRuleDao.getCountOfMigrationRuleHistoryRule());
	}
	
	
	private DTMigrationRuleModel toGetMigrationRule() {

		DTMigrationRuleModel dtMigrationRuleModel = new DTMigrationRuleModel();
		dtMigrationRuleModel.setEvaluationOrder(1);
		dtMigrationRuleModel.setMigrationId(1);
		dtMigrationRuleModel.setQuestionId(1);
		dtMigrationRuleModel.setQuestiontextEN("Eng");
		dtMigrationRuleModel.setRuleOptionIds("1,2,3,4");
		dtMigrationRuleModel.setRuleOptionTextEN("option1, option2, option3");
		return dtMigrationRuleModel;
	}

}
