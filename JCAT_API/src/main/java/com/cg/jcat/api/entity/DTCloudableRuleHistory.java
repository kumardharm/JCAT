package com.cg.jcat.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="dt_cloudable_rule_history")
public class DTCloudableRuleHistory {
	
	@Id
	private int id;
	
	@NotNull
	@Column(name = "cloudable_rule_id")
	private int cloudableRuleId;
	
	@Column(name = "execution_order")
	private int executionOrder;
	
	@Column(name = "question_id")
	private int questionId;
	
	@Lob
	@Column(name = "question_text_EN")
	private String questiontTextEN;
	
	@Lob
	@Column(name = "rule_option_ids")
	private String ruleOptionIds;
	
	@Lob
	@Column(name = "rule_option_text_EN")
	private String ruleOptionTextEN;
	
	@Column(name = "created_by")
	@NotNull
	private String createdBy;
	
	@Column(name = "cteated_time")
	@NotNull
	private Date cteatedTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCloudableRuleId() {
		return cloudableRuleId;
	}
	public void setCloudableRuleId(int cloudableRuleId) {
		this.cloudableRuleId = cloudableRuleId;
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
	public String getQuestiontTextEN() {
		return questiontTextEN;
	}
	public void setQuestiontTextEN(String questiontTextEN) {
		this.questiontTextEN = questiontTextEN;
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
	public Date getCteatedTime() {
		return cteatedTime;
	}
	public void setCteatedTime(Date cteatedTime) {
		this.cteatedTime = cteatedTime;
	}
	@Override
	public String toString() {
		return "DTCloudableRuleHistory [id=" + id + ", cloudableRuleId=" + cloudableRuleId + ", executionOrder="
				+ executionOrder + ", questionId=" + questionId + ", questiontTextEN=" + questiontTextEN
				+ ", ruleOptionIds=" + ruleOptionIds + ", ruleOptionTextEN=" + ruleOptionTextEN + ", createdBy="
				+ createdBy + ", cteatedTime=" + cteatedTime + "]";
	}
	
}
