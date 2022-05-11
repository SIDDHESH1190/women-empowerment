package com.womenempowerment;

import java.time.LocalDateTime;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.womenempowerment.exception.ErrorMessage;
import com.womenempowerment.exception.FeedbackAddException;
import com.womenempowerment.exception.FeedbackNotFoundException;
import com.womenempowerment.exception.InvalidUserException;
import com.womenempowerment.exception.NGONotFoundException;
import com.womenempowerment.exception.SchemeException;
import com.womenempowerment.exception.SchemeNotFoundException;
import com.womenempowerment.exception.TraineeCreationException;
import com.womenempowerment.exception.TraineeNotFoundException;
import com.womenempowerment.exception.TrainingCourseCreationException;
import com.womenempowerment.exception.TrainingCourseNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public @ResponseBody ErrorMessage checkTraineeValidation(MethodArgumentNotValidException e) {
		ErrorMessage e1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return e1;
	}

	@ExceptionHandler(TraineeCreationException.class)
	public @ResponseBody ErrorMessage checkTraineeCreationException(TraineeCreationException e) {
		ErrorMessage e1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return e1;
	}

	@ExceptionHandler(TraineeNotFoundException.class)
	public @ResponseBody ErrorMessage checkTraineeNotFoundException(TraineeNotFoundException e) {
		ErrorMessage e1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return e1;
	}

	@ExceptionHandler(TrainingCourseCreationException.class)
	public @ResponseBody ErrorMessage checkTrainingCourseCreationException(TrainingCourseCreationException e) {
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;

	}

	@ExceptionHandler(TrainingCourseNotFoundException.class)
	public @ResponseBody ErrorMessage checkTrainingCourseNotFoundException(TrainingCourseNotFoundException e) {
		ErrorMessage error2 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error2;

	}

	@ExceptionHandler(FeedbackAddException.class)
	public @ResponseBody ErrorMessage checkFeedbackCreationException(FeedbackAddException e) {
		ErrorMessage e1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return e1;
	}

	@ExceptionHandler(FeedbackNotFoundException.class)
	public @ResponseBody ErrorMessage checkFeedbackNotFoundException(FeedbackNotFoundException e) {
		ErrorMessage e1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return e1;
	}

	@ExceptionHandler(SchemeException.class)
	public @ResponseBody ErrorMessage checkInvalidBookException(SchemeException e)

	{
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}

	@ExceptionHandler(SchemeNotFoundException.class)
	public @ResponseBody ErrorMessage checkBookCreationException(SchemeNotFoundException e)

	{
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}

	@ExceptionHandler(NGONotFoundException.class)
	public @ResponseBody ErrorMessage checkNGONotFoundException(NGONotFoundException e)

	{
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	
	@ExceptionHandler(InvalidUserException.class)
	public @ResponseBody ErrorMessage checkInvalidUserException(InvalidUserException e)

	{
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}

}
