package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.Select;

public interface SelectDAO {

	public List<Select> selectAllShop();
	
	public List<String> selectAllOrigin();
}
