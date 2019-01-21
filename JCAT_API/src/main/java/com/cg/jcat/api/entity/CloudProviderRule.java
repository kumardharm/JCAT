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
public class CloudProviderRule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="provider_rule_id")
	private int providerRuleId;
	@NotNull
	@Column(name="provider_id")
	private int providerId;
	@Column(name="evaluation_order")
	private int evaluationOrder;
	@Column(name="question_id")
	private int questionId;
	@ColumnDefault("0")
	@NotNull
	@Column(name="rule_option_ids")
	private String ruleOptionIds;
	@NotNull
	@Column(name="created_by")
	private String createdBy;
	@NotNull
	@Column(name="created_time")
	private Date createdTime;
	@Column(name="modified_by")
	private String modifiedBy;
	@Column(name="modified_time")
	private Date modifiedTime;


}
