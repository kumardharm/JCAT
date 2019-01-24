package com.cg.jcat.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name="dt_migration_rule")
public class DTMigrationRule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="migration_rule_id")
	private int migrationRuleId;
	
	@Column(name="migration_id")
	@NotNull
	private int migrationId;
	
	@Column(name="execution_order")
	private int executionOrder;
	
	@Column(name="question_id")
	private int questionId;
	
	@Lob
	@Column(name="question_text_EN")
	private String questionTextEN;
	
	@Lob
	@Column(name="rule_option_ids")
	private String ruleOptionIds;
	
	@Lob
	@Column(name="rule_option_text_EN")
	private String ruleOptionTextEN;
	
	@Column(name="created_by")
	@NotNull
	private String createdBy;
	
	@Column(name="created_time")
	@NotNull
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
	
	public int getExecutionOrder() {
		return executionOrder;
	}
	public void setExecutionOrder(int executionOrder) {
		this.executionOrder = executionOrder;
	}
	public String getQuestionTextEN() {
		return questionTextEN;
	}
	public void setQuestionTextEN(String questionTextEN) {
		this.questionTextEN = questionTextEN;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestiontextEN() {
		return questionTextEN;
	}
	public void setQuestiontextEN(String questiontextEN) {
		this.questionTextEN = questiontextEN;
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
				+ ", executionOrder=" + executionOrder + ", questionId=" + questionId + ", questionTextEN="
				+ questionTextEN + ", ruleOptionIds=" + ruleOptionIds + ", ruleOptionTextEN=" + ruleOptionTextEN
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + "]";
	}
	
	
}
