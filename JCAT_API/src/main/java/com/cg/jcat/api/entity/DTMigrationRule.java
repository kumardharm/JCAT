package com.cg.jcat.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="dt_migration_rule")
public class DTMigrationRule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="migration_rule_id")
	private int migrationRuleId;
	
	@Column(name="migration_id")
	private int migrationId;
	
	@Column(name="evaluation_order")
	private int evaluationOrder;
	
	@Column(name="question_id")
	private int questionId;
	
	@Column(name="question_text_EN")
	private String questiontextEN;
	
	@Column(name="rule_option_ids")
	private String ruleOptionIds;
	
	@Column(name="rule_option_text_EN")
	private String ruleOptionTextEN;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_time")
	private Date createdTime;
	
	@Column(name="modified_by")
	private String modifiedBy;
	
	@Column(name="modified_time")
	private Date modifiedTime;
	
	public int getMigrationRuleId() {
		return migrationRuleId;
	}
	public void setMigrationRuleId(int migrationRuleId) {
		this.migrationRuleId = migrationRuleId;
	}
	public int getMigrationId() {
		return migrationId;
	}
	public void setMigrationId(int migrationId) {
		this.migrationId = migrationId;
	}
	public int getEvaluationOrder() {
		return evaluationOrder;
	}
	public void setEvaluationOrder(int evaluationOrder) {
		this.evaluationOrder = evaluationOrder;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestiontextEN() {
		return questiontextEN;
	}
	public void setQuestiontextEN(String questiontextEN) {
		this.questiontextEN = questiontextEN;
	}
	public String getRuleOptionIds() {
		return ruleOptionIds;
	}
	public void setRuleOptionIds(String ruleOptionIds) {
		this.ruleOptionIds = ruleOptionIds;
	}
	public String getRuleOptionTextEN() {
		return ruleOptionTextEN;
	}
	public void setRuleOptionTextEN(String ruleOptionTextEN) {
		this.ruleOptionTextEN = ruleOptionTextEN;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedTtime() {
		return createdTime;
	}
	public void setCreatedTtime(Date createdTtime) {
		this.createdTime = createdTtime;
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
		return "DTMigrationRule [migrationRuleId=" + migrationRuleId + ", migrationId=" + migrationId
				+ ", evaluationOrder=" + evaluationOrder + ", questionId=" + questionId + ", questiontextEN="
				+ questiontextEN + ", ruleOptionIds=" + ruleOptionIds + ", ruleOptionTextEN=" + ruleOptionTextEN
				+ ", createdBy=" + createdBy + ", createdTtime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + "]";
	}
	
}
