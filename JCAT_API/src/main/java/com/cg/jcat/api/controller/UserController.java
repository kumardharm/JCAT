package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.UserModel;
import com.cg.jcat.api.service.IUserService;

@Component
public class UserController implements IUserController{
	
	@Autowired
	private IUserService userService;

	@Override
	public List<UserModel> getUsers() {
		return userService.getUsers();
	}

	@Override
	public void saveUser(String createdBy, UserModel user) 
	{
		userService.saveUser(user,createdBy);
	}


	@Override
	public void updateUserId(String modifiedBy, UserModel user) {
		userService.updateUsers(user,modifiedBy);
	}

	@Override
	public void deleteById(int userId) {
		userService.deleteById(userId);
	}
}
