package com.sid.forum.service;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

	@Override
	public String genericWelcomeForAll() {
		return "I am Generic Welcome Class For All The Request!";
	}

	@Override
	public String blockedForAll() {
		return "Oops! I m blocked, for all The Request!";
	}

	@Override
	public String authMeFirst() {
		return "I am first validated, No One Trust Me!";
	}

}
