package com.karthik.webservice.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthik.webservice.dao.UserDAO;
import com.karthik.webservice.exception.UserNotFoundException;
import com.karthik.webservice.userVo.User;

@Service
public class UserService {

	
	@Autowired
	private UserDAO userDAO;
	
	
	public User findOneByIdFromDAO(Integer userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return userDAO.findOne(userId);
	}
	
	public User saveOneUserFromService(User u) {
		return userDAO.save(u);
	}

	public List<User> findAllUsersFromDAO(){
		return userDAO.findAll();
	}
}
