package com.cg.jcat.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.JcatApiApplication;
import com.cg.jcat.api.dao.UserDao;
import com.cg.jcat.api.dao.UserModel;
import com.cg.jcat.api.exception.JcatExceptions;

@Component
public class UserService implements IUserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserDao userDao;

	@Override
	public List<UserModel> getUsers() {
		List<UserModel> users = userDao.getUsers();
		logger.info("Retrieved " + users.size() + " users from DB!");
		return users;
	}

	@Override
	public boolean saveUser(UserModel user, String createdBy) throws JcatExceptions {
		boolean isSaved = userDao.createUser(user, createdBy);
		logger.info("User " + user.getUsername() + " successfully saved in DB!" + isSaved);
		return isSaved;
	}

	@Override
	public boolean updateUsers(UserModel user, String modifiedBy) throws JcatExceptions {

		boolean isUpdated = userDao.updateUsers(user, modifiedBy);
		logger.info("User " + user.getUsername() + " successfully updated in DB!" + isUpdated);
		return isUpdated;
	}

	@Override
	public boolean deleteById(int userId) throws JcatExceptions {
		boolean isDeleted = userDao.deleteById(userId);
		logger.info("User " + userId + " successfully deleted from DB!" + isDeleted);
		return isDeleted;
	}

}
