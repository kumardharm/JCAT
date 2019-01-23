package com.cg.jcat.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.DTODao;

@Component
public class DTOService implements IDTOService{
	
	@Autowired
	DTODao dtoDao;

}
