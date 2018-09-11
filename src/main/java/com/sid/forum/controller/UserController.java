package com.sid.forum.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sid.forum.model.UserRegistration;
import com.sid.forum.service.UserService;

//10. Create Controller and consume Service
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/insertWithBody", method = RequestMethod.POST, consumes = { "application/json",
			"*" }, produces = { "application/json" })
	@ResponseBody
	Map<String, Object> insertWithBodyDataToSidProfile(HttpServletRequest request, HttpServletResponse response,
			@Valid @RequestBody UserRegistration userRegistration) {
		String result = "";
		Map<String, Object> hashMap = new HashMap<>();
		try {
			System.out.println(userRegistration);
			hashMap.put("UserDetails", userService.saveUserDetails(userRegistration));
		} catch (Exception e) {
			e.printStackTrace();
			hashMap.put("Error", "Some Error Occured !" + e.getMessage() + " Cause: " + e.getCause());
		}
		result = UUID.randomUUID().toString();
		hashMap.put("UUID", result);
		return hashMap;
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET, consumes = { "application/json", "*" }, produces = {
			"application/json" })
	@ResponseBody
	Map<String, Object> welcome() {
		String result = "";
		Map<String, Object> hashMap = new HashMap<>();
		try {
			hashMap.put("Welcome", userService.welcomeUser());
		} catch (Exception e) {
			e.printStackTrace();
			hashMap.put("Error", "Some Error Occured !" + e.getMessage() + " Cause: " + e.getCause());
		}
		result = UUID.randomUUID().toString();
		hashMap.put("UUID", result);
		return hashMap;
	}

}
