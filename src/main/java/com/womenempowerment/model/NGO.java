package com.womenempowerment.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "ngo_table")
public class NGO {
	@Id
	@DecimalMin(value = "1", message = "NGO should contain minimum value 1")
	int ngoId;

	@NotBlank(message = "NGO name cannot be empty")
	String ngoName;

	@NotBlank(message = "NGO location cannot be empty")
	String ngoLocation;

	@NotBlank(message = "NGO Type cannot be empty")
	String ngoType;

	@NotBlank(message = "NGO Motive cannot be empty")
	String ngoMotive;

	double donation;

	@DecimalMin(value="100",message="NGO size should be more than 100")
	int ngoSize;

	@NotBlank(message = "NGO should contain Activities")
	String ngoActivities;

	@OneToOne(cascade = CascadeType.ALL)
	TrainingCourse trainingCourse;

}
