package com.cg.jcat.api.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jcat.api.entity.User;
import com.cg.jcat.api.repository.IUserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserDao {
	
	
	
	@Autowired
	private UserDao userDao; 
	
	@Autowired
	private IUserRepository userRepository;
	
	@Test
	@Ignore
	public void testsaveUser()
	{
		UserModel userModel = new UserModel();
		userModel.setFirstName("Hari");
		userModel.setLastName("ram");
		userModel.setUsername("sam");
		userModel.setUserEmail("abc@gmail.com");
		userModel.setCreatedBy("raghu");
		userModel.setCompany("goldman");
		userModel.setAdmin(true);
		userModel.setPassword("asd@123");
		userModel.setModifiedBy("raj");
		
		userDao.saveUser(userModel,"ramesh");
		
		assertNotNull(userDao.getUsers());
	}
	
	@Test
	@Ignore
	public void testgetUsers()
	{
		assertEquals(userDao.getUsers().size(), 2);
	}
	
	@Test
	@Ignore
	public void testdeleteById()
	{
		userDao.deleteById(1);
		Optional<User> user = userRepository.findById(1);
		System.out.println(user);
		assertNotNull(userRepository.findByIsDeleted(true));
	}
	
	@Test
	public void updateUsers()
	{
		
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
		
		userDao.updateUsers(userModel,"alok");
		
		User user = userRepository.findByUserId(1);
		assertEquals(user.getModifiedBy(),"alok");
		
	}
	
	

}
