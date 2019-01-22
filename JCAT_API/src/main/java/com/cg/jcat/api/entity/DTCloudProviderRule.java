package com.cg.jcat.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="dt_provider_rule")
public class DTCloudProviderRule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="provider_rule_id")
	private int providerRuleId;
	
	@Column(name="provider_id")
	private int providerId;
	
//	@ColumnDefault("0")
	@Column(name="evaluation_order")
	private int evaluationOrder;
	
	@Column(name="question_id")
	private int questionId;
	
	@Column(name="question_text_EN")
	private String questiontextEN;
	
//	@ColumnDefault("0")
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
	
	public int getProviderRuleId() {
		return providerRuleId;
	}
	public void setProviderRuleId(int providerRuleId) {
		this.providerRuleId = providerRuleId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
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
		return "CloudProviderRule [providerRuleId=" + providerRuleId + ", providerId=" + providerId
				+ ", evaluationOrder=" + evaluationOrder + ", questionId=" + questionId + ", questiontextEN="
				+ questiontextEN + ", ruleOptionIds=" + ruleOptionIds + ", ruleOptionTextEN=" + ruleOptionTextEN
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + "]";
	}

	
	
}
