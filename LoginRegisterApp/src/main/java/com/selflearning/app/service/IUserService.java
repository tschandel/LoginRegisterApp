package com.selflearning.app.service;

import java.util.List;

import com.selflearning.app.DTO.NewUserDTO;
import com.selflearning.app.DTO.UserDTO;

public interface IUserService {

	public UserDTO retrieveUser(String loginId);
	
	public List<UserDTO> retrieveUsers();
	
	public UserDTO create(NewUserDTO newUserDTO);
}
