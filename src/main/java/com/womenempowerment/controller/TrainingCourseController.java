package com.womenempowerment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.womenempowerment.dao.ITrainingCourseDao;
import com.womenempowerment.exception.TrainingCourseCreationException;
import com.womenempowerment.exception.TrainingCourseNotFoundException;
import com.womenempowerment.model.TrainingCourse;

/*
 * RestController is a Spring annotation that is used to build REST API in a declarative way. 
 * RestController annotation is applied to a class to mark it as a request handler, 
 * and Spring will do the building and provide the RESTful web service at runtime.
 */
@RestController
public class TrainingCourseController {

	// Injecting TrainingCourse Dao
	@Autowired
	ITrainingCourseDao tcdao;

	// for adding a new TrainingCourse
	@PostMapping("/addTrainingCourse")
	public TrainingCourse addTrainingCourse(@Valid @RequestBody TrainingCourse course)
			throws TrainingCourseCreationException {
		return tcdao.addTrainingCourse(course);

	}

	// for updating Existing TrainingCourse
	@PostMapping("/updateTrainingCourse")
	public TrainingCourse updateTrainingCourse(@RequestBody TrainingCourse course)
			throws TrainingCourseNotFoundException {
		return tcdao.updateTrainingCourse(course);
	}

	// for getting TrainingCourse with given Id
	@GetMapping(path = "/viewTrainingCourse")
	public TrainingCourse viewTrainingCourse(@RequestParam int courseId) throws TrainingCourseNotFoundException {
		return tcdao.viewTrainingCourse(courseId);
	}

	// for viewing list of all existing Courses
	@GetMapping(path = "/viewAllTrainingCourse")
	public List<TrainingCourse> viewAllTrainingCourse() throws TrainingCourseNotFoundException {
		return tcdao.viewAllTrainingCourse();
	}

	// for deleting a specific TrainingCourse
	@PutMapping(path = "/deleteTrainingCourse")
	public void deleteTrainingCourse(@RequestParam int courseId) throws TrainingCourseNotFoundException {
		tcdao.deleteTrainingCourse(courseId);
	}

//for getting list of courses with given name
	@GetMapping(path = "/viewByTrainingCourseName")
	public List<TrainingCourse> viewByTrainingCourseName(@RequestParam String courseName)
			throws TrainingCourseNotFoundException {
		return tcdao.viewByTrainingCourseName(courseName);
	}
}
