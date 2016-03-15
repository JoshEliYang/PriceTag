package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.SkuCheckDAO;
import cn.springmvc.model.SkuCheck;
import cn.springmvc.service.SkuCheckService;

@Service
public class SkuCheckServiceImpl implements SkuCheckService {

	@Autowired
	private SkuCheckDAO skuCheckDao;

	public List<SkuCheck> getSkuCheckListByShopId(String shopId)
			throws Exception {
		return skuCheckDao.getSkuCheckListByShopId(shopId);
	}

	public int saveOneSkuCheck(SkuCheck sku) throws Exception {
		try {
			skuCheckDao.saveOneSkuCheck(sku);
		} catch (Exception ex) {
			return -1;
		}
		return sku.getId();
	}

	public int updateOneSkuCheck(SkuCheck sku) throws Exception {
		try {
			skuCheckDao.updateOneSkuCheck(sku);
		} catch (Exception ex) {
			return -1;
		}
		return 0;
	}

	public SkuCheck getSkuCheckById(String id) throws Exception {
		return skuCheckDao.getSkuCheckById(id);
	}
}
