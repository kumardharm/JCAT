package com.cg.jcat.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jcat.api.dao.UserDao;
import com.cg.jcat.api.dao.UserModel;
import com.cg.jcat.api.repository.IUserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserDao userDao;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Test
	@Ignore
	public void testGetUsers()
	{
		UserModel userModel = getModel();
		List<UserModel> userModelList = new ArrayList<UserModel>();
		userModelList.add(userModel);
		
		Mockito.when(userDao.getUsers()).thenReturn(userModelList);
		
		assertNotNull(userService.getUsers());
		assertThat(userService.getUsers()).isEqualTo(userModelList);
	}
	
	@Ignore
	@Test
	public void testSaveUser()
	{
		UserModel userModel = getModel();
		Mockito.when(userDao.saveUser(userModel,"admin")).thenReturn(userModel);
		
		assertThat(userService.saveUser(userModel,"admin")).isEqualTo(userModel);
		
	}
	
	@Test
	@Ignore
	public void testUpdateUsers()
	{
		UserModel userModel = getModel();
		Mockito.when(userDao.findByUsername(userModel.getUsername())).thenReturn(userModel);
		userModel.setCompany("cg");
		Mockito.when(userDao.saveUser(userModel,"admin")).thenReturn(userModel);
		assertThat(userService.updateUsers(userModel, "admin")).isEqualTo(userModel);
	}
	
	@Test
	public void testDeleteUser()
	{
		UserModel userModel = getModel();
		Mockito.when(userDao.findByUsername(userModel.getUsername())).thenReturn(userModel);
				
		Mockito.when(userDao.deleteById(userModel.getUserId())).thenReturn(true);
//		assertThat(userService.deleteById(userModel.getUserId()).isEqualTo(true);
//		assertEquals(userService.deleteById(userModel.getUserId()),true);
		 assertTrue(userService.deleteById(userModel.getUserId()));
	}
	
	private UserModel getModel() {
		
		UserModel userModel = new UserModel();
		userModel.setUserId(1);
		userModel.setFirstName("Hari");
		userModel.setLastName("ram");
		userModel.setUsername("sam");
		userModel.setUserEmail("abcdef@gmail.com");
		userModel.setCreatedBy("raghu");
		userModel.setCompany("byarclay");
		userModel.setAdmin(true);
		userModel.setPassword("mnbv@123");
		return userModel;
	}
	
	

}
