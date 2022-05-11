package com.womenempowerment.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.womenempowerment.dao.ITraineeDao;
import com.womenempowerment.exception.TraineeCreationException;
import com.womenempowerment.exception.TraineeNotFoundException;
import com.womenempowerment.model.Trainee;

/**
 * RestController is a Spring annotation that is used to build REST API in a declarative way. 
 * RestController annotation is applied to a class to mark it as a request handler, 
 * and Spring will do the building and provide the RESTful web service at runtime.
 */
@RestController
public class TraineeController {
	
	// injecting dao class of Trainee
	@Autowired
	ITraineeDao tdao;

	// for adding a new Trainee
	@PostMapping(path = "/addTrainee")
	public Trainee addTrainee(@Valid @RequestBody Trainee trainee) throws TraineeCreationException {
		Trainee t = tdao.addTrainee(trainee);
		return t;
	}

	// for getting trainee with given Id
	@GetMapping(path = "/viewTrainee")
	public Trainee viewTrainee(@RequestParam int traineeId) throws TraineeNotFoundException {

		Trainee t = tdao.viewTrainee(traineeId);
		return t;
	}

	// for getting all the Trainees
	@GetMapping(path = "/viewAllTrainee")
	public List<Trainee> viewAllTrainee() throws TraineeNotFoundException {
		List<Trainee> t = tdao.viewAllTrainee();
		return t;
	}

	// for deleting a trainee with given ID
	@PostMapping(path = "/deleteTrainee")
	public void deleteTrainee(@RequestParam int traineeId) throws TraineeNotFoundException {
		tdao.deleteTrainee(traineeId);
	}

	// for searching and getting trainee with Aadhar
	@GetMapping(path = "/viewTraineeByAadhar")
	public Trainee viewTraineeByAadhar(long aadharNo) throws TraineeNotFoundException {
		return tdao.viewTraineeByAadhar(aadharNo);
	}

	// for updating existing Trainee
	@PutMapping(path = "/updateTrainee")
	public Trainee updateTrainee(@RequestBody Trainee trainee) throws TraineeNotFoundException {
		return tdao.updateTrainee(trainee);
	}

}
