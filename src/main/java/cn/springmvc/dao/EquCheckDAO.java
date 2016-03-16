package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.EquCheck;

public interface EquCheckDAO {

	public List<EquCheck> getEquCheckListByShopId(String shopId)
			throws Exception;

	public List<EquCheck> getAllEquCheckList()throws Exception;
	
	public int saveOneEquCheck(EquCheck sku) throws Exception;
	
	public EquCheck getEquCheckById(String id) throws Exception;
	
	public int updateOneEquCheck(EquCheck equ) throws Exception;
}
