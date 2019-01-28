package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jcat.api.dao.ApplicationModel;
import com.cg.jcat.api.exception.SystemExceptions;

@RestController
@RequestMapping("/application")
public interface IApplicationController {
	
	@GetMapping("/getAll")
	public List<ApplicationModel> getApplications() throws SystemExceptions;
	
	@PostMapping("/create/{createdBy}")
	public void save(@PathVariable String createdBy, @RequestBody ApplicationModel application);
	
	

}
