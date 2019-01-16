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
	public void saveUser(UserModel user, String createdBy) {
		userDao.saveUser(user, createdBy);
	}

	@Override
	public void updateUsers(UserModel user, String modifiedBy) {
		userDao.updateUsers(user, modifiedBy);
	}

	@Override
	public void deleteById(int userId) {
		userDao.deleteById(userId);
	}

}
