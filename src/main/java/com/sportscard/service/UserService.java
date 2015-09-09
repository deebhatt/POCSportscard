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

	public ResponseMessage getUsersList()
	{
		List<User> listusers = null;
		try{
			listusers = userDAO.getUsersList(User.class);
			if(listusers.size() == 0)
			{
				return new ResponseMessage(ResponseMessage.Type.warn, "List is Empty");
			}
		}
		catch(Exception e){
			throw new RuntimeException();
		}
		return new ResponseMessage(ResponseMessage.Type.success, "List Retrieved", listusers) ;
	}
	
	@Transactional
	public ResponseMessage uploaduser(UserBean user)
	{
		User usermaster = new User();
		usermaster.setUserName(user.getUserName());
		usermaster.setEmail(user.getEmail());
		userDAO.persist(usermaster);
		
		return new ResponseMessage(ResponseMessage.Type.success, "You have been successfully registered.", Long.toString(usermaster.getUserId()));
	}
}