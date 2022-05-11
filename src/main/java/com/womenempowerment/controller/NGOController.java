package com.womenempowerment.controller;

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
import com.womenempowerment.dao.INGODao;
import com.womenempowerment.exception.NGOCreationException;
import com.womenempowerment.exception.NGONotFoundException;
import com.womenempowerment.model.NGO;

/**
 * RestController is a Spring annotation that is used to build REST API in a declarative way. 
 * RestController annotation is applied to a class to mark it as a request handler, 
 * and Spring will do the building and provide the RESTful web service at runtime.
 */
@RestController
public class NGOController {
	// injecting NGO's controller with INGOdao
	@Autowired
	INGODao ngoDao;

	// for adding a new NGO
	@PostMapping(path = "/addNGO")
	public NGO addNGO(@RequestBody NGO ngo) throws NGOCreationException {
		return ngoDao.addNGO(ngo);
	}

	// for updating the existing NGO
	@PutMapping(path = "/updateNGO")
	public NGO updateNGO(@RequestBody NGO ngo) throws NGONotFoundException {
		return ngoDao.updateNGO(ngo);
	}

	// for getting all existing NGO's
	@GetMapping(path = "/viewAllNGO")
	public List<NGO> viewallNGO() throws NGONotFoundException {
		return ngoDao.viewAllNGO();
	}

	// for getting NGO with given NGO Id
	@GetMapping(path = "/viewNGOById")
	public NGO viewNGOById(@RequestParam int id) throws NGONotFoundException {
		return ngoDao.viewNGO(id);
	}

	// for getting NGOs by motive perspective
	@GetMapping(path = "/viewNGOByMotive")
	public List<NGO> viewNGOByMotive(@RequestParam String motive) throws NGONotFoundException {
		return ngoDao.viewNGOByMotive(motive);
	}

	// for deleting a specific NGO with given ID
	@DeleteMapping(path = "/deleteNGOById")
	public void deleteNGOById(@RequestParam int id) throws NGONotFoundException {
		ngoDao.deleteNGO(id);
	}

	// for getting NGOs with given location
	@GetMapping(path = "/viewNGOByLocation")
	public List<NGO> viewNGOByLocation(@RequestParam String location) throws NGONotFoundException {
		return ngoDao.viewNGOByLocation(location);
	}

}
