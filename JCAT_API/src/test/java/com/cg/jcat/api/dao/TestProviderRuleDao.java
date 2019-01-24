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
import com.cg.jcat.api.exception.SystemExceptions;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class TestProviderRuleDao {

	@Autowired
	private DTProviderRuleDao ProviderRuleDao;

	@Test
	@Ignore
	public void testGetCloudProvider() {
		assertNotNull(ProviderRuleDao.getCloudProvider());
	}

	@Test
	@Ignore
	public void testGetCloudProviderRules() throws SystemExceptions {
		List<DTProviderRuleModel> cloudProviderRuleModelList = new ArrayList<DTProviderRuleModel>();
		cloudProviderRuleModelList.add(getcloudProviderRuleModel());
		cloudProviderRuleModelList.add(getcloudProviderRuleModel2());
		assertEquals(true, ProviderRuleDao.saveProviderRule(cloudProviderRuleModelList));
		assertNotNull(ProviderRuleDao.getCloudProviderRules(1));
		assertEquals(1, ProviderRuleDao.getCloudProviderRules(1).size());
		assertEquals(2, ProviderRuleDao.getCloudProviderRules(0).size());
	}

	@Test
	// @Ignore
	public void testSaveCloudProviderRule() throws SystemExceptions {
		List<DTProviderRuleModel> cloudProviderRuleModelList = new ArrayList<DTProviderRuleModel>();
		cloudProviderRuleModelList.add(getcloudProviderRuleModel());
		cloudProviderRuleModelList.add(getcloudProviderRuleModel2());
		assertEquals(true, ProviderRuleDao.saveProviderRule(cloudProviderRuleModelList));
		assertEquals(2, ProviderRuleDao.getCountOfProviderRule());
		// assertEquals(0,ProviderRuleDao.getCountOfProviderRuleHistoryRule());
		cloudProviderRuleModelList.add(getcloudProviderRuleModel2());
		assertEquals(true, ProviderRuleDao.saveProviderRule(cloudProviderRuleModelList));
		assertEquals(3, ProviderRuleDao.getCountOfProviderRule());
		// assertEquals(2,ProviderRuleDao.getCountOfProviderRuleHistoryRule());
		// assertEquals(true,cloudProviderRuleDao.saveCloudProviderRule(cloudProviderRuleModel));
	}

	private DTProviderRuleModel getcloudProviderRuleModel2() {
		DTProviderRuleModel cloudProviderRuleModel = new DTProviderRuleModel();
		cloudProviderRuleModel.setEvaluationOrder(1);
		cloudProviderRuleModel.setProviderId(2);
		cloudProviderRuleModel.setQuestionId(1);
		cloudProviderRuleModel.setQuestiontextEN("Question");
		cloudProviderRuleModel.setRuleOptionIds("1,2,3");
		cloudProviderRuleModel.setRuleOptionTextEN("Rule1,Rule2");
		return cloudProviderRuleModel;
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