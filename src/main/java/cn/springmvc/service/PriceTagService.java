package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.PriceTag;
import cn.springmvc.model.RequestParams;
import cn.springmvc.model.SearchPriceTag;
import cn.springmvc.model.SelectPriceTag;
import cn.springmvc.model.priceTagInsert.PriceTagPacks;

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
	//价签总数
	public String getpriceTagsAll(RequestParams rp) throws Exception;
	
	//删除价签总数
	public String getdeleteTagsAll() throws Exception;
	// 查询单个价签
	public PriceTag selectPriceTagById(String id) throws Exception;
	
	// 查询所有已删除价签
	public List<PriceTag> selectAllDeletePriceTags(RequestParams rp) throws Exception;
	
	// 复位已删除价签
	public int rollbackDeletedPriceTag(String id) throws Exception; 
	
	//搜索价签
	public List<SearchPriceTag> searchPriceTagInfo(SelectPriceTag taginfo) throws Exception; 
	
	public String getCountPriceTag(SelectPriceTag taginfo) throws Exception;

	
	public String insertPriceTagg(PriceTagPacks param);

	public String syncPriceTag(String shopId);
	
	//插入价签
	
}
