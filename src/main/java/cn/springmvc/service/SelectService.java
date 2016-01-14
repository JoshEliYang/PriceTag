package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.Select;


public interface SelectService {

	// 查询所有区域
	public List<Select> selectAllShop() throws Exception;
	
	// 查询所有产地
	public List<String> selectAllOrigin() throws Exception;
}
