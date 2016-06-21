package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.SkuCheckDetail;
import cn.springmvc.model.Difference;

public interface SkuCheckDetailService {

	public List<SkuCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId) throws Exception;
	
	public int insertSkuDetail(List<SkuCheckDetail> detail) throws Exception;
	
	public List<Difference> getSkuDifference(String id1,String id2)throws Exception;
	
	public int addSkuDetailNum(String skuCheckId , String goodsNo, String num);
	
	public int subSkuDetailNum(String skuCheckId, String goodsNo, String num);
}
