package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.EquCheckDAO;
import cn.springmvc.model.EquCheck;
import cn.springmvc.service.EquCheckService;

@Service
public class EquCheckServiceImpl implements EquCheckService {

	@Autowired
	private EquCheckDAO equCheckDao;

	public List<EquCheck> getEquCheckListByShopId(String shopId) throws Exception {
		return equCheckDao.getEquCheckListByShopId(shopId);
	}

	public List<EquCheck> getAllEquCheckList() throws Exception {
		return equCheckDao.getAllEquCheckList();
	}

	public int saveOneEquCheck(EquCheck sku) throws Exception {
		try {
			equCheckDao.saveOneEquCheck(sku);
		} catch (Exception ex) {
			return -1;
		}
		return sku.getId();
	}

	public EquCheck getEquCheckById(String id) throws Exception {
		return equCheckDao.getEquCheckById(id);
	}

	public int updateOneEquCheck(EquCheck equ) throws Exception {
		try {
			equCheckDao.updateOneEquCheck(equ);
		} catch (Exception ex) {
			return -1;
		}
		return 0;
	}

}
