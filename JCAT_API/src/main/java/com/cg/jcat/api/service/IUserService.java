package com.cg.jcat.api.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.cg.jcat.api.dao.UserModel;

@Service
public interface IUserService {

	public List<UserModel> getUsers();

	public void saveUser(UserModel user, String createdBy);

	public void updateUsers(UserModel user, String modifiedBy);

	public void deleteById(int userId);

}
