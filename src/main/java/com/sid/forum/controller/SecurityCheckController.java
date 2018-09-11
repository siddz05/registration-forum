package com.sid.forum.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sid.forum.service.AuthService;

@RestController
@RequestMapping(value = "/auth")
public class SecurityCheckController {

	@Autowired
	AuthService authService;

	@RequestMapping(value = "/block", method = RequestMethod.GET, consumes = { "application/json", "*" }, produces = {
			"application/json" })
	@ResponseBody
	Map<String, Object> blockedForAll() {
		String result = "";
		Map<String, Object> hashMap = new HashMap<>();
		try {
			hashMap.put("blockedForAll", authService.blockedForAll());
		} catch (Exception e) {
			e.printStackTrace();
			hashMap.put("Error", "Some Error Occured !" + e.getMessage() + " Cause: " + e.getCause());
		}
		result = UUID.randomUUID().toString();
		hashMap.put("UUID", result);
		return hashMap;
	}

	@RequestMapping(value = "/allow", method = RequestMethod.GET, consumes = { "application/json", "*" }, produces = {
			"application/json" })
	@ResponseBody
	Map<String, Object> allowForAll() {
		String result = "";
		Map<String, Object> hashMap = new HashMap<>();
		try {
			hashMap.put("genericWelcomeForAll", authService.genericWelcomeForAll());
		} catch (Exception e) {
			e.printStackTrace();
			hashMap.put("Error", "Some Error Occured !" + e.getMessage() + " Cause: " + e.getCause());
		}
		result = UUID.randomUUID().toString();
		hashMap.put("UUID", result);
		return hashMap;
	}

	@RequestMapping(value = { "/check", "*" }, method = RequestMethod.GET, consumes = { "application/json",
			"*" }, produces = { "application/json" })
	@ResponseBody
	Map<String, Object> authMeFirst() {
		String result = "";
		Map<String, Object> hashMap = new HashMap<>();
		try {
			hashMap.put("authMeFirst", authService.authMeFirst());
		} catch (Exception e) {
			e.printStackTrace();
			hashMap.put("Error", "Some Error Occured !" + e.getMessage() + " Cause: " + e.getCause());
		}
		result = UUID.randomUUID().toString();
		hashMap.put("UUID", result);
		return hashMap;
	}

}
