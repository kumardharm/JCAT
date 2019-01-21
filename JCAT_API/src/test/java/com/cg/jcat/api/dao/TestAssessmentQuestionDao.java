package com.cg.jcat.api.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jcat.api.entity.AssessmentQuestion;
import com.cg.jcat.api.entity.QuestionTypeEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@TestPropertySource(
		  locations = "classpath:application-integrationtest.properties")
public class TestAssessmentQuestionDao {
	
	@Autowired
	AssessmentQuestionDao assessmentQuestionDao;
	
	@Test
	//@Ignore
	public void testSaveQuestions()
	{
		boolean result = false;
		AssessmentQuestionModel assessmentQuestionModel = getAssessmentQuestions();
		
		result = assessmentQuestionDao.saveQuestions(assessmentQuestionModel);
		assertEquals(true, result);
		
		//AssessmentQuestionModel found = assessmentQuestionDao.findByQuestionTextEn(assessmentQuestionModel.getQuestionTextEN());
//		assertNotNull(found);
//		
//		assertThat(found.getNumberOfOptions()).isEqualTo(assessmentQuestionModel.getNumberOfOptions());
//		assertThat(found.getCreatedBy()).isEqualTo(assessmentQuestionModel.getCreatedBy());
	}
	
	@Test
	@Ignore
	public void testGetQuestions()
	{
		//AssessmentQuestionModel assessmentQuestionModel = getAssessmentQuestions();
		AssessmentQuestionModel assessmentQuestionModel = new AssessmentQuestionModel();
		assessmentQuestionModel.setAssessmentTypeForCloudable(true);
		assessmentQuestionModel.setAssessmentTypeForCloudProvider(false);
		assessmentQuestionModel.setAssessmentTypeForMigration(false);
		assessmentQuestionModel.setCreatedBy("Admin");
		assessmentQuestionModel.setDeleted(false);
		assessmentQuestionModel.setDisplayOrder(1);
		assessmentQuestionModel.setModifiedBy("Admin");
		assessmentQuestionModel.setQuestionDescriptionEN("English");
		assessmentQuestionModel.setQuestionDescriptionLang2("German");
		assessmentQuestionModel.setQuestionId(1);
		assessmentQuestionModel.setQuestionTextEN("English");
		assessmentQuestionModel.setQuestionTextLang2("German");
		assessmentQuestionModel.setQuestionType(QuestionTypeEnum.MULTIPLE_CHOICE_MULTIPLE_ANSWER);
		assessmentQuestionDao.saveQuestions(assessmentQuestionModel);
		//AssessmentQuestionModel found = assessmentQuestionDao.findByQuestionTextEn(assessmentQuestionModel.getQuestionTextEN());
		//assertNotNull(found);
	}
	
	@Test
	//@Ignore
	public void testDeleteQuestionById()
	{
		assessmentQuestionDao.deleteAssessmentQuestionById(1);
		AssessmentQuestion assessmentQuestion = assessmentQuestionDao.findByQuestionId(1);
		assertEquals(true, assessmentQuestion.isDeleted());
	}
	
	@Test
	//@Ignore
	public void updateQuestions()
	{
		
		AssessmentQuestionModel assessmentQuestionModel = getAssessmentQuestions();
		assessmentQuestionDao.saveQuestions(assessmentQuestionModel);
		assessmentQuestionModel.setDisplayOrder(3);
		// updating display order
		assessmentQuestionDao.updateQuestions(assessmentQuestionModel);
		AssessmentQuestion assessmentQuestion=assessmentQuestionDao.findByQuestionId(1);
		assertEquals(assessmentQuestionModel.getDisplayOrder(), assessmentQuestion.getDisplayOrder());
		
	}
	
	AssessmentQuestionModel getAssessmentQuestions()
	{
		AssessmentQuestionModel assessmentQuestionModel = new AssessmentQuestionModel();
		assessmentQuestionModel.setAssessmentTypeForCloudable(true);
		assessmentQuestionModel.setAssessmentTypeForCloudProvider(false);
		assessmentQuestionModel.setAssessmentTypeForMigration(false);
		assessmentQuestionModel.setQuestionId(1);
		assessmentQuestionModel.setDeleted(false);
		assessmentQuestionModel.setDisplayOrder(1);
		assessmentQuestionModel.setQuestionDescriptionEN("*************");
		assessmentQuestionModel.setQuestionDescriptionLang2("*************");
		assessmentQuestionModel.setQuestionTextEN("*************");
		assessmentQuestionModel.setQuestionTextLang2("*************");
		assessmentQuestionModel.setQuestionType(QuestionTypeEnum.MULTIPLE_CHOICE_MULTIPLE_ANSWER);
		return assessmentQuestionModel;
	}

}
