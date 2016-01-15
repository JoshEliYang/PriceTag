package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.PriceTag;
import cn.springmvc.model.RequestParams;

public interface PriceTagService {
	
	// 添加价签
	public int insertPriceTag(PriceTag pt) throws Exception;
	
	// 查询所有价签
	public List<PriceTag> selectAllPriceTags() throws Exception;
	
	// 删除价签
	public int deletePriceTag(String id) throws Exception;
	
	// 更新价签
	public int updatePriceTag(PriceTag pt) throws Exception;
	
	// 根据商品编码更新价签
	public int updatePireceTagByGoodsNo(PriceTag pt) throws Exception;
	
	// 按条件查询价签
	public List<PriceTag> selectPriceTagsByParams(RequestParams rp) throws Exception;
	
	// 查询单个价签
	public PriceTag selectPriceTagById(String id) throws Exception;

}
