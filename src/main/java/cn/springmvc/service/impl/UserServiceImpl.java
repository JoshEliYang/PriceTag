package cn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.UserDAO;
import cn.springmvc.model.User;
import cn.springmvc.model.newUser;
import cn.springmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	public User getSingleUser(User u) {
		return userDao.getSingleUser(u);
	}

	public newUser changePassword(newUser u) throws Exception {
		
		return userDao.changePassword(u);
	}
}
