package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.AssessmentQuestionModel;
import com.cg.jcat.api.service.IAssessmentQuestionService;

@Component
public class AssessmentQuestionController implements IAssessmentQuestionController{
	
	@Autowired
	private IAssessmentQuestionService assessmentQuestionService;

	@Override
	public List<AssessmentQuestionModel> getQuestions() {
		return assessmentQuestionService.getQuestions();
	}

	@Override
	public void saveQuestions(String createdBy, AssessmentQuestionModel question) {
		
		assessmentQuestionService.saveQuestions(createdBy,question);
	}

	@Override
	public void updateQuestion(String modifiedBy, AssessmentQuestionModel question) {

		assessmentQuestionService.updateQuestion(modifiedBy,question);
		
	}

	@Override
	public void deleteQuestion(int userId) {
		assessmentQuestionService.deleteQuestion(userId);
	}

}
