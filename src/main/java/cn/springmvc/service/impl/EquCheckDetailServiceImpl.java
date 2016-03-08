package cn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.EquCheckDetailDAO;
import cn.springmvc.service.EquCheckDetailService;

@Service
public class EquCheckDetailServiceImpl implements EquCheckDetailService{

	@Autowired
	private EquCheckDetailDAO equCheckDetailDao;
}
