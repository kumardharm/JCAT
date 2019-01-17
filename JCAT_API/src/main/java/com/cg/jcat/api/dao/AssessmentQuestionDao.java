//package com.cg.jcat.api.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import com.cg.jcat.api.entity.AssessmentQuestion;
//import com.cg.jcat.api.repository.IAssessmentQuestionRepository;
//
//
//public class AssessmentQuestionDao {
//	
//	@Autowired
//	IAssessmentQuestionRepository assessmentQuestionRepository;
//	
//	private static boolean isDeleteValue;
//	
//	public List<AssessmentQuestionModel> getAllAssessmentQuestion(int clientId){
//		List<AssessmentQuestionModel> assessmentQuestionDAOList=new ArrayList<AssessmentQuestionModel>();
//		List<AssessmentQuestion> assessmentQuestionList=assessmentQuestionRepository.findByIsDelete(isDeleteValue);
//		return toGetAllAssessmentQuestionDao(assessmentQuestionList,assessmentQuestionDAOList);
//	}
//	
//	public List<AssessmentQuestionModel> toGetAllAssessmentQuestionDao(List<AssessmentQuestion> assessmentQuestionList,List<AssessmentQuestionModel> assessmentQuestionDAOList){
//		
//		for(AssessmentQuestion assessmentQuestion:assessmentQuestionList)
//		{
//			assessmentQuestionDAOList.add(toAssessmentQuestionDao(assessmentQuestion));
//		}
//		return assessmentQuestionDAOList;
//	}
//
//	
//	public AssessmentQuestionModel saveQuestions(AssessmentQuestionModel assessmentQuestionsModel)
//	{
//		if(assessmentQuestionsModel!=null)
//		{
//			assessmentQuestionRepository.save(toAssessmentQuestionService(assessmentQuestionsModel));
//			return assessmentQuestionRepository.findByQuestionTextEN(assessmentQuestionsModel.getQuestionDescriptionEN());
//		}
//		else
//		{
//			return null;
//		}
//		
//	}
//	
//	public boolean deleteAssessmentQuestionById(int questionId)
//	{
//		AssessmentQuestion assessmentQuestion=new AssessmentQuestion();
//		assessmentQuestion=assessmentQuestionRepository.findByQuestionId(questionId);
//		assessmentQuestion.setDeleted(true);
//		if(assessmentQuestion.isDeleted())
//		{
//			assessmentQuestionRepository.save(assessmentQuestion);
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//	}
//	
//	
//
//	private AssessmentQuestion toAssessmentQuestionService(AssessmentQuestionModel assessmentQuestionsModel) {
//		AssessmentQuestion assessmentQuestion = new AssessmentQuestion();
//		assessmentQuestion.setAssessmentTypeForCloudable(assessmentQuestionsModel.isAssessmentTypeForCloudable());
//		assessmentQuestion.setAssessmentTypeForCloudProvider(assessmentQuestionsModel.isAssessmentTypeForCloudProvider());
//		assessmentQuestion.setAssessmentTypeForMigration(assessmentQuestionsModel.isAssessmentTypeForMigration());
//		assessmentQuestion.setCreatedBy(assessmentQuestionsModel.getCreatedBy());
//		assessmentQuestion.setDeleted(assessmentQuestionsModel.isDeleted());
//		assessmentQuestion.setDisplayOrder(assessmentQuestionsModel.getDisplayOrder());
//		assessmentQuestion.setModifiedBy(assessmentQuestionsModel.getModifiedBy());
//		assessmentQuestion.setQuestionDescriptionEN(assessmentQuestionsModel.getQuestionDescriptionEN());
//		assessmentQuestion.setQuestionDescriptionLang2(assessmentQuestionsModel.getQuestionDescriptionLang2());
//		assessmentQuestion.setQuestionId(assessmentQuestionsModel.getQuestionId());
//		assessmentQuestion.setQuestionTextEN(assessmentQuestionsModel.getQuestionTextEN());
//		assessmentQuestion.setQuestionTextLang2(assessmentQuestionsModel.getQuestionDescriptionLang2());
//		assessmentQuestion.setQuestionType(assessmentQuestionsModel.getQuestionType());
//		return assessmentQuestion;
//	}
//	
//	private AssessmentQuestionModel toAssessmentQuestionDao(AssessmentQuestion assessmentQuestion) {
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
//		assessmentQuestionModel.setQuestionTextLang2(assessmentQuestion.getQuestionDescriptionLang2());
//		assessmentQuestionModel.setQuestionType(assessmentQuestion.getQuestionType());
//		return assessmentQuestionModel;
//	}
//	
//}
