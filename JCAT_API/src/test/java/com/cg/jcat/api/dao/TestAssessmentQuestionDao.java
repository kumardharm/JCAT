package com.cg.jcat.api.dao;

import static org.assertj.core.api.Assertions.assertThat;
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

import com.cg.jcat.api.entity.AssessmentQuestion;
import com.cg.jcat.api.entity.QuestionOption;
import com.cg.jcat.api.utility.QuestionTypeEnum;

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
		System.out.println(assessmentQuestionModel);
		result = assessmentQuestionDao.saveQuestions(assessmentQuestionModel);
		assertEquals(true, result);
		
		//AssessmentQuestionModel found = assessmentQuestionDao.findByQuestionTextEn(assessmentQuestionModel.getQuestionTextEN());
//		assertNotNull(found);
//		
//		assertThat(found.getNumberOfOptions()).isEqualTo(assessmentQuestionModel.getNumberOfOptions());
//		assertThat(found.getCreatedBy()).isEqualTo(assessmentQuestionModel.getCreatedBy());
	}
	
//	@Test
//	@Ignore
//	public void testGetQuestions()
//	{
//		AssessmentQuestionModel assessmentQuestionModel = new AssessmentQuestionModel();
//		assessmentQuestionModel.setAssessmentTypeForCloudable(assessmentQuestion.isAssessmentTypeForCloudable());
//		assessmentQuestionModel.setAssessmentTypeForCloudProvider(assessmentQuestion.isAssessmentTypeForCloudProvider());
//		assessmentQuestionModel.setAssessmentTypeForMigration(assessmentQuestion.isAssessmentTypeForMigration());
//		assessmentQuestionModel.setCreatedBy(assessmentQuestion.getCreatedBy());
//		assessmentQuestionModel.setDeleted(assessmentQuestion.isDeleted());
//		assessmentQuestionModel.setDisplayOrder(assessmentQuestion.getDisplayOrder());
//		assessmentQuestionModel.setModifiedBy(assessmentQuestion.getModifiedBy());
//		assessmentQuestionModel.setQuestionDescriptionEN(assessmentQuestion.getQuestionDescriptionEN());
//		assessmentQuestionModel.setQuestionDescriptionLang2(assessmentQuestion.getQuestionDescriptionLang2());
//		assessmentQuestionModel.setQuestionId(assessmentQuestion.getQuestionId());
//		assessmentQuestionModel.setQuestionTextEN(assessmentQuestion.getQuestionTextEN());
//		assessmentQuestionModel.setQuestionTextLang2(assessmentQuestion.getQuestionTextLang2());
//		assessmentQuestionModel.setQuestionType(assessmentQuestion.getQuestionType());
//		assessmentQuestionModel.setNumberOfOptions(assessmentQuestion.getNumberOfOptions());
//		List<QuestionOptionModel> questionOptionModelList = new ArrayList<>();
//		for(QuestionOption questionOption : assessmentQuestion.getQuestionOption())
//		{
//			questionOptionModelList.add(toQuestionOptionModel(questionOption, assessmentQuestionModel));
//		}
//		assessmentQuestionModel.setQuestionOptionModel(questionOptionModelList);
//		return assessmentQuestionModel;
//	}
	
	@Test
	@Ignore
	public void testDeleteQuestionById()
	{
		assessmentQuestionDao.deleteAssessmentQuestionById(1);
		AssessmentQuestion assessmentQuestion = assessmentQuestionDao.findByQuestionId(1);
		assertEquals(true, assessmentQuestion.isDeleted());
	}
	
	@Test
	@Ignore
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
		assessmentQuestionModel.setAssessmentTypeForCloudProvider(true);
		assessmentQuestionModel.setAssessmentTypeForMigration(true);
		assessmentQuestionModel.setCreatedBy("Admin");
		assessmentQuestionModel.setDeleted(false);
		assessmentQuestionModel.setDisplayOrder(2);
		assessmentQuestionModel.setModifiedBy("Admin");
		assessmentQuestionModel.setQuestionDescriptionEN("Engl");
		assessmentQuestionModel.setQuestionDescriptionLang2("Germ");
		assessmentQuestionModel.setQuestionId(1);
		assessmentQuestionModel.setQuestionTextEN("Engl");
		assessmentQuestionModel.setQuestionTextLang2("Germ");
		assessmentQuestionModel.setQuestionType(QuestionTypeEnum.LONG_ANSWER);
		assessmentQuestionModel.setNumberOfOptions(2);
		return assessmentQuestionModel;
	}

}
