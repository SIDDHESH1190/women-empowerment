package com.womenempowerment.service;

import java.util.List;

import com.womenempowerment.exception.TrainingCourseCreationException;
import com.womenempowerment.exception.TrainingCourseNotFoundException;
import com.womenempowerment.model.TrainingCourse;

/**
 * 
 * Service interface for Training course
 * 
 *
 */
public interface ITrainingCourseService {
	public TrainingCourse addTrainingCourse(TrainingCourse course) throws TrainingCourseCreationException;

	public TrainingCourse updateTrainingCourse(TrainingCourse course) throws TrainingCourseNotFoundException;

	public TrainingCourse viewTrainingCourse(int courseId) throws TrainingCourseNotFoundException;

	public List<TrainingCourse> viewAllTrainingCourse() throws TrainingCourseNotFoundException;

	public void deleteTrainingCourse(int courseId) throws TrainingCourseNotFoundException;

	public List<TrainingCourse> viewByTrainingCourseName(String courseName) throws TrainingCourseNotFoundException;

}
