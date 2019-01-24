/*package com.cg.jcat.api.dao;

import static org.junit.Assert.*;

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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@TestPropertySource(
		  locations = "classpath:application-integrationtest.properties")
public class TestDTCloudableRule {
	@Autowired
	DTCloudableRuleDAO dTCloudableRuleDAO; 

	
	public DTCloudableRuleModel getCloudableRuleModel() {
		DTCloudableRuleModel dTCloudableRuleModel=new DTCloudableRuleModel();
		dTCloudableRuleModel.setCloudableRuleId(5);
		dTCloudableRuleModel.setOptionIds("1");
		dTCloudableRuleModel.setOptionTextsEN("Yes");
		dTCloudableRuleModel.setQuestionId(1);
		dTCloudableRuleModel.setQuestionTextEN("Question Text");
		dTCloudableRuleModel.setExecutionOrder(1);
		return dTCloudableRuleModel;
	}
	@Test
	@Ignore
	public void testGetCloudableRule() {
		List<DTCloudableRuleModel> dtCloudableRuleModelList=new ArrayList<DTCloudableRuleModel>();
		
		dTCloudableRuleDAO.saveCloudableRule();
		assertEquals(1,dTCloudableRuleDAO.getCloudableRule().size());
	}
	
	@Test
	@Ignore
	public void  testSaveCloudableRule() {
		DTCloudableRuleModel dTCloudableRuleModel=new DTCloudableRuleModel();
		dTCloudableRuleModel=getCloudableRuleModel();
		boolean rule=dTCloudableRuleDAO.saveCloudableRule(dTCloudableRuleModel);
		assertEquals(true, rule);
	}
	
	@Test
	//@Ignore
	public void updateCloudableRule()
	{
		DTCloudableRuleModel dTCloudableRuleModel=new DTCloudableRuleModel();
		dTCloudableRuleModel=getCloudableRuleModel();
		dTCloudableRuleModel.setExecutionOrder(3);
		assertEquals(true, dTCloudableRuleDAO.updateCloudablerule(dTCloudableRuleModel));
	}
	

}
*/