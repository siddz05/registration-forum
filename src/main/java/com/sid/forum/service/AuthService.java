package com.sid.forum.service;

import org.springframework.stereotype.Service;

@Service
public interface AuthService {

	String genericWelcomeForAll();

	String blockedForAll();
	
	String authMeFirst();

}
