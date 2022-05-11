package com.womenempowerment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@DecimalMin(value = "0", message = "Login ID should not be negative Value.")
	private int id;

	@NotBlank(message = "Username should not be empty")
	@Column(unique = true)
	private String username;

	@NotBlank(message = "Password should not be empty")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&-+=()])(?=.*[0-9])(?=\\S+$).{8,20}$", message = "Password is not following the convention")
	private String password;

	@NotBlank(message = "Security Question field should not be empty")
	private String secQuestion;

	@NotBlank(message = "Security Answer field should not be empty")
	private String secAnswer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecQuestion() {
		return secQuestion;
	}

	public void setSecQuestion(String secQuestion) {
		this.secQuestion = secQuestion;
	}

	public String getSecAnswer() {
		return secAnswer;
	}

	public void setSecAnswer(String secAnswer) {
		this.secAnswer = secAnswer;
	}

}