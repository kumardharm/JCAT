package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jcat.api.dao.DTCloudableRuleModel;


@RestController
@RequestMapping("/dtcloudableRule")
public interface IDTCloudableRuleController {
	
	@GetMapping("/getAll")
	public List<DTCloudableRuleModel> getCloudableRule();
	
	@PostMapping("/create")
	public boolean saveCloudableRule(@RequestBody DTCloudableRuleModel dTCloudableRuleModel);
	
	@PutMapping("/update")
	public boolean updateCloudablerule(@RequestBody DTCloudableRuleModel dTCloudableRuleModel);
	
	@DeleteMapping("/delete/{cloudableRuleId}")
	public  boolean deleteCloudableRule(@PathVariable int cloudabelRuleId);

	
}
