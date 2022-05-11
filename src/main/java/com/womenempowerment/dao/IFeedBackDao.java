package com.womenempowerment.dao;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womenempowerment.controller.FeedbackController;
import com.womenempowerment.exception.FeedbackAddException;
import com.womenempowerment.exception.FeedbackNotFoundException;
import com.womenempowerment.model.FeedBack;
import com.womenempowerment.repository.IFeedbackRepository;
import com.womenempowerment.service.IFeedBackService;

/**
 * 
 * @Service annotation is used in your service layer and annotates classes that
 *          perform service tasks
 * 
 */
@Service
public class IFeedBackDao implements IFeedBackService {

	// injecting feedbackRepository
	@Autowired
	IFeedbackRepository fRepos;

	// creating a logger object from Feedback controller class
	Logger log = org.slf4j.LoggerFactory.getLogger(FeedbackController.class);

	// for adding a new Feedback
	@Override
	public FeedBack addFeedBack(FeedBack feedback) throws FeedbackAddException {

		if (fRepos.existsById(feedback.getFeedBackId())) {

			// since already present and it is ready to throw an exception before throwing
			// exception we are recording the error in logs file
			log.error("feedback already exists");
			throw new FeedbackAddException("Feedback with this ID already exists");

		}
		return fRepos.save(feedback);
	}

	// method for updating existing feedback
	@Override
	public FeedBack updateFeedBack(FeedBack feedback) throws FeedbackNotFoundException {

		if (fRepos.existsById(feedback.getFeedBackId())) {

			log.info("Updating");
			fRepos.deleteById(feedback.getFeedBackId());
			// deleting the existing one adding updated details with same id

			return fRepos.save(feedback);
		}
		// since feedback not present and it is ready to throw an exception before
		// throwing exception we are recording the error in logs file
		log.error("no such feedback exists to update");
		throw new FeedbackNotFoundException("There is no such feedback to update");
	}

	// for getting feedback with given Id
	@Override
	public FeedBack viewFeedBack(int feedbackId) throws FeedbackNotFoundException {

		if (fRepos.existsById(feedbackId)) {

			// FRepos.existsById(id) checks and compares each row with given id if matches
			// it will return or fetch or update we can do any operation
			log.info("Getting feedback with given Id");
			return fRepos.findById(feedbackId).get();

		}
		// since feedback with given Id present and it is ready to throw an exception
		// before throwing exception we are recording the error in logs file
		log.error("no such feedback with that Id");
		throw new FeedbackNotFoundException("Feedback not found");

	}

	// for getting all feedbacks
	@Override
	public List<FeedBack> viewAllFeedBack() throws FeedbackNotFoundException {

		List<FeedBack> feedbackList = fRepos.findAll();

		if (feedbackList.isEmpty()) {

			// since list is empty it will throw exception
			log.error("no feedbacks till now");
			throw new FeedbackNotFoundException("No Feedback found");

		}
		// if not empty it will show list of all existing feedbacks
		log.info("showing list of feedbacks");
		return feedbackList;
	}

	// for getting feedbacks with given Scheme name
	@Override
	public List<FeedBack> viewFeedBackBySchemeName(String schemeName) throws FeedbackNotFoundException {

		List<FeedBack> feedbackList = fRepos.viewFeedBackBySchemeName(schemeName);
		// FRepos.viewFeedBackBySchemeName(schemeName) query is written in repository
		// class

		if (feedbackList.isEmpty()) {

			log.error("no feedback with the scheme name");
			throw new FeedbackNotFoundException("No feedback found by this scheme name");

		}
		log.info("showing list of feedbacks with the given scheme name");
		return feedbackList;
	}

	// for getting feedback by given training course name
	@Override
	public List<FeedBack> viewFeedBackByTrainingCourseName(String trainingCourseName) throws FeedbackNotFoundException {

		List<FeedBack> feedbackList = fRepos.viewFeedBackByTrainingCourseName(trainingCourseName);

		if (feedbackList.isEmpty()) {

			log.error("No feedback found by this course name");
			throw new FeedbackNotFoundException("No feedback found by this course name");

		}

		log.info("showing list of feedbacks with the given coursename");
		return feedbackList;
	}

}
