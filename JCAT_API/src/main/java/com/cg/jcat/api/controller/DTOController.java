package com.cg.jcat.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.service.IDTOService;

@Component
public class DTOController implements IDTOController{
	
	@Autowired
	IDTOService dtoService;

}
