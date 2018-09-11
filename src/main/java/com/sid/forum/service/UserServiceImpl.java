package com.sid.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.forum.model.UserRegistration;
import com.sid.forum.repository.UserRegistrationRepository;


//9. ServiceImpl for particular Service
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRegistrationRepository userRegistrationRepository;

	@Override
	public UserRegistration saveUserDetails(UserRegistration userRegistration) {
		return userRegistrationRepository.save(userRegistration);
	}

	@Override
	public String welcomeUser() {
		return "Welcome -- Server Is Up and Running!";
	}

}
