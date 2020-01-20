package com.selflearning.app.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.selflearning.app.DTO.NewUserDTO;
import com.selflearning.app.DTO.UserDTO;
import com.selflearning.app.exception.LoginIdAlreadyRegisteredException;
import com.selflearning.app.exception.UserLoginIdNotFoundException;
import com.selflearning.app.service.IUserService;

@Controller
@Validated
@RequestMapping("/api")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping
	public String home() {
		return "index.jsp";
	}

	@GetMapping(value = "/users")
	@ResponseBody
	public ResponseEntity<List<UserDTO>> getUsers() {

		List<UserDTO> userDTOs = userService.retrieveUsers();
		if (CollectionUtils.isEmpty(userDTOs)) {
			throw new UserLoginIdNotFoundException("No users found.");
		} else {
			return new ResponseEntity<List<UserDTO>>(userDTOs, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/user")
	@ResponseBody
	public ResponseEntity<UserDTO> getUser(
			@RequestParam("loginId") @Size(min = 2, message = "Login Id can't be less than 5 characters") String loginId)
			throws UserLoginIdNotFoundException {

		UserDTO userDTO = userService.retrieveUser(loginId);
		if (Objects.isNull(userDTO)) {
			System.out.println("User Name not found.");
			throw new UserLoginIdNotFoundException(loginId + " not found.");
		} else {
			System.out.println(userDTO.getFirstName());
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/createUser")
	@ResponseBody
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody NewUserDTO newUserDTO) {
		System.out.println("Got into Registration");

		UserDTO userDTO = userService.create(newUserDTO);
		if (Objects.isNull(userDTO)) {
			throw new LoginIdAlreadyRegisteredException(newUserDTO.getLoginId() + " is already registred.");
		} else {
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
		}
	}
}