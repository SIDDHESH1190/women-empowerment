package com.womenempowerment.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name = "trainee")
public class Trainee {

	@Id // Specifies the primary key of an entity ie.traineeId.
	@DecimalMin(value = "0", message = "Trainee ID can't be negative value!")
	/*
	 * 
	 * 
	 * The annotated element must be a number whose value must be higher or equal to
	 * the specified minimum.Trainee ID can't be negative i.e. less than 0.
	 * 
	 * 
	 */
	private int traineeId;

	@NotBlank(message = "Username field cannot be empty.") // As userName is required field
	@Column(unique = true)
	private String userName;

	@NotBlank(message = "Password field cannot be empty.") // As password is required field
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&-+=()])(?=.*[0-9])(?=\\S+$).{8,20}$", message = "Password is not following the convention")
	private String password;

	@NotBlank(message = "Trainee FirstName field cannot be empty.")
	private String firstName;

	@NotBlank(message = "Trainee LastName field cannot be empty.")
	private String lastName;

	@DecimalMin(value = "1000000000", message = "Contact must be 10 digit long.")
	@DecimalMax(value = "9999999999", message = "Contact must be 10 digit long.")
	// To restrict user to give 10 digit contact number only.
	@Column(unique = true)
	private long contact;

	@Email(message = "Invalid Email. Please enter appropriate email")
	// General specified convention for email.
	@Column(unique = true)
	private String email;

	private String familyInfo;

	@DecimalMin(value = "100000000000", message = "Aadhar number must be 12 digit long.")
	@DecimalMax(value = "999999999999", message = "Aadhar number must be 12 digit long.")
	@Column(unique = true)
	private long aadharNo;

	@NotNull(message = "DOB field cannot be empty.") //Required field
	@Past(message = "Invalid date. DOB must be from past.")
	private LocalDate dob;

	@OneToOne(cascade = CascadeType.ALL)
	private TrainingCourse trainingCourse;

	@OneToOne(cascade = CascadeType.ALL)
	// Feedback for Trainee in one to one relation.
	private FeedBack feedBack;

}
