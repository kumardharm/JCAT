package com.cg.jcat.api.dao;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cg.jcat.api.entity.AssessmentQuestion;

public class QuestionOptionModel {
	
private int optionId;
	
//	@Column(name="question_id")
//	private int questionId;
	
	private String optionTextEN;
	
	private String optionTextLang2;
	
	@ManyToOne
    @JoinColumn(name = "question_id")
	private AssessmentQuestionModel assessmentQuestion;
	
	public AssessmentQuestionModel getAssessmentQuestion() {
		return assessmentQuestion;
	}

	public void setAssessmentQuestion(AssessmentQuestionModel assessmentQuestion) {
		this.assessmentQuestion = assessmentQuestion;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

//	public int getQuestionId() {
//		return questionId;
//	}
//
//	public void setQuestionId(int questionId) {
//		this.questionId = questionId;
//	}

	public String getOption_text_EN() {
		return optionTextEN;
	}

	public void setOption_text_EN(String option_text_EN) {
		this.optionTextEN = option_text_EN;
	}

	public String getOptionTextLang2() {
		return optionTextLang2;
	}

	public void setOptionTextLang2(String optionTextLang2) {
		this.optionTextLang2 = optionTextLang2;
	}

	public String getOptionTextEN() {
		return optionTextEN;
	}

	public void setOptionTextEN(String optionTextEN) {
		this.optionTextEN = optionTextEN;
	}

	@Override
	public String toString() {
		return "QuestionOption [optionId=" + optionId + ", optionTextEN=" + optionTextEN + ", optionTextLang2="
				+ optionTextLang2 + ", assessmentQuestion=" + assessmentQuestion + "]";
	}

	
	
}
