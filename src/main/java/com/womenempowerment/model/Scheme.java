package com.womenempowerment.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "scheme")
public class Scheme {
	@Id
	@DecimalMin(value = "0", message = "Scheme id shouldn't be negative value")
	int schemeId;

	@NotBlank(message = "scheme name should not be blank")
	String schemeName;

	@NotBlank(message = "scheme Type should not be blank")
	String schemeType;

	@NotNull(message = "scheme Launch Date should not be NULL")
	LocalDate schemeLaunchDate;

	String schemeEligibility;

	String schemeObjective;

	@OneToOne(fetch = FetchType.EAGER)
	TrainingCourse trainingCourse;

}
