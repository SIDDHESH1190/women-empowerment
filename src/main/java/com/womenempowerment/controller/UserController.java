package com.womenempowerment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.womenempowerment.dao.IUserDao;
import com.womenempowerment.exception.InvalidUserException;
import com.womenempowerment.model.User;

/*
 * RestController is a Spring annotation that is used to build REST API in a declarative way. 
 * RestController annotation is applied to a class to mark it as a request handler, 
 * and Spring will do the building and provide the RESTful web service at runtime.
 */
@RestController
public class UserController {
	// Injecting UserDao
	@Autowired
	IUserDao udao;

	// for newly registered user
	@PostMapping(path = "/registerUser")
	public User registerUser(@Valid @RequestBody User user) throws InvalidUserException {
		return udao.registerUser(user);
	}

	// for already existing user
	@GetMapping(path = "/login")
	public User login(@RequestParam String username, String password) throws InvalidUserException {
		return udao.login(username, password);
	}

	// URL if forgot password
	@GetMapping(path = "/forgotPassword")
	public User forgotPassword(@RequestParam int id) throws InvalidUserException {
		return udao.forgotPassword(id);
	}
}
