package com.cg.jcat.api.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jcat.api.exception.JcatExceptions;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@TestPropertySource(
		  locations = "classpath:application-integrationtest.properties")
public class TestCloudProviderRuleDao {
	
	@Autowired
	private DTCloudProviderRuleDao cloudProviderRuleDao;

	@Test
	@Ignore
	 public void testGetCloudProvider()
	 {
		assertNotNull(cloudProviderRuleDao.getCloudProvider());
//		 assertEquals(0,cloudProviderRuleDao.getCloudProvider().size());
	 }
	
	@Test
	@Ignore
	public void testGetCloudProviderRules()
	{
		assertNotNull(cloudProviderRuleDao.getCloudProviderRules());
	}
	@Test
	@Ignore
	public void testSaveCloudProviderRule()
	{
		DTCloudProviderRuleModel cloudProviderRuleModel = getcloudProviderRuleModel();
		assertEquals(true,cloudProviderRuleDao.saveCloudProviderRule(cloudProviderRuleModel));
	}
	
	@Test
	public void updateCloudProviderRules() throws JcatExceptions
	{
		DTCloudProviderRuleModel cloudProviderRuleModel = getcloudProviderRuleModel();
		cloudProviderRuleModel.setProviderRuleId(1);
		cloudProviderRuleModel.setQuestiontextEN("Question Test");
		assertEquals(true,cloudProviderRuleDao.updateCloudProviderRules(cloudProviderRuleModel));
	}
	

	private DTCloudProviderRuleModel getcloudProviderRuleModel() {
		
		DTCloudProviderRuleModel cloudProviderRuleModel = new DTCloudProviderRuleModel();
		cloudProviderRuleModel.setEvaluationOrder(1);
		cloudProviderRuleModel.setProviderId(1);
		cloudProviderRuleModel.setQuestionId(1);
		cloudProviderRuleModel.setQuestiontextEN("Question");
		cloudProviderRuleModel.setRuleOptionIds("1,2,3");
		cloudProviderRuleModel.setRuleOptionTextEN("Rule1,Rule2");
		return cloudProviderRuleModel;
	}
	
}
