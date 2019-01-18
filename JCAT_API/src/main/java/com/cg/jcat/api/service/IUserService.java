package com.cg.jcat.api.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.cg.jcat.api.dao.UserModel;
import com.cg.jcat.api.exception.JcatExceptions;

@Service
public interface IUserService {

	public List<UserModel> getUsers() throws JcatExceptions;

	public boolean saveUser(UserModel user, String createdBy);

	public UserModel updateUsers(UserModel user, String modifiedBy);

	public boolean deleteById(int userId);

	public boolean isExist(String userName);

}
