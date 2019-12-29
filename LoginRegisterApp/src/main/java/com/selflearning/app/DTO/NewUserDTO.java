package com.selflearning.app.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class NewUserDTO {

	@NotEmpty(message = "First Name can't be empty")
	@Min(5)
	@Max(30)
	private String firstName;

	@NotEmpty(message = "Last Name can't be empty")
	@Min(5)
	@Max(30)
	private String lastName;

	@NotEmpty(message = "Login Id can't be empty")
	@Min(5)
	@Max(30)
	private String loginId;

	@NotEmpty(message = "Password can't be empty")
	@Min(2)
	@Max(30)
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

