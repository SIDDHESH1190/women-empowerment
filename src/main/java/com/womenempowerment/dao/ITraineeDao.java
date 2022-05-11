package com.womenempowerment.dao;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womenempowerment.controller.TraineeController;
import com.womenempowerment.exception.TraineeCreationException;
import com.womenempowerment.exception.TraineeNotFoundException;
import com.womenempowerment.model.Trainee;
import com.womenempowerment.repository.ITraineeRepository;
import com.womenempowerment.service.ITraineeService;

/**
 * 
 * @Service annotation is used in your service layer and annotates classes that
 *          perform service tasks
 * 
 */
@Service
public class ITraineeDao implements ITraineeService {

	// injecting TrainRepository
	@Autowired
	ITraineeRepository tRepos;

	// Creating log object
	Logger log = org.slf4j.LoggerFactory.getLogger(TraineeController.class);

	@Override
	public Trainee addTrainee(Trainee trainee) throws TraineeCreationException {
		if (tRepos.existsById(trainee.getTraineeId())) {

			// since already present and it is ready to throw an exception before throwing
			// exception we are recording the error in logs file

			log.error("Trainee Already Exists");
			throw new TraineeCreationException("This trainee is already available");
		}

		log.info("Trainee added suceessfully");
		return tRepos.save(trainee);
	}

	// Updating Trainee existing One
	@Override
	public Trainee updateTrainee(Trainee trainee) throws TraineeNotFoundException {

		if (tRepos.existsById(trainee.getTraineeId())) {

			// Searching and then saving the same row by using Id parameter
			log.info("Trainee Updated");
			return tRepos.save(trainee);
		} else {

			// Trainee is not present and it is ready to throw an exception before throwing
			// exception we are recording the error in logs file
			log.error("updating unsucessful");
			throw new TraineeNotFoundException("There is no such Trainee to update");
		}

	}

	// getting Trainee with given Id
	@Override
	public Trainee viewTrainee(int traineeId) throws TraineeNotFoundException {

		// fetching using Given Id
		if (!tRepos.existsById(traineeId)) {

			log.error("getting Trainee By id is unsucessful");
			throw new TraineeNotFoundException("There is no such Trainee");
		}

		log.info("Retreiving Done");
		return tRepos.findById(traineeId).get();
	}

	// getting All Trainees
	@Override
	public List<Trainee> viewAllTrainee() throws TraineeNotFoundException {

		List<Trainee> traineeList = tRepos.findAll();// find all gives all rows that are available
		if (traineeList.isEmpty()) {

			// list empty means no trainee are available
			// since list is empty and it is ready to throw an exception before throwing
			// exception we are recording the error in logs file
			log.error("no trainees to show");
			throw new TraineeNotFoundException("No trainees found");
		}

		log.info("Trainee List is shown Sucessfully");
		return traineeList;
	}

	// deleting a trainee with given Id
	@Override
	public void deleteTrainee(int traineeId) throws TraineeNotFoundException {

		if (!tRepos.existsById(traineeId)) {
			log.error("no such trainee for deleting");
			throw new TraineeNotFoundException("There is no such trainee cannot delete");
		}
		log.info("deletion of trainee Successfull");
		tRepos.deleteById(traineeId);

	}

	// getting Trainee with adhar
	@Override
	public Trainee viewTraineeByAadhar(long aadharNo) throws TraineeNotFoundException {

		// query is written Trainee Repository class
		Trainee t = tRepos.getTraineeByAadhar(aadharNo);

		if (t == null) {

			log.error("no trainee with given Aadhar number");
			throw new TraineeNotFoundException("There is no such trainee with this aadhar number");
		}
		
		log.info("trainee with given Aadhar number");
		return t;
	}

}
