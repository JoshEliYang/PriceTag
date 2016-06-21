package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.EquCheckDetail;
import cn.springmvc.model.SkuCheckDetail;

public interface EquCheckDetailDAO {

	public List<EquCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId) throws Exception;
	
	public int insertEquDetail(List<EquCheckDetail> detail) throws Exception;
	
	public int addEquDetailNum(String equCheckId , String equName, String num);
	
	public int subEquDetailNum(String equCheckId, String equName, String num);
	
}
