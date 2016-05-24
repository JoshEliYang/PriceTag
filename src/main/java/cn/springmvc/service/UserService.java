package cn.springmvc.service;

import cn.springmvc.model.User;
import cn.springmvc.model.newUser;

public interface UserService {

	public User getSingleUser(User u ) throws Exception;
	
	public newUser changePassword(newUser u ) throws Exception;
	
	public User resetUserInfo(User u ) throws Exception;
}
