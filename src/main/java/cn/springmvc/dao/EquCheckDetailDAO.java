package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.EquCheckDetail;

public interface EquCheckDetailDAO {

	public List<EquCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId) throws Exception;
}
