/**
 * 
 */
package com.cg.jcat.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author priyanj
 *
 */
@Entity
public class AssessmentQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	private boolean assessmentTypeForCloudable;
	private boolean assessmentTypeForCloudProvider;
	private boolean assessmentTypeForMigration;
	private String questionType;
	private String questionTextEN;
	private String questionTextLang2;
	private String questionDescriptionEN;
	private String questionDescriptionLang2;
	private int numberOfOptions;
	private int displayOrder;
	private boolean isDeleted;
	private String createdBy;
	private Date createdTime;
	private String modifiedBy;
	private Date modifiedTime;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public boolean isAssessmentTypeForCloudable() {
		return assessmentTypeForCloudable;
	}
	public void setAssessmentTypeForCloudable(boolean assessmentTypeForCloudable) {
		this.assessmentTypeForCloudable = assessmentTypeForCloudable;
	}
	public boolean isAssessmentTypeForCloudProvider() {
		return assessmentTypeForCloudProvider;
	}
	public void setAssessmentTypeForCloudProvider(boolean assessmentTypeForCloudProvider) {
		this.assessmentTypeForCloudProvider = assessmentTypeForCloudProvider;
	}
	public boolean isAssessmentTypeForMigration() {
		return assessmentTypeForMigration;
	}
	public void setAssessmentTypeForMigration(boolean assessmentTypeForMigration) {
		this.assessmentTypeForMigration = assessmentTypeForMigration;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getQuestionTextEN() {
		return questionTextEN;
	}
	public void setQuestionTextEN(String questionTextEN) {
		this.questionTextEN = questionTextEN;
	}
	public String getQuestionTextLang2() {
		return questionTextLang2;
	}
	public void setQuestionTextLang2(String questionTextLang2) {
		this.questionTextLang2 = questionTextLang2;
	}
	public String getQuestionDescriptionEN() {
		return questionDescriptionEN;
	}
	public void setQuestionDescriptionEN(String questionDescriptionEN) {
		this.questionDescriptionEN = questionDescriptionEN;
	}
	public String getQuestionDescriptionLang2() {
		return questionDescriptionLang2;
	}
	public void setQuestionDescriptionLang2(String questionDescriptionLang2) {
		this.questionDescriptionLang2 = questionDescriptionLang2;
	}
	public int getNumberOfOptions() {
		return numberOfOptions;
	}
	public void setNumberOfOptions(int numberOfOptions) {
		this.numberOfOptions = numberOfOptions;
	}
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@Override
	public String toString() {
		return "AssessmentQuestion [questionId=" + questionId + ", assessmentTypeForCloudable="
				+ assessmentTypeForCloudable + ", assessmentTypeForCloudProvider=" + assessmentTypeForCloudProvider
				+ ", assessmentTypeForMigration=" + assessmentTypeForMigration + ", questionType=" + questionType
				+ ", questionTextEN=" + questionTextEN + ", questionTextLang2=" + questionTextLang2
				+ ", questionDescriptionEN=" + questionDescriptionEN + ", questionDescriptionLang2="
				+ questionDescriptionLang2 + ", numberOfOptions=" + numberOfOptions + ", displayOrder=" + displayOrder
				+ ", isDeleted=" + isDeleted + ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + "]";
	}
	
}
//{
//	Multiple_Choice_Single_Answer,Multiple_Choice_MultipleAnswer,ShortAnswer,LongAnswer
//}