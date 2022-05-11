package com.womenempowerment.dao;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womenempowerment.controller.TrainingCourseController;
import com.womenempowerment.exception.TrainingCourseCreationException;
import com.womenempowerment.exception.TrainingCourseNotFoundException;
import com.womenempowerment.model.TrainingCourse;
import com.womenempowerment.repository.ITrainingCourseRepository;
import com.womenempowerment.service.ITrainingCourseService;

/**
 * 
 * @Service annotation is used in your service layer and annotates classes that
 *          perform service tasks
 * 
 */
@Service
public class ITrainingCourseDao implements ITrainingCourseService {

	// injecting TrainingCourse Repository
	@Autowired
	ITrainingCourseRepository tcRepos;

	// creating log object of Training Controller class
	Logger log = org.slf4j.LoggerFactory.getLogger(TrainingCourseController.class);

	// creating and adding new Training course
	@Override
	public TrainingCourse addTrainingCourse(TrainingCourse course) throws TrainingCourseCreationException {

		if (tcRepos.existsById(course.getTrainingCourseId())) {

			log.error("Training course Already Exists");
			// since already present and it is ready to throw an exception before throwing
			// exception we are recording the error in logs file
			throw new TrainingCourseCreationException("Training Course already available");
		}

		log.info("course added sucessfully");
		return tcRepos.save(course);
	}

	// for updating existing trainingCourse
	@Override
	public TrainingCourse updateTrainingCourse(TrainingCourse course) throws TrainingCourseNotFoundException {

		if (tcRepos.existsById(course.getTrainingCourseId())) {

			// checking and saving with by comparing with Id
			log.info("Updating course details");
			return tcRepos.save(course);
		}

		log.error("unable to update the course details");
		throw new TrainingCourseNotFoundException("Training Course not found For Update");
	}

	// getting course by id
	@Override
	public TrainingCourse viewTrainingCourse(int trainingCourseId) throws TrainingCourseNotFoundException {

		if (tcRepos.existsById(trainingCourseId)) {

			log.info("Training course with ID fetched sucessfully");
			return tcRepos.findById(trainingCourseId).get();
		}

		// since course with given Id present and it is ready to throw an exception
		// before throwing exception we are recording the error in logs file
		log.error("fetching of course with given Id not sucessfull");
		throw new TrainingCourseNotFoundException("Training Course Not Found");

	}

	// getting all Training Courses
	@Override
	public List<TrainingCourse> viewAllTrainingCourse() throws TrainingCourseNotFoundException {

		// findAll gives all rows of the entity table
		List<TrainingCourse> courseList = tcRepos.findAll();

		if (courseList.isEmpty()) {

			// if no rows present it means table empty
			// since no record present and it is ready to throw an exception before throwing
			// exception we are recording the error in logs file
			log.error("Fetching of all courses unsucessful");
			throw new TrainingCourseNotFoundException("No training courses found");

		}

		log.info("All training courses list are displayed");
		return courseList;
	}

	// deleting a specific Training Course with given Id
	@Override
	public void deleteTrainingCourse(int trainingCourseId) throws TrainingCourseNotFoundException {

		if (!tcRepos.existsById(trainingCourseId)) {

			log.error("deletion unsucessful");
			throw new TrainingCourseNotFoundException("Training Course Not Avalilable For Delete");

		}

		log.info("deletion of Training course is done");
		tcRepos.deleteById(trainingCourseId);
	}

	// getting list of training course with given Course name
	@Override
	public List<TrainingCourse> viewByTrainingCourseName(String courseName) throws TrainingCourseNotFoundException {

		List<TrainingCourse> list = tcRepos.findByName(courseName);
		if (list.isEmpty()) {

			log.error("Traing course with given name retrieval is unsucessful");
			throw new TrainingCourseNotFoundException("Training Course Not Found");

		}

		// findByname Query is written in Repository class TraineeCourse
		log.info("list of training courses with given Course name");
		return tcRepos.findByName(courseName);

	}

}
