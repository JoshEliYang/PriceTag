package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.RefrePrcModel;

public interface RefrePrcService {
	
	public List<String> select();
	
	public List<RefrePrcModel> selectCargoId(List<String> list);
//	public Map<String, Object> selectCargoId(List<String> list);
	
	public int update(List<RefrePrcModel> list);
}
