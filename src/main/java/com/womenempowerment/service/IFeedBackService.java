package com.womenempowerment.service;

import java.util.List;

import com.womenempowerment.exception.FeedbackAddException;
import com.womenempowerment.exception.FeedbackNotFoundException;
import com.womenempowerment.model.FeedBack;

/**
 * 
 * Service interface for Feedback
 * 
 *
 */
public interface IFeedBackService {
	public FeedBack addFeedBack(FeedBack feedback) throws FeedbackAddException;

	public FeedBack updateFeedBack(FeedBack feedback) throws FeedbackNotFoundException;

	public FeedBack viewFeedBack(int feedbackId) throws FeedbackNotFoundException;

	public List<FeedBack> viewAllFeedBack() throws FeedbackNotFoundException;

	public List<FeedBack> viewFeedBackBySchemeName(String schemeName) throws FeedbackNotFoundException;

	public List<FeedBack> viewFeedBackByTrainingCourseName(String trainingCourseName) throws FeedbackNotFoundException;
}
