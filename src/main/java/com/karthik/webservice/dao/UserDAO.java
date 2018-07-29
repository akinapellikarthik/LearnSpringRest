package com.karthik.webservice.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.karthik.webservice.exception.UserNotFoundException;
import com.karthik.webservice.userVo.User;

@Component
public class UserDAO {

	private static List<User> userList = new ArrayList<>();
	
	static {
		userList.add(new User("Karthik", 1, new Date("06-APR-89")));
		userList.add(new User("Swathi", 2, new Date("12-FEB-91")));
		userList.add(new User("Chinnu", 3, new Date("01-JAN-20")));

	}
	
	private static int countOfUsers = userList.size();
	
	public List<User> findAll() {
		return userList;
	}

	public User findOne(Integer userId) throws UserNotFoundException {

		System.out.println(userList+":"+userId);
		for (User u : userList) {
			if (u.getUserId() == userId) {
				return u;
			} 
		}
		return null;

	}

	public User save(User u) {
		if (u.getUserId() == null) {
			u.setUserId(++countOfUsers);
			userList.add(u);
		} else {
			// save to db code
			userList.add(u);
		}
		return u;
	}

	public User deleteOne(Integer id) {
		
		Iterator<User> itr = userList.iterator();
		while(itr.hasNext()) {
			User u = itr.next();
			if(u.getUserId() == id) {
				itr.remove();
				return u;
			}
		}
		
		return null;
	}

}
