package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.SkuCheck;

public interface SkuCheckService {

	public List<SkuCheck> getSkuCheckListByShopId(String shopId) throws Exception;
	
	public List<SkuCheck> getAllSkuCheckList() throws Exception;
	
	public int saveOneSkuCheck(SkuCheck sku) throws Exception;
	
	public int updateOneSkuCheck(SkuCheck sku) throws Exception;
	
	public SkuCheck getSkuCheckById(String id) throws Exception;
}
