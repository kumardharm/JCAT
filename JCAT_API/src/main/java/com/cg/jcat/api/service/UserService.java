package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.dao.UserDao;
import com.cg.jcat.api.dao.UserModel;

@Component
public class UserService implements IUserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<UserModel> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public UserModel saveUser(UserModel user, String createdBy) {
		userDao.saveUser(user, createdBy);
		return user;
	}

	@Override
	public UserModel updateUsers(UserModel user, String modifiedBy) {
		userDao.updateUsers(user, modifiedBy);
		return user;
	}

	@Override
	public boolean deleteById(int userId) {
		userDao.deleteById(userId);
		return true;
	}

}
