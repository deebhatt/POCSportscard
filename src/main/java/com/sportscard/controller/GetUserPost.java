package com.sportscard.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sportscard.Messages.ResponseMessage;
import com.sportscard.entity.User;
import com.sportscard.modelbean.UserBean;
import com.sportscard.service.UserService;

@Controller
public class GetUserPost {

	@Inject
	private UserService userService;
	
	
	@RequestMapping(value = "/uploaduser", method = RequestMethod.POST)
	@ResponseBody
	public  ResponseMessage postUser(@RequestBody UserBean user)
	{
		return userService.uploaduser(user);
	}
	
	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User findUserbyId(@PathVariable("id") String id)
	{
		return userService.findByID(Long.valueOf(id));
	}
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ResponseBody
	public List<User> findAllUser()
	{
		return userService.getUsersList();
	}
	
	@RequestMapping(value = "/modifyuser", method = RequestMethod.GET)
	@ResponseBody
	public  ResponseMessage postUser()
	{
		return userService.modifyUser();
	}
	
	@RequestMapping(value = "/updateUserProfilePic", method = RequestMethod.POST ) 
	@ResponseBody
    public String updateUserProfilePic(@RequestParam("file") MultipartFile file) {
		try {
			if (!file.isEmpty()) 
			{
				byte[] bytes = file.getBytes();
				User user = userService.findByID(Long.valueOf("2"));
				Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
				user.setProfilePicture(blob);
				userService.modifyUserProfilePic(user);
				
				return "Success";
			} else {
				return "Failure";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "Failure";
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failure";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failure";
		}
    }
	
	@RequestMapping(value = "/profilePic", method =  { RequestMethod.GET }) 
	@ResponseBody
    public byte[]  profilePic(@RequestParam("userId") String userId, HttpServletResponse response) {
		User user;
		byte[] buff = null;
		try {
			user = userService.findByID(new Long(userId));
			Blob blob = user.getProfilePicture();
			if(blob != null)
			{
				buff = blob.getBytes(1,(int)blob.length());
				/*response.setContentType("image/png");
			    response.getOutputStream().write(buff);*/
			}
			
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return buff;
    }
	
}