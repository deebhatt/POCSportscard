package com.sportscard.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sportscard.Messages.ResponseMessage;
import com.sportscard.modelbean.UserBean;
import com.sportscard.service.UserService;

@Controller
public class GetUserPost {

	@Inject
	private UserService userService;
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage getUsers()
	{
		return userService.getUsersList();
	}
	
	@RequestMapping(value = "/uploaduser", method = RequestMethod.POST)
	@ResponseBody
	public  ResponseMessage postUser(@RequestBody UserBean user)
	{
		return userService.uploaduser(user);
	}
	
}