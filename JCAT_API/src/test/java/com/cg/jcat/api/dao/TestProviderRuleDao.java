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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jcat.api.entity.DTProviders;
import com.cg.jcat.api.exception.SystemExceptions;
import com.cg.jcat.api.repository.IAssessmentQuestionRepository;
import com.cg.jcat.api.repository.IDTProviderRepository;
import com.cg.jcat.api.utility.QuestionTypeEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProviderRuleDao {

	@Autowired
	private DTProviderRuleDao ProviderRuleDao;

	@Autowired
	private IDTProviderRepository providerRepository;

	@Autowired
	AssessmentQuestionDao assessmentQuestionDao;

	@Autowired
	IAssessmentQuestionRepository assessmentQuestionRepository;

	Date date = new Date();

	@Test
	@Ignore
	public void testAsaveCloudProvider() {
		providerRepository.save(getProvider());
		assertNotNull(ProviderRuleDao.getCloudProvider());
	}

	private DTProviders getProvider() {
		Date date = new Date();
		DTProviders providerRule = new DTProviders();
		providerRule.setEvaluationOrder(1);
		providerRule.setCreatedBy("Admin");
		providerRule.setCreatedTime(date);
		providerRule.setProviderName("GITC");
		return providerRule;
	}

	@Test
	@Ignore
	public void testBGetCloudProvider() {
		assertNotNull(ProviderRuleDao.getCloudProvider());
		// assertEquals(1, ProviderRuleDao.getCloudProvider().size());
	}

	@Test
	@Ignore
	public void testDGetCloudProviderRules() throws SystemExceptions {
		List<DTProviderRuleModel> cloudProviderRuleModelList = new ArrayList<DTProviderRuleModel>();
		// cloudProviderRuleModelList.add(getcloudProviderRuleModel());
		// cloudProviderRuleModelList.add(getcloudProviderRuleModel2());
		// assertEquals(true,
		// ProviderRuleDao.saveProviderRule(cloudProviderRuleModelList));
		assertNotNull(ProviderRuleDao.getCloudProviderRules(0));
		// assertEquals(1, ProviderRuleDao.getCloudProviderRules());
		// assertEquals(1, ProviderRuleDao.getCloudProviderRules(1).size());
		// assertEquals(2, ProviderRuleDao.getCloudProviderRules(0).size());
	}

	@Test
	// @Ignore
	public void testCSaveCloudProviderRule() throws SystemExceptions {
	/*	Date date1 = new Date();
		boolean result = true;
		result = assessmentQuestionDao.saveQuestions(getAssessmentQuestions());
		assertEquals(true, result);

		DTProviders dtMigration = new DTProviders();
		dtMigration.setCreatedBy("Admin");
		dtMigration.setCreatedTime(date1);
		dtMigration.setEvaluationOrder(1);
		dtMigration.setEvaluationOrder(1);
		dtMigration.setLogicalOperator("OR");
		dtMigration.setProviderName("gitc");
		result = providerRepository.save(dtMigration) != null;
		assertEquals(true, result);*/

		List<DTProviderRuleModel> migrationRuleList = new ArrayList<>();
		DTProviderRuleModel DTProviderRuleModel = new DTProviderRuleModel();
		DTProviderRuleModel = getcloudProviderRuleModel();
		migrationRuleList.add(DTProviderRuleModel);
		System.out.println("***************************************");
		System.out.println("************************************");
		
		assertEquals(true, ProviderRuleDao.saveProviderRule(migrationRuleList)); // saving 2 migration rule

	}

	private DTProviderRuleModel getcloudProviderRuleModel() {

		DTProviderRuleModel DTProviderRuleModel = new DTProviderRuleModel();
		DTProviderRuleModel.setProviderRuleId(1);
		DTProviderRuleModel.setEvaluationOrder(1);
		DTProviderRuleModel.setProviderId(1);
		DTProviderRuleModel.setQuestionId(1);
		DTProviderRuleModel.setQuestiontextEN("1");
		DTProviderRuleModel.setRuleOptionIds("1");
		DTProviderRuleModel.setRuleOptionTextEN("1");
		return DTProviderRuleModel;
		
	}

	List<QuestionOptionModel> getQuestionOptionModel() {
		// assessmentQuestionModel.setQuestionOptionModel(null);
		List<QuestionOptionModel> list = new ArrayList<>();
		QuestionOptionModel questionOptionModel = new QuestionOptionModel();
		// questionOptionModel.setOptionId(11);
		// questionOptionModel.setAssessmentQuestionModel(assessmentQuestionModel);
		questionOptionModel.setOptionTextEN("ENGLISH");
		questionOptionModel.setOptionTextLang2("ä ö ü ß Ä Ö Ü");
		list.add(questionOptionModel);
		return list;
	}

	AssessmentQuestionModel getAssessmentQuestions() {

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
		assessmentQuestionModel.setCreatedTime(date);
		assessmentQuestionModel.setQuestionType(QuestionTypeEnum.LONG_ANSWER);
		assessmentQuestionModel.setNumberOfOptions(2);
		assessmentQuestionModel.setQuestionOptionModel(getQuestionOptionModel());
		return assessmentQuestionModel;
	}

}
