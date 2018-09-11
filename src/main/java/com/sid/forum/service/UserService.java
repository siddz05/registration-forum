package com.sid.forum.service;

import org.springframework.stereotype.Service;

import com.sid.forum.model.UserRegistration;

//8. Service Interface.
@Service
public interface UserService {

	UserRegistration saveUserDetails(UserRegistration userRegistration);

	String welcomeUser();
}
