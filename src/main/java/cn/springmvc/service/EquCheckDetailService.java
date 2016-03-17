package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.EquCheckDetail;
import cn.springmvc.model.SkuCheckDetail;

public interface EquCheckDetailService {

	public List<EquCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId) throws Exception;
	
	public int insertEquDetail(List<EquCheckDetail> detail) throws Exception;
}
