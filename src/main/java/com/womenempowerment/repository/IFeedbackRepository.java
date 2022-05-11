package com.womenempowerment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.womenempowerment.model.FeedBack;

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
public interface IFeedbackRepository extends JpaRepository<FeedBack, Integer> {

	@Query(value = "SELECT * FROM feedback f WHERE f.training_id IN (SELECT tc.training_course_id FROM trainingcourse tc WHERE tc.course_name=?1)", nativeQuery = true)
	List<FeedBack> viewFeedBackByTrainingCourseName(String trainingCourseName);

	@Query(value = "SELECT * FROM feedback f WHERE f.scheme_scheme_id IN (SELECT s.scheme_id FROM scheme s WHERE s.scheme_name=?1)", nativeQuery = true)
	List<FeedBack> viewFeedBackBySchemeName(String schemeName);
}
