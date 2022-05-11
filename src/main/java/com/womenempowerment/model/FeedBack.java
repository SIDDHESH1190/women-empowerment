package com.womenempowerment.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "feedback")
public class FeedBack {
	@Id
	@DecimalMin(value = "0", message = "Feedback ID can't be negative value!")
	private int feedBackId;

	@DecimalMin(value = "0", message = "Scheme rating should between 0 to 5")
	@DecimalMax(value = "5", message = "Scheme rating should between 0 to 5")
	private int schemeRating;

	@DecimalMin(value = "0", message = "Scheme training rating should between 0 to 5")
	@DecimalMax(value = "5", message = "Scheme training rating should between 0 to 5")
	private int schemeTrainingRating;

	@DecimalMin(value = "0", message = "Overall rating should between 0 to 5")
	@DecimalMax(value = "5", message = "Overall rating should between 0 to 5")
	private int overallRating;

	private String comments;

	@NotNull(message = "Date need to be given cannot be NULL")
	private LocalDate feedbackdate;

	@OneToOne
	@JoinColumn(name = "training_Id")
	private TrainingCourse trainingCourse;

	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	private Scheme scheme;

}
