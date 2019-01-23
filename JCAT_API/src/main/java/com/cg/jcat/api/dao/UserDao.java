package com.cg.jcat.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.cg.jcat.api.JcatApiApplication;

import com.cg.jcat.api.controller.UserController;

import com.cg.jcat.api.entity.User;
import com.cg.jcat.api.exception.DeleteUserException;
import com.cg.jcat.api.exception.JcatExceptions;
import com.cg.jcat.api.exception.SaveUserException;
import com.cg.jcat.api.exception.UserAlreadyExistsException;
import com.cg.jcat.api.repository.IUserRepository;

@Component
public class UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	@Autowired
	private IUserRepository userRepository;

	public List<UserModel> getUsers() {
		List<User> userList = userRepository.findAll();
		List<UserModel> userDaoList = new ArrayList<UserModel>();
		return togetUsers(userList, userDaoList);
	}

	private List<UserModel> togetUsers(List<User> userList, List<UserModel> userDaoList) {

		for (User user : userList) {
			userDaoList.add(toUserDao(user));
		}
		return userDaoList;
	}

	private UserModel toUserDao(User user) {
		UserModel userDao = null;
		if (user != null) {
			userDao = new UserModel();
			userDao.setUserId(user.getUserId());
			userDao.setFirstName(user.getFirstName());
			userDao.setLastName(user.getLastName());
			userDao.setUsername(user.getUsername());
			userDao.setPassword(user.getPassword());
			userDao.setUserEmail(user.getUserEmail());
			userDao.setCompany(user.getCompany());
			userDao.setAdmin(user.isAdmin());
		}
		return userDao;
	}

	public boolean createUser(UserModel userModel, String createdBy) throws JcatExceptions {
		User existingUser = userRepository.findByUsername(userModel.getUsername());
		if (existingUser != null) {
			throw new  UserAlreadyExistsException(userModel.getUsername());
//			throw new JcatExceptions("User with " + userModel.getUsername() + " already exists in DB ");
		}
		userModel.setCreatedBy(createdBy);
		userModel.setPassword("Cg@123");
		return saveUser(userModel);
	}

	public boolean saveUser(UserModel userModel) throws JcatExceptions {
		boolean value = false;
		try {
			User savedUser = userRepository.save(toUsers(userModel));
			if (savedUser != null) {
				value = true;
			}
		} catch (Exception e) {
			logger.error("Error while saving user " + userModel.getUsername() + " ErrorMessage: " + e.getMessage(), e);

			//throw new JcatExceptions(
//					"Exception while saving user " + userModel.getUsername() + " ErrorMessage: " + e.getMessage());

			
			throw new SaveUserException(userModel.getUsername());
			
//			throw new JcatExceptions(
//					"Exception while saving user " + userModel.getUsername() + " ErrorMessage: " + e.getMessage());

		}
		return value;
	}

	public boolean updateUsers(UserModel user, String modifiedBy) throws JcatExceptions {
		return setUpdatedUser(user, modifiedBy);
	}

	public boolean setUpdatedUser(UserModel user, String modifiedBy) throws JcatExceptions {

		user.setModifiedBy(modifiedBy);
		return saveUser(user);
	}

	public boolean deleteById(int userId) throws JcatExceptions {
		User user = findByUserId(userId);
		if (user == null) {
			
			throw new DeleteUserException(Integer.toString(userId));
//			throw new JcatExceptions("User with id " + userId + " does not exists in DB!");
		}
		user.setDeleted(true);
		user = userRepository.save(user);
		if (user.isDeleted()) {
			return true;
		} else {
			return false;
		}
	}

	public UserModel findByUsername(String username) {
		return toUserDao(userRepository.findByUsername(username));
	}

	public User findByUserId(int userId) {
		return userRepository.findByUserId(userId);

	}

	private User toUsers(UserModel userModel) {
		User users = null;
		if (userModel != null) {
			users = new User();
			users.setUsername(userModel.getUsername());
			users.setUserId(userModel.getUserId());
			users.setCompany(userModel.getCompany());
			users.setCreatedBy(userModel.getCreatedBy());
			users.setFirstName(userModel.getFirstName());
			users.setLastName(userModel.getLastName());
			users.setModifiedBy(userModel.getModifiedBy());
			users.setPassword(userModel.getPassword());
			users.setUserEmail(userModel.getUserEmail());
		}
		return users;
	}

}
