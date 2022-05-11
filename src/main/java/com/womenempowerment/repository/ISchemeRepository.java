package com.womenempowerment.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.womenempowerment.model.Scheme;


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
public interface ISchemeRepository extends JpaRepository<Scheme, Integer> {
	@Query(value = "select * from scheme where scheme_type=?1", nativeQuery = true)
	List<Scheme> viewSchemesByType(String schemeType);

	@Query(value = "select * from scheme where scheme_launch_date=?1", nativeQuery = true)
	public List<Scheme> viewSchemeByLaunchDate(LocalDate date);

	@Transactional
	@Modifying
	@Query(value = "update Scheme s set s=?1")
	public int updateScheme(Scheme scheme);
}
