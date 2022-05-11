package com.womenempowerment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.womenempowerment.model.User;


/**
 * 
 * @Repository Annotation is a specialization of @Component annotation which is
 *             used to indicate that the class provides the mechanism for
 *             storage, retrieval, update, delete and search operation on
 *             objects
 * 
 *
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM user_table WHERE username=?1", nativeQuery = true)
	User getUserByUsername(String username);

}
