package com.effision.assestment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.effision.assestment.beans.Users;


@RestController
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/createUsers", consumes = "application/json;charset=UTF-8")
	@ResponseBody 
	public String creatUser(@RequestBody List<Users> users) {
		logger.info("creating users method");
		for (Users user : users) {
			if (!user.getUserName().matches("[a-zA-Z0-9]+")) {
				logger.error("User validation failed for the user " + user.getUserName());
				return "User name has special charcters";
			}
		}
		logger.info("User validation success");
		return "User created success";
	}
	
}
