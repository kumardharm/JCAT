package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.AssessmentQuestionModel;

@Component
public class AssessmentQuestionService implements IAssessmentQuestionService{

	@Override
	public List<AssessmentQuestionModel> getQuestions() {
		return null;
	}

	@Override
	public void saveQuestions(String createdBy, AssessmentQuestionModel question) {
		
	}

	@Override
	public void updateQuestion(String modifiedBy, AssessmentQuestionModel question) {
		
	}

	@Override
	public void deleteQuestion(int userId) {
		
	}

}
