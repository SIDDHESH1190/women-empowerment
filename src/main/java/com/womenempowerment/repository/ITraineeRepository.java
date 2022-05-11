package com.womenempowerment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.womenempowerment.model.Trainee;


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
public interface ITraineeRepository extends JpaRepository<Trainee, Integer> {

	@Query(value = "SELECT * FROM trainee WHERE aadhar_no=?1", nativeQuery = true)
	public Trainee getTraineeByAadhar(long aadharNo);
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query(value = "UPDATE trainee SET trainee=?1 WHERE trainee_id=?2",
	 * nativeQuery = true) public int updateTrainee(Trainee trainee, int traineeId);
	 */

}
