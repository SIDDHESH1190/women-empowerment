package com.womenempowerment.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "trainingcourse")
public class TrainingCourse {

	@Id
	@DecimalMin(value = "0", message = "Training Course ID can't be negative value!")
	int trainingCourseId;

	@NotBlank(message = "Course Name Should Not be Blank")
	String courseName;

	String courseDuration;

	@NotNull(message = "Start Date field cannot be NULL")
	LocalDate startingDate;

	@NotNull(message = "End Date field cannot be NULL")
	LocalDate endingDate;

	@Enumerated(EnumType.STRING)
	courseCompletionStatusenum courseCompletionStatus;

}
