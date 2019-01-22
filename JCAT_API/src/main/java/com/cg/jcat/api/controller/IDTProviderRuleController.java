package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jcat.api.dao.DTProviderRuleModel;
import com.cg.jcat.api.dao.DTCProvidersModel;
import com.cg.jcat.api.exception.JcatExceptions;
import com.cg.jcat.api.exception.SystemExceptions;

@RestController
@RequestMapping("/cloudProvider")
public interface IDTCloudProviderRuleController {
	
	@GetMapping("/getAll")
	public List<DTCProvidersModel> getCloudProvider() throws SystemExceptions;
	
	@GetMapping("/getAllRules")
	public List<DTProviderRuleModel> getCloudProviderRules();
	
	@PostMapping("/create")
	public boolean saveCloudProviderRule(@RequestBody List<DTProviderRuleModel> cloudProviderRuleModelList);
	
	@PutMapping("/update")
	public boolean updateCloudProviderRules(@RequestBody DTProviderRuleModel cloudProviderRuleModel) throws JcatExceptions;

}
