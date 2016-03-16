package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.SkuCheckDetail;

public interface SkuCheckDetailDAO {

	public List<SkuCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId) throws Exception;
}
