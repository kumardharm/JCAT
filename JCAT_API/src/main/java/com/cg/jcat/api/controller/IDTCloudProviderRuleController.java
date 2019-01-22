package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jcat.api.dao.DTCloudProviderRuleModel;
import com.cg.jcat.api.dao.DTCloudProvidersModel;
import com.cg.jcat.api.exception.JcatExceptions;
import com.cg.jcat.api.exception.SystemExceptions;

@RestController
@RequestMapping("/cloudProvider")
public interface IDTCloudProviderRuleController {
	
	@GetMapping("/getAll")
	public List<DTCloudProvidersModel> getCloudProvider() throws SystemExceptions;
	
	@GetMapping("/getAllRules")
	public List<DTCloudProviderRuleModel> getCloudProviderRules();
	
	@PostMapping("/create")
	public boolean saveCloudProviderRule(@RequestBody List<DTCloudProviderRuleModel> cloudProviderRuleModelList);
	
	@PutMapping("/update")
	public boolean updateCloudProviderRules(@RequestBody DTCloudProviderRuleModel cloudProviderRuleModel) throws JcatExceptions;

}
