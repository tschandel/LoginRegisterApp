package com.selflearning.app.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class NewUserDTO {

	@NotEmpty(message = "First Name can't be empty")
	@Size(min = 5, max = 30, message = "firstName should be between 5 and 30 characters")
	private String firstName;

	@NotEmpty(message = "Last Name can't be empty")
	@Size(min = 5, max = 30, message = "lastName should be between 5 and 30 characters")
	private String lastName;

	@NotEmpty(message = "Login Id can't be empty")
	@Size(min = 5, max = 30, message = "loginId should be between 5 and 30 characters")
	private String loginId;

	@NotEmpty(message = "Password can't be empty")
	@Size(min = 2, max = 30, message = "password should be between 5 and 30 characters")
	private String password;

	private String place;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}

