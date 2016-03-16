package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.EquCheckDetail;

public interface EquCheckDetailService {

	public List<EquCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId) throws Exception;
}
