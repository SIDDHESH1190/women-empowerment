package com.womenempowerment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.womenempowerment.model.NGO;

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
public interface INGORepository extends JpaRepository<NGO, Integer> {
	@Query(value = "select * from ngo_table where ngo_id=?", nativeQuery = true)
	NGO viewById(int ngoId);

	@Query(value = "select * from ngo_table where ngo_motive=?", nativeQuery = true)
	List<NGO> viewNGOByMotive(String motive);

	@Query(value = "select * from ngo_table where ngo_location=?", nativeQuery = true)
	List<NGO> viewNGOByLocation(String location);

}
