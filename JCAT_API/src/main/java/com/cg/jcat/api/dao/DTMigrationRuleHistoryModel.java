package com.cg.jcat.api.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Lob;

public class DTMigrationRuleHistoryModel {
	
	private int id;
	
	private int migrationRuleId;
	
	private int migrationId;
	
	private int executionOrder;
	
	private int questionId;
	
	private String questionTextEN;
	
	private String ruleOptionIds;
	
	private String ruleOptionTextEN;
	
	private String createdBy;
	
	private Date createdTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTextEN() {
		return questionTextEN;
	}

	public void setQuestionTextEN(String questionTextEN) {
		this.questionTextEN = questionTextEN;
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "DTMigrationRuleHistoryModel [id=" + id + ", migrationRuleId=" + migrationRuleId + ", migrationId="
				+ migrationId + ", executionOrder=" + executionOrder + ", questionId=" + questionId
				+ ", questionTextEN=" + questionTextEN + ", ruleOptionIds=" + ruleOptionIds + ", ruleOptionTextEN="
				+ ruleOptionTextEN + ", createdBy=" + createdBy + ", createdTime=" + createdTime + "]";
	}
	
	
	
}
