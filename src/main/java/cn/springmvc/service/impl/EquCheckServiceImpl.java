package cn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.EquCheckDAO;
import cn.springmvc.service.EquCheckService;

@Service
public class EquCheckServiceImpl implements EquCheckService {

	@Autowired
	private EquCheckDAO equCheckDao;
}
