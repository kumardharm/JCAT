package com.cg.jcat.api.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jcat.api.entity.User;
import com.cg.jcat.api.exception.JcatExceptions;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@TestPropertySource(
		  locations = "classpath:application-integrationtest.properties")
public class TestUserDao {
	
//	@Autowired
//	private TestEntityManager entityManager;
	
	@Autowired
	private UserDao userDao; 
	
//	@Autowired
//	private IUserRepository userRepository;
	
	@Test
//	@Ignore
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
		
		UserModel found = userDao.findByUsername(userModel.getUsername());
		assertNotNull(found);
		
		assertThat(found.getFirstName()).isEqualTo(userModel.getFirstName());
		assertThat(found.getUserEmail()).isEqualTo(userModel.getUserEmail());
	}
	
	@Test
//	@Ignore
	public void testgetUsers() throws JcatExceptions
	{
		UserModel userModel = new UserModel();
		userModel.setFirstName("ABC");
		userModel.setUserEmail("abc");
		userModel.setCreatedBy("raghu");
		userModel.setCompany("goldman");
		userModel.setAdmin(true);
		userModel.setPassword("asd@123");
		userModel.setModifiedBy("raj");
		
		userDao.saveUser(userModel,"ABC");
		
		assertEquals(1, userDao.getUsers().size());
	}
	
	@Test
	//@Ignore
	public void testdeleteById()
	{
		userDao.deleteById(1);
		User user = userDao.findByUserId(1);
		System.out.println(user);
		assertEquals(true, user.isDeleted());
	}
	
	@Test
	public void updateUsers()
	{
		
		UserModel userModel = new UserModel();
		userModel.setUserId(1);
		userModel.setFirstName("Hari");
		userModel.setLastName("ram");
		userModel.setUsername("sam4");
		userModel.setUserEmail("abcdef@gmail.com");
		userModel.setCreatedBy("raghu");
		userModel.setCompany("byarclay");
		userModel.setAdmin(true);
		userModel.setPassword("mnbv@123");
		userDao.saveUser(userModel,"ramesh");
		
		// updating email
		userModel.setUserEmail("dummyuser@cg.com");
		userDao.updateUsers(userModel,"alok");
		
		User user = userDao.findByUserId(1);
		assertEquals(userModel.getUserEmail(), user.getUserEmail());
		
	}
	
	

}
