package com.womenempowerment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import org.aspectj.weaver.ast.Not;

import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@DecimalMin(value = "0",message =" Admin Login ID should not be negative Value.")
	private int adminId;

	@NotBlank //Required Field
	private String adminUsername;

	@NotBlank //Required Field
	private String adminPassword;
}
