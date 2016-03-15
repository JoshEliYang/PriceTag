package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.EquDAO;
import cn.springmvc.model.Equipment;
import cn.springmvc.service.EquService;

@Service
public class EquServiceImpl implements EquService{

	@Autowired
	private EquDAO equDao;
	
	public List<Equipment> getAllEquipments() throws Exception {
		return equDao.getAllEquipments();
	}
}
