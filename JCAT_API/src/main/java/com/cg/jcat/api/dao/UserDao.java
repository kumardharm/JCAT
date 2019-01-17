package com.cg.jcat.api.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.jcat.api.entity.User;
import com.cg.jcat.api.repository.IUserRepository;

@Component
public class UserDao{
	
	@Autowired
	private IUserRepository userRepository;

	public List<UserModel> getUsers() {
		
		List<User> userList= userRepository.findAll();
		List<UserModel> userDaoList = new ArrayList<UserModel>();
		return togetUsers(userList,userDaoList);
	}

	private List<UserModel> togetUsers(List<User> userList, List<UserModel> userDaoList) {

		for(User user:userList)
		{
			userDaoList.add(toUserDao(user));
		}
		return userDaoList;
	}

	private UserModel toUserDao(User user) {

		UserModel userDao = new UserModel();
		userDao.setUserId(user.getUserId());
		userDao.setFirstName(user.getFirstName());
		userDao.setLastName(user.getLastName());
		userDao.setUsername(user.getUsername());
		userDao.setPassword(user.getPassword());
		userDao.setUserEmail(user.getUserEmail());
		userDao.setCompany(user.getCompany());
		userDao.setAdmin(user.isAdmin());
		return userDao;
	}

	public UserModel saveUser(UserModel userModel, String createdBy) {
		userModel.setCreatedBy(createdBy);
		userModel.setPassword("Cg@123");
		saveUser(userModel);
		return findByUsername(userModel.getUsername());
	}
	
	public void saveUser(UserModel userModel) {
		userRepository.save(toUsers(userModel));
	}

	public UserModel updateUsers(UserModel user, String modifiedBy) {
		return setUpdatedUser(user, modifiedBy);
	}
	
	public UserModel setUpdatedUser(UserModel user,String modifiedBy) {
		user.setModifiedBy(modifiedBy);
		saveUser(user);
		return toUserDao(findByUserId(user.getUserId()));
	}


	public boolean deleteById(int userId) {
		User user = findByUserId(userId);
		user.setDeleted(true);
		userRepository.save(user);
		if(findByUserId(userId).isDeleted())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public UserModel findByUsername(String username)
	{
		return toUserDao(userRepository.findByUsername(username));
	}
	
	public User findByUserId(int userId) {
		return userRepository.findByUserId(userId);
	}
	
	private User toUsers(UserModel userModel)
	{
		User users=new User();
		users.setUsername(userModel.getUsername());
		users.setUserId(userModel.getUserId());
		users.setCompany(userModel.getCompany());
		users.setCreatedBy(userModel.getCreatedBy());
		users.setFirstName(userModel.getFirstName());
		users.setLastName(userModel.getLastName());
		users.setModifiedBy(userModel.getModifiedBy());
		users.setPassword(userModel.getPassword());
		users.setUserEmail(userModel.getUserEmail());
		return users;
	}
	
	

}
