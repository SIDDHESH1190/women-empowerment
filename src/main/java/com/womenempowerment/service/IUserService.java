package com.womenempowerment.service;

import com.womenempowerment.exception.InvalidUserException;
import com.womenempowerment.model.User;

/**
 * 
 * Service interface for User
 * 
 *
 */
public interface IUserService {
	public User registerUser(User user) throws InvalidUserException;

	public User login(String username, String password) throws InvalidUserException;

	public User forgotPassword(int id) throws InvalidUserException;

}
