package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.SelectDAO;
import cn.springmvc.model.Select;
import cn.springmvc.service.SelectService;

@Service
public class SelectServiceImpl implements SelectService {

	@Autowired
	private SelectDAO  selectDao;
	
	public List<Select> selectAllShop() throws Exception {
		List<Select> shopIds = null;
		try {
			shopIds = selectDao.selectAllShop();
		} catch (Exception ex) {
			return null;
		}
		
		return shopIds;
	}

	public List<String> selectAllOrigin() throws Exception {
		List<String> origins = null;
		try {
			origins = selectDao.selectAllOrigin();
		} catch (Exception ex) {
			return null;
		}
		return origins;
	}
}
