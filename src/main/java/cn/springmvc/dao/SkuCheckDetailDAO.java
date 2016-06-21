package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.SkuCheckDetail;

public interface SkuCheckDetailDAO {

	public List<SkuCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId) throws Exception;
	
	public int insertSkuDetail(List<SkuCheckDetail> detail) throws Exception;
	
	public int addSkuDetailNum(String skuCheckId , String goodsNo, String num);
	
	public int subSkuDetailNum(String skuCheckId, String goodsNo, String num);
}
