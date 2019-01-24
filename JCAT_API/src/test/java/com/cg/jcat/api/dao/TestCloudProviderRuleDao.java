/*package com.cg.jcat.api.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

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
	private DTProviderRuleDao ProviderRuleDao;

	@Test
	@Ignore
	 public void testGetCloudProvider()
	 {
		assertNotNull(ProviderRuleDao.getCloudProvider());
//		 assertEquals(0,cloudProviderRuleDao.getCloudProvider().size());
	 }
	
	@Test
	@Ignore
	public void testGetCloudProviderRules()
	{
		assertNotNull(ProviderRuleDao.getCloudProviderRules());
	}
	@Test
//	@Ignore
	public void testSaveCloudProviderRule()
	{
		List<DTProviderRuleModel> cloudProviderRuleModelList = new ArrayList<DTProviderRuleModel>();
		cloudProviderRuleModelList.add(getcloudProviderRuleModel());
		assertEquals(true, ProviderRuleDao.saveProviderRule(cloudProviderRuleModelList));
		assertEquals(1,ProviderRuleDao.getCountOfProviderRule());
		assertEquals(0,ProviderRuleDao.getCountOfProviderRuleHistoryRule());
		assertEquals(true, ProviderRuleDao.saveProviderRule(cloudProviderRuleModelList));
		assertEquals(1,ProviderRuleDao.getCountOfProviderRule());
		assertEquals(1,ProviderRuleDao.getCountOfProviderRuleHistoryRule());
//		assertEquals(true,cloudProviderRuleDao.saveCloudProviderRule(cloudProviderRuleModel));
	}

	private DTProviderRuleModel getcloudProviderRuleModel() {
		
		DTProviderRuleModel cloudProviderRuleModel = new DTProviderRuleModel();
		cloudProviderRuleModel.setEvaluationOrder(1);
		cloudProviderRuleModel.setProviderId(1);
		cloudProviderRuleModel.setQuestionId(1);
		cloudProviderRuleModel.setQuestiontextEN("Question");
		cloudProviderRuleModel.setRuleOptionIds("1,2,3");
		cloudProviderRuleModel.setRuleOptionTextEN("Rule1,Rule2");
		return cloudProviderRuleModel;
	}
	
}
*/