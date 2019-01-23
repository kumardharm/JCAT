package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.jcat.api.dao.DTCloudableRuleModel;


@Service
public interface IDTCloudableRuleService {

	public List<DTCloudableRuleModel> getCloudableRule();

	public boolean saveCloudableRule(DTCloudableRuleModel dTCloudableRuleModel);

	public boolean updateCloudablerule(DTCloudableRuleModel dTCloudableRuleModel);

	public boolean deleteCloudableRule(int cloudableRuleId);

	public DTCloudableRuleModel getCloudableRuleById(int cloudableRuleId);

}
