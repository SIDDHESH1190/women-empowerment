package com.womenempowerment.controller;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.womenempowerment.dao.ISchemeDao;
import com.womenempowerment.exception.SchemeException;
import com.womenempowerment.exception.SchemeNotFoundException;
import com.womenempowerment.model.Scheme;

/*
 * RestController is a Spring annotation that is used to build REST API in a declarative way. 
 * RestController annotation is applied to a class to mark it as a request handler, 
 * and Spring will do the building and provide the RESTful web service at runtime.
 */
@RestController
public class SchemeController {
	@Autowired
	ISchemeDao sdao;

	// adding a new Scheme
	@PostMapping("/AddingNewScheme")
	Scheme addScheme(@Valid @RequestBody Scheme scheme) throws SchemeException {

		return sdao.addScheme(scheme);
	}

	// updating the details of existing scheme
	@PutMapping("/updatingScheme")
	public Scheme updateScheme(@RequestBody Scheme scheme) throws SchemeNotFoundException {

		return sdao.updateScheme(scheme);
	}

	// getting scheme by given Id
	@GetMapping("/viewingSchemesById")
	Scheme viewScheme(@RequestParam int schemeId) throws SchemeNotFoundException {

		return sdao.viewScheme(schemeId);
	}

	// getting schemes with given Scheme Type
	@GetMapping("/viewingSchemesBySchemeType")
	List<Scheme> viewSchemesByType(@RequestParam String schemeType) throws SchemeNotFoundException {

		return sdao.viewSchemesByType(schemeType);
	}

	// for getting schemes which having given launchDate by user
	@GetMapping("/viewingSchemesByLaunchDate")
	public List<Scheme> viewSchemeByLaunchDate(@RequestParam String date) throws SchemeNotFoundException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);

		return sdao.viewSchemeByLaunchDate(localDate);
	}

	// to get list of all existing schemes
	@GetMapping("/GettingAllSchemes")
	public List<Scheme> viewAllScheme() throws SchemeNotFoundException {

		return sdao.viewAllScheme();
	}

	// for deleting schemes with given Id
	@DeleteMapping("/DeletingaScheme")
	public void deleteScheme(@RequestParam int schemeId) throws SchemeNotFoundException {

		sdao.deleteScheme(schemeId);
	}
}
