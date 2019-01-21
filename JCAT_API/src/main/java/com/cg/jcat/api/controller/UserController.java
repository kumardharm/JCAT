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
	public void saveUser(String createdBy, UserModel user) {
		System.out.println(user);
		try {
			if (createdBy != null && user != null) {
				userService.saveUser(user, createdBy);
			}
		} catch (Exception e) {
			System.out.print("Error while saving user" + e);
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

	@Override
	public boolean isExist(String userName) {
        try
        {
        	return userService.isExist(userName);
        }catch (Exception e) {
        	System.out.print("Error user is already present" + e);
        	return false;
        }
        
	}
}
