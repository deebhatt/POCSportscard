package com.sportscard.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportscard.Messages.ResponseMessage;
import com.sportscard.dao.UserDAO;
import com.sportscard.entity.User;
import com.sportscard.modelbean.UserBean;

@Service
public class UserService {
	
	@Inject
	private UserDAO userDAO;
	
	@Transactional
	public ResponseMessage uploaduser(UserBean user)
	{
		User usermaster = new User();
		usermaster = userDAO.findByEmail(user.getEmail());
		if(usermaster.getUserName() != null)
		{
			return new ResponseMessage(ResponseMessage.Type.error, "This email is already registered", Long.toString(usermaster.getUserId()));
		}
		else
		{
			usermaster.setUserName(user.getUserName());
			usermaster.setEmail(user.getEmail());
			userDAO.persist(usermaster);
		}
		return new ResponseMessage(ResponseMessage.Type.success, "You have been successfully registered.", Long.toString(usermaster.getUserId()));
	}

	public List<User> getUsersList()
	{
		List<User> listusers = null;
		try{
			listusers = userDAO.getUsersList(User.class);
			if(listusers.size() == 0)
			{
				return listusers;
			}
		}
		catch(Exception e){
			throw new RuntimeException();
		}
		return listusers;
	}
	
	public User findByID(Long id)
	{
		try{
			return userDAO.findById(User.class, id);
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}
	
	@Transactional
	public ResponseMessage modifyUser()
	{
		User getuser = findByID(Long.valueOf("1"));
		try{
			getuser.setEmail("modifiedmail@gmail.com");
			userDAO.update(getuser);
			return new ResponseMessage(ResponseMessage.Type.success, "User info changed successfully.", Long.toString(getuser.getUserId()));
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}
	
	@Transactional
	public ResponseMessage modifyUserProfilePic(User user)
	{
		try{
			userDAO.update(user);
			return new ResponseMessage(ResponseMessage.Type.success, "User profile pic changed successfully", Long.toString(user.getUserId()));
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}
}