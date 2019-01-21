package com.cg.jcat.api.dao;

import java.util.Date;

public class ApplicationModel {
	
	private int aid;
	private String application_id;
	private String application_name;
	private String application_description;
	private String application_department;
	private int priority;
	private int application_user;
	private boolean is_activate;
	private int assessment_stage;
	private boolean is_assessment_completed;
	private boolean is_dt_cloudable;
	private boolean is_re_cloudable;
	private String dt_migration_pattern;
	private String re_migration_pattern;
	private String dt_cloud_provider;
	private String re_cloud_provider;
	private String created_by;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getApplication_id() {
		return application_id;
	}
	public void setApplication_id(String application_id) {
		this.application_id = application_id;
	}
	public String getApplication_name() {
		return application_name;
	}
	public void setApplication_name(String application_name) {
		this.application_name = application_name;
	}
	public String getApplication_description() {
		return application_description;
	}
	public void setApplication_description(String application_description) {
		this.application_description = application_description;
	}
	public String getApplication_department() {
		return application_department;
	}
	public void setApplication_department(String application_department) {
		this.application_department = application_department;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getApplication_user() {
		return application_user;
	}
	public void setApplication_user(int application_user) {
		this.application_user = application_user;
	}
	public boolean isIs_activate() {
		return is_activate;
	}
	public void setIs_activate(boolean is_activate) {
		this.is_activate = is_activate;
	}
	public int getAssessment_stage() {
		return assessment_stage;
	}
	public void setAssessment_stage(int assessment_stage) {
		this.assessment_stage = assessment_stage;
	}
	public boolean isIs_assessment_completed() {
		return is_assessment_completed;
	}
	public void setIs_assessment_completed(boolean is_assessment_completed) {
		this.is_assessment_completed = is_assessment_completed;
	}
	public boolean isIs_dt_cloudable() {
		return is_dt_cloudable;
	}
	public void setIs_dt_cloudable(boolean is_dt_cloudable) {
		this.is_dt_cloudable = is_dt_cloudable;
	}
	public boolean isIs_re_cloudable() {
		return is_re_cloudable;
	}
	public void setIs_re_cloudable(boolean is_re_cloudable) {
		this.is_re_cloudable = is_re_cloudable;
	}
	public String getDt_migration_pattern() {
		return dt_migration_pattern;
	}
	public void setDt_migration_pattern(String dt_migration_pattern) {
		this.dt_migration_pattern = dt_migration_pattern;
	}
	public String getRe_migration_pattern() {
		return re_migration_pattern;
	}
	public void setRe_migration_pattern(String re_migration_pattern) {
		this.re_migration_pattern = re_migration_pattern;
	}
	public String getDt_cloud_provider() {
		return dt_cloud_provider;
	}
	public void setDt_cloud_provider(String dt_cloud_provider) {
		this.dt_cloud_provider = dt_cloud_provider;
	}
	public String getRe_cloud_provider() {
		return re_cloud_provider;
	}
	public void setRe_cloud_provider(String re_cloud_provider) {
		this.re_cloud_provider = re_cloud_provider;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	@Override
	public String toString() {
		return "ApplicationModel [aid=" + aid + ", application_id=" + application_id + ", application_name="
				+ application_name + ", application_description=" + application_description
				+ ", application_department=" + application_department + ", priority=" + priority
				+ ", application_user=" + application_user + ", is_activate=" + is_activate + ", assessment_stage="
				+ assessment_stage + ", is_assessment_completed=" + is_assessment_completed + ", is_dt_cloudable="
				+ is_dt_cloudable + ", is_re_cloudable=" + is_re_cloudable + ", dt_migration_pattern="
				+ dt_migration_pattern + ", re_migration_pattern=" + re_migration_pattern + ", dt_cloud_provider="
				+ dt_cloud_provider + ", re_cloud_provider=" + re_cloud_provider + ", created_by=" + created_by + "]";
	}
	
	

}