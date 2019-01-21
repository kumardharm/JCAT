package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jcat.api.dao.CloudProvidersModel;

@RestController
@RequestMapping("/cloudProvider")
public interface ICloudProviderController {
	
	@GetMapping("/getAll")
	public List<CloudProvidersModel> getCloudProvider();

}
