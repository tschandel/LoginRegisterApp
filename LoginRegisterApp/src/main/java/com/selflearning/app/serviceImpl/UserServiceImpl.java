package com.selflearning.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selflearning.app.DTO.NewUserDTO;
import com.selflearning.app.DTO.UserDTO;
import com.selflearning.app.service.IUserService;
import com.selflearning.app.unit.RegisterNewUserUnit;
import com.selflearning.app.unit.RetrieveUsersUnit;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private RetrieveUsersUnit retrieveUsersUnit;

	@Autowired
	private RegisterNewUserUnit registerNewUserUnit;

	@Override
	public UserDTO retrieveUser(String loginId) {
		return retrieveUsersUnit.retrieveUser(loginId);
	}

	@Override
	public List<UserDTO> retrieveUsers() {
		return retrieveUsersUnit.retrieveUsers();
	}

	@Override
	public UserDTO create(NewUserDTO newUserDTO) {
		return registerNewUserUnit.create(newUserDTO);
	}

}
