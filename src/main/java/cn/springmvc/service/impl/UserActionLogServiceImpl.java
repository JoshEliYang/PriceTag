package cn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.UserActionLogDAO;
import cn.springmvc.service.UserActionLogService;

@Service
public class UserActionLogServiceImpl implements UserActionLogService {

	@Autowired
	private UserActionLogDAO userLogActionDao;
}
