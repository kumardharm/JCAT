package com.cg.jcat.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="dt_provider_rule_history")
public class DtProviderRuleHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id")
    private int	id;
    @NotNull
    @Column(name="provider_rule_id")
	private int providerRuleId;
    @NotNull
    @Column(name="provider_id")
	private int providerId;
    @Column(name="evaluation_order")
	private int evaluationOrder;
	@NotNull
	@Column(name="question_id")
	private int questionId;
	@NotNull
	@Column(name="question_text_EN")
	private String questionTextEN;
	@NotNull
	@Column(name="rule_option_ids")
	private String ruleOptionIds;
	@NotNull
	@Column(name="rule_option_text_EN")
	private String ruleOptionTextEN;
	@NotNull
	@Column(name="created_by")
	private String createdBy;
	@NotNull
	@Column(name="created_time")
	private Date cteatedTime;


}
