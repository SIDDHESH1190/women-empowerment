package com.womenempowerment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.womenempowerment.model.User;

//this interface extends the CrudRepository interface from Spring Data JPA.

public interface UserRepository extends CrudRepository<User, Long> {

	// declare the getUserByUsername() method with an embedded query to select user
	// details by username.
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getUserByUsername(@Param("username") String username);
}