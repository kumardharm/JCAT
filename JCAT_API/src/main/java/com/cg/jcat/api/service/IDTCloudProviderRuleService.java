package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.jcat.api.dao.DTCloudProviderRuleModel;
import com.cg.jcat.api.dao.DTCloudProvidersModel;
import com.cg.jcat.api.entity.DTCloudProviderRule;
import com.cg.jcat.api.entity.DTProviderRuleHistory;
import com.cg.jcat.api.exception.JcatExceptions;
@Service
public interface IDTCloudProviderRuleService {

	List<DTCloudProvidersModel> getCloudProvider();

	boolean updateCloudProviderRules(DTCloudProviderRuleModel cloudProviderRuleModel) throws JcatExceptions;

	boolean saveCloudProviderRule(DTCloudProviderRuleModel cloudProviderRuleModel);

	List<DTCloudProviderRuleModel> getCloudProviderRules();

}
