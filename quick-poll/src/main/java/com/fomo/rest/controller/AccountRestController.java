package com.fomo.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fomo.model.Interest;

@RestController
@RequestMapping(value="/rest/v1/accounts")
public class AccountRestController {
	
	@RequestMapping(value="{username}/intersts", method=RequestMethod.POST)
	public void createUserIntersts(@PathVariable("username")String username, String interest){
		System.err.println(username + "========> " +interest);
	}
}
