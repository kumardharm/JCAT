package com.cg.jcat.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jcat.api.dao.DTMigrationModel;
import com.cg.jcat.api.dao.DTMigrationRuleDao;
import com.cg.jcat.api.dao.DTMigrationRuleModel;
import com.cg.jcat.api.exception.JcatExceptions;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(
		  locations = "classpath:application-integrationtest.properties")
public class TestMigrationRuleService {
	
	@Autowired
	private DTMigrationRuleService dtMigrationRuleService;
	
	
	@MockBean
	private DTMigrationRuleDao dtMigrationRuleDao;
	
	
	@Test
	public void testGetMigrationPatter ()
	{
		List<DTMigrationModel> migrationRuleList = new ArrayList<>();
		migrationRuleList = dtMigrationRuleService.getMigrationPattern();
		assertNotNull(migrationRuleList);
	}
	
	@Test
	public void testSaveMigrationRule() throws JcatExceptions
	{
		List<DTMigrationRuleModel> migrationRuleList = new ArrayList<>();
		migrationRuleList.add(toGetMigrationRule());
		migrationRuleList.add(toGetMigrationRule());
		Mockito.when(dtMigrationRuleDao.saveDTMigrationRule(migrationRuleList)).thenReturn(true);
		assertEquals(true, dtMigrationRuleDao.saveDTMigrationRule(migrationRuleList));
		
	}
	
	@Test
//	@Ignore
	public void testMigrationRules() throws JcatExceptions
	{
		DTMigrationRuleModel migrationRuleModel = toGetMigrationRule();
		List<DTMigrationRuleModel> migrationRuleModels = new ArrayList<DTMigrationRuleModel>();
		migrationRuleModels.add(migrationRuleModel);
		Mockito.when(dtMigrationRuleDao.getMigrationRule(1)).thenReturn(migrationRuleModels);
		
		assertNotNull(dtMigrationRuleService.getMigrationRule(1));
		assertThat(dtMigrationRuleService.getMigrationRule(1)).isEqualTo(migrationRuleModels);
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
