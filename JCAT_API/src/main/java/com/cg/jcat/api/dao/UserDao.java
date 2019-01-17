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
		return userModel;
	}
	
	public void saveUser(UserModel userModel) {
		System.out.println("%%%%%%%%%%%%%%%");
		userRepository.save(toUsers(userModel));
	}

	public void updateUsers(UserModel user, String modifiedBy) {
			setUpdatedUser(user, modifiedBy);
	}
	
	public void setUpdatedUser(UserModel user,String modifiedBy) {
		user.setModifiedBy(modifiedBy);
		saveUser(user);
	}


	public boolean deleteById(int userId) {
		User user = userRepository.findByUserId(userId);
		user.setDeleted(true);
		userRepository.save(user);
		return true;
	}
	
	public UserModel findByUsername(String username)
	{
		return toUserDao(userRepository.findByUsername(username));
	}
	
	public User findByUserId(int userId) {
		return userRepository.findByUserId(userId);
	}
	
	public User toUsers(UserModel usersDao)
	{
		User users=new User();
		users.setUsername(usersDao.getUsername());
		users.setUserId(usersDao.getUserId());
		users.setCompany(usersDao.getCompany());
		users.setCreatedBy(usersDao.getCreatedBy());
		users.setFirstName(usersDao.getFirstName());
		users.setLastName(usersDao.getLastName());
		users.setModifiedBy(usersDao.getModifiedBy());
		users.setPassword(usersDao.getPassword());
		return users;
	}
	
	

}
