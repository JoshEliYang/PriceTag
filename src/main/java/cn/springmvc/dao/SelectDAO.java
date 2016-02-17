package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.Select;

public interface SelectDAO {

	// 查询所有门店
	public List<Select> selectAllShop();
	
	// 查询所有产地
	public List<String> selectAllOrigin();
}
