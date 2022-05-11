package com.womenempowerment.dao;

import java.time.LocalDate;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womenempowerment.controller.SchemeController;
import com.womenempowerment.exception.SchemeException;
import com.womenempowerment.exception.SchemeNotFoundException;
import com.womenempowerment.model.Scheme;
import com.womenempowerment.repository.ISchemeRepository;
import com.womenempowerment.service.ISchemeService;

/*
* @Service annotation is used in your service layer and annotates classes that perform service tasks
*/
@Service
public class ISchemeDao implements ISchemeService {

	// Injecting SchemeRepository
	@Autowired
	ISchemeRepository sRepos;

	// creating a object of logger which is of schemeController class
	Logger log = org.slf4j.LoggerFactory.getLogger(SchemeController.class);

	// for adding new Scheme
	@Override
	public Scheme addScheme(Scheme scheme) throws SchemeException {
		if (sRepos.existsById(scheme.getSchemeId())) {

			// since already exists throws an exception
			log.error("Scheme with given Id already present");
			throw new SchemeException("This scheme is already introduced");
		}

		log.info("new scheme introduced");
		return sRepos.save(scheme);

	}

	// for updating existing scheme
	@Override
	public Scheme updateScheme(Scheme scheme) throws SchemeNotFoundException {
		if (sRepos.existsById(scheme.getSchemeId())) {

			// if scheme with given id is present we can update with our scheme
			log.info("updating scheme");
			return sRepos.save(scheme);
		}

		log.error("no scheme with scheme's id");
		throw new SchemeNotFoundException("Sorry this scheme is not present to update");
	}

	// for getting scheme with given ID
	@Override
	public Scheme viewScheme(int schemeId) throws SchemeNotFoundException {
		// existsById checks for each row and gives only matched row
		if (sRepos.existsById(schemeId)) {
			log.info("getting scheme with given Id");
			return sRepos.getById(schemeId);
		} else {
			log.error("no scheme with given ID");
			throw new SchemeNotFoundException("Sorry you have entered wrong schemeId");
		}

	}

	// for getting all the schemes list
	@Override
	public List<Scheme> viewAllScheme() throws SchemeNotFoundException {
		List<Scheme> list = sRepos.findAll();
		if (!list.isEmpty()) {
			log.info("getting schemes list");
			return list;
		} else {
			log.error("no schemes for now");
			throw new SchemeNotFoundException("Sorry there is no scheme");
		}
	}

	// deleting scheme with given Id
	@Override
	public void deleteScheme(int schemeId) throws SchemeNotFoundException {

		if (sRepos.existsById(schemeId)) {

			sRepos.deleteById(schemeId);// deleteById deletes the entire row from DB
			log.info("scheme dleted");

		} else {
			// since scheme present and it is ready to throw an exception before throwing
			// exception we are recording the error in logs file
			log.error("no such scheme with given ID");
			throw new SchemeNotFoundException("Sorry you have entered wrong schemeId");
		}
	}

	// getting list of schemes with given scheme Type
	@Override
	public List<Scheme> viewSchemesByType(String schemeType) throws SchemeNotFoundException {

		List<Scheme> list = sRepos.viewSchemesByType(schemeType);
		// query for fetching using schemeType written in repository class

		if (!list.isEmpty()) {

			log.info("list of schemes by SchemeType");
			return list;

		} else {

			log.error("schemes of given Type are not available");
			throw new SchemeNotFoundException("Sorry there is no scheme with that scheme Type");

		}
	}

	// getting schemes by launching date
	@Override
	public List<Scheme> viewSchemeByLaunchDate(LocalDate date) throws SchemeNotFoundException {

		List<Scheme> list = sRepos.viewSchemeByLaunchDate(date);// query for this is written in repository class
		if (!list.isEmpty()) {

			log.info("list of schemes by lauchDate");
			return list;

		} else {

			log.error("no schemes are available this date");
			throw new SchemeNotFoundException("Sorry there is no scheme with the given Date");

		}

	}
}
