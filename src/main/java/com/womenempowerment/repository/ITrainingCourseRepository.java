package com.womenempowerment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.womenempowerment.model.TrainingCourse;


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
public interface ITrainingCourseRepository extends JpaRepository<TrainingCourse, Integer>{
	
	@Query(value = "select * from trainingcourse where course_name = ?1",nativeQuery = true)
	public List<TrainingCourse> findByName(String name);

}
