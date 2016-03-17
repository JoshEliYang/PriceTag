package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.EquCheckDetailDAO;
import cn.springmvc.model.EquCheckDetail;
import cn.springmvc.service.EquCheckDetailService;

@Service
public class EquCheckDetailServiceImpl implements EquCheckDetailService{

	@Autowired
	private EquCheckDetailDAO equCheckDetailDao;

	public List<EquCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId) throws Exception {
		
		return equCheckDetailDao.getAllDetailsBySkuCheckId(skuCheckId);
	}

	public int insertEquDetail(List<EquCheckDetail> detail) throws Exception {
		return equCheckDetailDao.insertEquDetail(detail);
	}
}
