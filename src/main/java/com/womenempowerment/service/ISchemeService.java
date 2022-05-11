package com.womenempowerment.service;

import java.time.LocalDate;
import java.util.List;

import com.womenempowerment.exception.SchemeException;
import com.womenempowerment.exception.SchemeNotFoundException;
import com.womenempowerment.model.Scheme;

/**
 * 
 * Service interface for Scheme
 * 
 *
 */
public interface ISchemeService {
	Scheme addScheme(Scheme scheme) throws SchemeException;

	Scheme updateScheme(Scheme scheme) throws SchemeNotFoundException;

	Scheme viewScheme(int schemeId) throws SchemeNotFoundException;

	List<Scheme> viewAllScheme() throws SchemeNotFoundException;

	void deleteScheme(int schemeId) throws SchemeNotFoundException;

	List<Scheme> viewSchemesByType(String schemeType) throws SchemeNotFoundException;

	List<Scheme> viewSchemeByLaunchDate(LocalDate date) throws SchemeNotFoundException;
}
