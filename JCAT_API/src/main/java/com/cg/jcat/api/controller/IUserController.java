package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.jcat.api.dao.UserModel;

@RestController
@RequestMapping("/user")
public interface IUserController {
	
	
	@GetMapping("/getAll")
	public List<UserModel> getUsers();
	
	@PostMapping("/create/{createdBy}")
	public boolean saveUser(@PathVariable String createdBy, @RequestBody UserModel user);
	
	@PutMapping("/update/{modifiedBy}")
	public void updateUserId(@PathVariable String modifiedBy, @RequestBody UserModel user);
	
	@DeleteMapping("/delete/{userId}")
	public void deleteById(@PathVariable int userId);

	
}
