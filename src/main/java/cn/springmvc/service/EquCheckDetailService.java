package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.EquCheckDetail;
import cn.springmvc.model.Difference;

public interface EquCheckDetailService {

	public List<EquCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId) throws Exception;
	
	public int insertEquDetail(List<EquCheckDetail> detail) throws Exception;
	
	public List<Difference> getEquDifference(String id1,String id2)throws Exception;
	
	public int addEquDetailNum(String equCheckId , String equName, String num);
	
	public int subEquDetailNum(String equCheckId, String equName, String num);
}
