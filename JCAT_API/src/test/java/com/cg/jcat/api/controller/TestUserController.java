package com.cg.jcat.api.controller;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.RequestBuilder;
import com.cg.jcat.api.dao.UserModel;
import com.cg.jcat.api.service.IUserService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TestUserController {
	
	@MockBean
	private IUserService userService;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testgetUsers() throws Exception
	{
//		String url = "/user/getAll";
//		
//		UserModel userModel = new UserModel();
//		userModel.setUserId(1);
//		userModel.setFirstName("Hari");
//		userModel.setLastName("ram");
//		userModel.setUsername("sam");
//		userModel.setUserEmail("abcdef@gmail.com");
//		userModel.setCreatedBy("raghu");
//		userModel.setCompany("byarclay");
//		userModel.setAdmin(true);
//		userModel.setPassword("mnbv@123");
//		userModel.setModifiedBy("alok");
//		
//		List<UserModel> userModelList = new ArrayList<>();
//		userModelList.add(userModel);
//	
//		Mockito.when(userService.getUsers()).thenReturn(userModelList);
//		
//		org.springframework.test.web.servlet.RequestBuilder  requestBuilder = MockMvcRequestBuilders.get(url);
//		
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		List<UserModel> userModelListExcepted = (List<UserModel>) result;
//		ObjectMapper objectMapper = new ObjectMapper();
//	    
//		String userModelList1 = objectMapper.writeValueAsString(userModelList);
//		String userModelListExcepted1 = objectMapper.writeValueAsString(userModelListExcepted);
//		
//		
//		assertEquals(userModelListExcepted1, userModelList1);
//		assertThat(userModelListExcepted1).isEqualTo(userModelList1);
		
		UserModel userModel = getModel();
		List<UserModel> userModelList = new ArrayList<UserModel>();
		userModelList.add(userModel);
		
		Mockito.when(userService.getUsers()).thenReturn(userModelList);
		String url = "/user/getAll";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		//String expectedJson = this.mapToJson(userModelList);
		
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
