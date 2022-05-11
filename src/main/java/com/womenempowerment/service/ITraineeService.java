package com.womenempowerment.service;

import java.util.List;

import com.womenempowerment.exception.TraineeCreationException;
import com.womenempowerment.exception.TraineeNotFoundException;
import com.womenempowerment.model.Trainee;

/**
 * 
 * Service interface for Trainee
 * 
 *
 */
public interface ITraineeService {
	public Trainee addTrainee(Trainee trainee) throws TraineeCreationException;

	public Trainee updateTrainee(Trainee trainee) throws TraineeNotFoundException;

	public Trainee viewTrainee(int traineeId) throws TraineeNotFoundException;

	public List<Trainee> viewAllTrainee() throws TraineeNotFoundException;

	public void deleteTrainee(int traineeId) throws TraineeNotFoundException;

	public Trainee viewTraineeByAadhar(long aadharNo) throws TraineeNotFoundException;

}
