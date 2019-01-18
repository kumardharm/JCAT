package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.UserDao;
import com.cg.jcat.api.dao.UserModel;
import com.cg.jcat.api.exception.JcatExceptions;

@Component
public class UserService implements IUserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<UserModel> getUsers() throws JcatExceptions {
		return userDao.getUsers();
	}

	@Override
	public UserModel saveUser(UserModel user, String createdBy) {
		return userDao.saveUser(user, createdBy);
	}

	@Override
	public UserModel updateUsers(UserModel user, String modifiedBy) {
		userDao.updateUsers(user, modifiedBy);
		return user;
	}

	@Override
	public boolean deleteById(int userId) {
		return userDao.deleteById(userId);
	}

	@Override
	public boolean isExist(String userName) {
		
		return userDao.isExist(userName);
	}

}
