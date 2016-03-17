package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.SkuCheckDetailDAO;
import cn.springmvc.model.SkuCheckDetail;
import cn.springmvc.service.SkuCheckDetailService;

@Service
public class SkuCheckDetailServiceImpl implements SkuCheckDetailService {

	@Autowired
	private SkuCheckDetailDAO skuCheckDetailDao;

	public List<SkuCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId)
			throws Exception {
		return skuCheckDetailDao.getAllDetailsBySkuCheckId(skuCheckId);
	}

	public int insertSkuDetail(List<SkuCheckDetail> detail) throws Exception {
		return skuCheckDetailDao.insertSkuDetail(detail);
	}
}
