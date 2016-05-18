package cn.springmvc.dao;

import cn.springmvc.model.User;
import cn.springmvc.model.newUser;

public interface UserDAO {

	public User getSingleUser(User u);

	public newUser changePassword(newUser u);
	
	public User resetUserInfo(User u);
}
