package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.EquCheck;

public interface EquCheckService {

	public List<EquCheck> getEquCheckListByShopId(String shopId)
			throws Exception;

	public int saveOneEquCheck(EquCheck sku) throws Exception;
}
