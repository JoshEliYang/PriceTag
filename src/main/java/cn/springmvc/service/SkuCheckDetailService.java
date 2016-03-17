package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.SkuCheckDetail;
import cn.springmvc.model.difference;

public interface SkuCheckDetailService {

	public List<SkuCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId) throws Exception;
	
	public int insertSkuDetail(List<SkuCheckDetail> detail) throws Exception;
	
	public List<difference> getSkuDifference(String id1,String id2)throws Exception;
}
