package cn.springmvc.dao;

import java.util.List;

public interface RefrePrcDao {
	
	public List<String> select();
	
	public int update(String goodsNo, String cargoId);
}
