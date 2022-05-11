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

import com.womenempowerment.dao.IFeedBackDao;
import com.womenempowerment.exception.FeedbackAddException;
import com.womenempowerment.exception.FeedbackNotFoundException;
import com.womenempowerment.model.FeedBack;

/*
 * RestController is a Spring annotation that is used to build REST API in a declarative way. 
 * RestController annotation is applied to a class to mark it as a request handler, 
 * and Spring will do the building and provide the RESTful web service at runtime.
 */
@RestController
public class FeedbackController {
//injecting Dao class
	@Autowired
	IFeedBackDao fdao;
	Logger log = org.slf4j.LoggerFactory.getLogger(FeedbackController.class);

	// for adding a new feedback
	@PostMapping(path = "/addFeedback")
	public FeedBack addFeedBack(@Valid @RequestBody FeedBack feedback) throws FeedbackAddException {
		FeedBack f = fdao.addFeedBack(feedback);
		if (f != null)
			// log.error will not get executed since it is throwing exception hence
			// implemented that logger part in all Dao classes
			log.info("feedback Added");
		return f;
	}

//checking and getting feedback by given name
	@GetMapping(path = "/viewFeedBackBySchemeName")
	public List<FeedBack> viewFeedBackBySchemeName(@RequestParam String schemeName) throws FeedbackNotFoundException {
		return fdao.viewFeedBackBySchemeName(schemeName);
	}

	// checking and getting feedback by given couresename
	@GetMapping(path = "/viewFeedBackByTrainingCourseName")
	public List<FeedBack> viewFeedBackByTrainingCourseName(@RequestParam String trainingCourseName)
			throws FeedbackNotFoundException {

		return fdao.viewFeedBackByTrainingCourseName(trainingCourseName);
	}

//for update Putmapping is used since we are editing already existing feedback
	@PutMapping(path = "/updateFeedBack")
	public FeedBack updateFeedBack(@RequestBody FeedBack feedback) throws FeedbackNotFoundException {
		return fdao.updateFeedBack(feedback);
	}

	// getting feedback with given ID/
	@GetMapping(path = "/viewFeedBack")
	public FeedBack viewFeedBack(@RequestParam int feedbackId) throws FeedbackNotFoundException {
		return fdao.viewFeedBack(feedbackId);
	}

//getting all the feedback that are recorded
	@GetMapping(path = "/viewAllFeedBack")
	public List<FeedBack> viewAllFeedBack() throws FeedbackNotFoundException {
		return fdao.viewAllFeedBack();
	}
}
