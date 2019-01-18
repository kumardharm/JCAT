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
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jcat.api.dao.UserDao;
import com.cg.jcat.api.dao.UserModel;
import com.cg.jcat.api.exception.JcatExceptions;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(
		  locations = "classpath:application-integrationtest.properties")
public class TestUserService {
	
	@Autowired
	private UserService userService;
	
//	@MockBean
//	private UserDao userDao;
	
	@Autowired
	private UserDao userDao;
	
	@Test
	@Ignore
	public void testGetUsers() throws JcatExceptions
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
		Mockito.when(userDao.saveUser(userModel,"admin")).thenReturn(true);
		assertEquals(true, userService.saveUser(userModel,"admin"));
//		assertThat(userService.saveUser(userModel,"admin")).isEqualTo(userModel);
		
	}
	
	@Test
	public void testsaveUser()
	{
		UserModel userModel = new UserModel();
		userModel.setFirstName("Hari");
		userModel.setLastName("ram");
		userModel.setUsername("sam2");
		userModel.setUserEmail("abc@gmail.com");
		userModel.setCreatedBy("raghu");
		userModel.setCompany("goldman");
		userModel.setAdmin(true);
		userModel.setPassword("asd@123");
		userModel.setModifiedBy("raj");
		
		userService.saveUser(userModel,"ramesh");
		
		UserModel found = userDao.findByUsername(userModel.getUsername());
		assertNotNull(found);
		
		assertThat(found.getFirstName()).isEqualTo(userModel.getFirstName());
		assertThat(found.getUserEmail()).isEqualTo(userModel.getUserEmail());
	}
	
	@Test
	@Ignore
	public void testUpdateUsers()
	{
		UserModel userModel = getModel();
		Mockito.when(userDao.findByUsername(userModel.getUsername())).thenReturn(userModel);
		userModel.setCompany("cg");
		Mockito.when(userDao.saveUser(userModel,"admin")).thenReturn(true);
		assertThat(userService.updateUsers(userModel, "admin")).isEqualTo(userModel);
	}
	
	@Ignore
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
		userModel.setModifiedBy("admin");
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
