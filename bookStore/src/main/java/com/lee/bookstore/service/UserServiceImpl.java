package com.lee.bookstore.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.bookstore.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;
	
	@Override
	public Boolean join(Map<String, Object> map) {
		Boolean bool = false;
		int affectRowCount = this.userDAO.join(map);
		if (affectRowCount == 1) {
			bool = true; return bool;
		}
		return bool;
	}
	
	@Override
	public Map<String,Object> login(Map<String,Object> map) {
		Map<String,Object> user = this.userDAO.login(map);
		return user;
	}
}
