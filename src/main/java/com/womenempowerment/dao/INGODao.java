package com.womenempowerment.dao;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womenempowerment.controller.NGOController;
import com.womenempowerment.exception.NGOCreationException;
import com.womenempowerment.exception.NGONotFoundException;

import com.womenempowerment.model.NGO;
import com.womenempowerment.repository.INGORepository;
import com.womenempowerment.service.INGOService;

/**
 * 
 * @Service annotation is used in your service layer and annotates classes that
 *          perform service tasks
 * 
 */

@Service
public class INGODao implements INGOService {

	// injecting Repository class of NGO
	@Autowired
	INGORepository ngoRepos;

	// creating log object of NGOcontroller class
	Logger log = org.slf4j.LoggerFactory.getLogger(NGOController.class);

	@Override
	public NGO addNGO(NGO ngo) throws NGOCreationException {

		if (ngoRepos.existsById(ngo.getNgoId())) {

			// since already present and it is ready to throw an exception before throwing
			// exception we are recording the error in logs file
			log.error("NGO already present");
			throw new NGOCreationException("NGO already exists");
		}

		// ready to add new NGO
		log.info("adding new NGO");
		return ngoRepos.save(ngo);
	}

	// for updating details of existing NGO
	@Override
	public NGO updateNGO(NGO ngo) throws NGONotFoundException {

		if (ngoRepos.existsById(ngo.getNgoId())) {

			// since already present we are recording the info in logs file
			log.info("Updating NGO");
			return ngoRepos.save(ngo);

		} else {

			// since NGO not present and it is ready to throw an exception before throwing
			// exception we are recording the error in logs file
			log.error("can't update since it already exists");
			throw new NGONotFoundException("Cannot update as NGO is not available");
		}
	}

	// for getting NGO with given ID
	@Override
	public NGO viewNGO(int ngoId) throws NGONotFoundException {

		if (ngoRepos.existsById(ngoId)) {

			// since already present we are recording the info in logs file
			log.info("giving NGO with given id");
			return ngoRepos.findById(ngoId).get();

		} else {

			log.error("No NGO with the given Id");

			throw new NGONotFoundException("No NGO available with the given ID");
		}
	}

	// for getting list of all NGOs
	@Override
	public List<NGO> viewAllNGO() throws NGONotFoundException {

		List<NGO> list = ngoRepos.findAll();

		if (list.isEmpty()) {
			// if list is empty it means no ngos or records or present
			log.error("no NGO's Records");
			throw new NGONotFoundException("No NGO available");

		}
		log.info("Showing list of Records");
		return list;// findall gives list of all available rows in NGO table
	}

	// for deleting NGO specific ID
	@Override
	public void deleteNGO(int ngoId) throws NGONotFoundException {

		if (ngoRepos.existsById(ngoId)) {

			log.info("Deleting the NGO with Id");
			// ngo is ready to delete hence we recoreded before and after deleting
			ngoRepos.deleteById(ngoId);
			log.info("deleted");
		} else {

			// since NGO not present and it is ready to throw an exception before throwing
			// exception we are recording the error in logs file

			log.error("no such NGO with given Id");
			throw new NGONotFoundException("No NGO available to delete");
		}

	}

	// for getting NGOs with given Motive
	@Override
	public List<NGO> viewNGOByMotive(String motive) throws NGONotFoundException {
		List<NGO> list = ngoRepos.viewNGOByMotive(motive);
		if (!list.isEmpty()) {

			log.info("list of NGO with motive");
			// ngoRepos.viewNGOByMotive(motive)query for fetching by motive is written in
			// repository class of NGO
			return ngoRepos.viewNGOByMotive(motive);
		} else {

			// since ngo with given location not present and it is ready to throw an
			// exception before throwing exception we are recording the error in logs file
			log.error("no NGO with given motive");
			throw new NGONotFoundException("No NGO Found with given motive" + motive);
		}
	}

	// for getting ngo at specified location
	@Override
	public List<NGO> viewNGOByLocation(String location) throws NGONotFoundException {
		List<NGO> list = ngoRepos.viewNGOByLocation(location);
		if (!list.isEmpty()) {

			// ngoRepos.viewNGOByLocation(location) query for fetching by location is
			// written in repository class of NGO
			log.info("getting ngos with given location");
			return ngoRepos.viewNGOByLocation(location);

		} else {

			// since ngo with given location not present and it is ready to throw an
			// exception before throwing exception we are recording the error in logs file
			log.error("no ngo with given location");
			throw new NGONotFoundException("No NGO is available with given location");

		}
	}

}
