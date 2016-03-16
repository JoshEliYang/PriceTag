package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.SkuCheckDetail;

public interface SkuCheckDetailService {

	public List<SkuCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId) throws Exception;
}
