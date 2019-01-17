package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.jcat.api.dao.AssessmentQuestionModel;

@Service
public interface IAssessmentQuestionService {
	

	public List<AssessmentQuestionModel> getQuestions();

	public void saveQuestions(String createdBy, AssessmentQuestionModel question);

	public void updateQuestion(String modifiedBy, AssessmentQuestionModel question);

	public void deleteQuestion(int userId);

	

}
