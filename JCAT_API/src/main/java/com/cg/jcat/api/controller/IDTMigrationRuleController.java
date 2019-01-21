package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jcat.api.dao.DTMigrationRuleModel;
import com.cg.jcat.api.dao.UserModel;

@RestController
@RequestMapping("/migrationRule")
public interface IDTMigrationRuleController {
	
	@GetMapping("/getAll")
	public List<DTMigrationRuleModel> getMigrationRule();
	
	@PostMapping("/create")
	public void saveMigrationRule(@RequestBody DTMigrationRuleModel dtMigrationRuleModel);
	
	@PutMapping("/update")
	public void updateMigrationRule(DTMigrationRuleModel dtMigrationRuleModel);

}
