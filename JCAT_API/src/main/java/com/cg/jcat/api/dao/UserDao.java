package com.cg.jcat.api.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.jcat.api.entity.User;
import com.cg.jcat.api.exception.ExceptionMessages;
import com.cg.jcat.api.exception.JcatExceptions;
import com.cg.jcat.api.repository.IUserRepository;

@Component
public class UserDao {

	@Autowired
	private IUserRepository userRepository;

	public List<UserModel> getUsers() throws JcatExceptions {
		List<User> userList = new ArrayList<>();
		try {
			userList = userRepository.findAll();
		} catch (Exception e) {

			System.out.print(ExceptionMessages.GetUserDetails + e);
			throw new JcatExceptions(ExceptionMessages.GetUserDetails);
		}
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

	public boolean saveUser(UserModel userModel, String createdBy) {
		userModel.setCreatedBy(createdBy);
		userModel.setPassword("Cg@123");
		boolean value = false;
		try {
			if (saveUser(userModel)) {
				value = true;
			}
			return true;
		} catch (Exception e) {
			System.out.print(ExceptionMessages.SaveUsersToDB + e);
			return false;
		}
		// return findByUsername(userModel.getUsername());
	}

	public boolean saveUser(UserModel userModel) {
		try {
			if (userRepository.save(toUsers(userModel)) != null)
				return true;
		} catch (Exception e) {

		}
		return false;
	}

	public UserModel updateUsers(UserModel user, String modifiedBy) {
		return setUpdatedUser(user, modifiedBy);
	}

	public UserModel setUpdatedUser(UserModel user, String modifiedBy) {

		user.setModifiedBy(modifiedBy);
		try {
			saveUser(user);
			return toUserDao(findByUserId(user.getUserId()));
		} catch (Exception e) {
			System.out.print(ExceptionMessages.UpdateUser + e);
			return null;
		}

	}

	public boolean deleteById(int userId) {
		try {
			User user = findByUserId(userId);
			user.setDeleted(true);
			userRepository.save(user);
		} catch (Exception e) {
			System.out.print(ExceptionMessages.DeleteUser + e);
		}
		if (findByUserId(userId).isDeleted()) {
			return true;
		} else {
			return false;
		}
	}

	public UserModel findByUsername(String username) {
		try {
			return toUserDao(userRepository.findByUsername(username));
		} catch (Exception e) {
			System.out.print(ExceptionMessages.GetUserByName + e);
			return null;
		}
	}

	public User findByUserId(int userId) {
		try {
			return userRepository.findByUserId(userId);
		} catch (Exception e) {
			System.out.print(ExceptionMessages.GetUserById + e);
			return null;
		}

	}

	private User toUsers(UserModel userModel) {
		User users = new User();
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

	public boolean isExist(String userName) {
		try {
			if (findByUsername(userName) != null)
				return false;
		} catch (Exception e) {
			System.out.print(ExceptionMessages.CheckUserExists + e);
			return false;
		}
		return true;
	}

}
