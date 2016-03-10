package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.SkuCheck;

public interface SkuCheckService {

	public List<SkuCheck> getSkuCheckListByShopId(String shopId) throws Exception;
	
	public int saveOneSkuCheck(SkuCheck sku) throws Exception;
}
