package com.cg.jcat.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.JcatApiApplication;
import com.cg.jcat.api.dao.UserDao;
import com.cg.jcat.api.dao.UserModel;
import com.cg.jcat.api.exception.JcatExceptions;
import com.cg.jcat.api.exception.SystemExceptions;
import com.cg.jcat.api.exception.UserAlreadyExistsException;
import com.cg.jcat.api.service.IUserService;
import com.cg.jcat.api.service.UserService;

@Component
public class UserController implements IUserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@Override
	public List<UserModel> getUsers() throws SystemExceptions {
		try {
			return userService.getUsers();
		} catch (Exception e) {
			logger.error("Error in getting all users: getUsers()", e);

			//throw e;

			throw new SystemExceptions("getUsers()");
//			throw e;

		}
	}

	@Override
	public boolean saveUser(String createdBy, UserModel user) throws UserAlreadyExistsException, SystemExceptions {
		boolean value = false;
		try {
			if (createdBy != null && user != null) {
				value = userService.saveUser(user, createdBy);
			}
			return value;
		} catch (JcatExceptions e) {
			logger.error("Error while saving user " + user.getUsername(), e);
			throw e;
		}

	}


	@Override
	public boolean updateUserId(String modifiedBy, UserModel user)  throws SystemExceptions, UserAlreadyExistsException  {
		boolean value = false;
		try {
			if (modifiedBy != null && user != null) {
				value = userService.updateUsers(user, modifiedBy);
			}
			return value;
		} catch (JcatExceptions e) {
			logger.error("Error while updating user " + user.getUsername(), e);
			throw e;
		}
	}

	@Override
	public void deleteById(int userId) throws JcatExceptions {
		try {
			if (userId != 0) {
				userService.deleteById(userId);
			}
		} catch (JcatExceptions e) {
			logger.error("Error while deleting user " + userId+ " ErrorMessage :"+e.getMessage(), e);
			throw e;
		}
	}

}
