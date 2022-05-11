package com.womenempowerment.dao;

import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womenempowerment.controller.UserController;
import com.womenempowerment.exception.InvalidUserException;
import com.womenempowerment.model.User;
import com.womenempowerment.repository.IUserRepository;
import com.womenempowerment.service.IUserService;

/*
 * @Service annotation is used in your service layer and annotates classes that perform service tasks
 */
@Service
public class IUserDao implements IUserService {

	// Injecting UserRepository
	@Autowired
	IUserRepository uRepos;

	// creating a log object of UserController
	Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

	// adding a new user
	@Override
	public User registerUser(User user) throws InvalidUserException {
		if (uRepos.existsById(user.getId())) {
			
			// since already present and it is ready to throw an exception before throwing
			// exception we are recording it in log file
			log.error("user already exists adding with same login ID not possible");
			throw new InvalidUserException("This login id already available");
		}

		log.info("new registration of user sucessful");
		return uRepos.save(user);
	}

	// logging in
	@Override
	public User login(String username, String password) throws InvalidUserException {

		User u = uRepos.getUserByUsername(username);

		if (u != null) {
			if (u.getPassword().equals(password)) {

				log.info("entered valid details login done");
				return u;
			}
		}

		log.error("login Unsucessful");
		throw new InvalidUserException("Login failed");
	}

	// for forgot password
	@Override
	public User forgotPassword(int id) throws InvalidUserException {

		Scanner input = new Scanner(System.in);
		User u = uRepos.getById(id);

		if (u != null) {

			// checking for authentication by matching security Q/A
			System.out.println(u.getSecQuestion());
			String answer = input.nextLine();

			if (answer.equals(u.getSecAnswer())) {
				System.out.println("Enter new password");
				String newpass = input.nextLine();
				u.setPassword(newpass);

				log.info("password changed sucesfully");
				return uRepos.save(u);
			}

			log.error("entered worng answers for security question");
			throw new InvalidUserException("Wrong answer!!");

		}

		log.error("invalid details of Id");
		throw new InvalidUserException("There is not any user with this username");
	}

}
