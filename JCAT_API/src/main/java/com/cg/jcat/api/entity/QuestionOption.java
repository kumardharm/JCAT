package com.cg.jcat.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="question_option")
public class QuestionOption {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="option_id")
	private int optionId;
	
//	@Column(name="question_id")
//	private int questionId;
	
	@Column(name="option_text_EN")
	private String optionTextEN;
	
	@Column(name="option_text_lang2")
	private String optionTextLang2;
	
	@ManyToOne
    @JoinColumn(name = "question_id")
	private AssessmentQuestion assessmentQuestion;
	
	public AssessmentQuestion getAssessmentQuestion() {
		return assessmentQuestion;
	}

	public void setAssessmentQuestion(AssessmentQuestion assessmentQuestion) {
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
