package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.UserModel;
import com.cg.jcat.api.exception.JcatExceptions;
import com.cg.jcat.api.service.IUserService;

@Component
public class UserController implements IUserController {

	@Autowired
	private IUserService userService;

	@Override
	public List<UserModel> getUsers() {
		try {
			return userService.getUsers();
		} catch (JcatExceptions e) {
			System.out.println("Error in getting users" + e);
			return null;
		}
	}

	@Override
	public boolean saveUser(String createdBy, UserModel user) {
		boolean value = false;
		try {
			if (createdBy != null && user != null) {
				value = userService.saveUser(user, createdBy);
			}
			return value;
		} catch (Exception e) {
			System.out.print("Error while saving user" + e);
			return false;
		}
		
	}

	@Override
	public void updateUserId(String modifiedBy, UserModel user) {
		try {
			if(modifiedBy != null && user != null) {
				userService.updateUsers(user, modifiedBy);
			}
		} catch (Exception e) {
			System.out.print("Error while updating user" + e);
		}
	}

	@Override
	public void deleteById(int userId) {
		try {
			if (userId != 0) {
				userService.deleteById(userId);
			}
		} catch (Exception e) {
			System.out.print("Error while deleting user" + e);
		}
	}

	
}
