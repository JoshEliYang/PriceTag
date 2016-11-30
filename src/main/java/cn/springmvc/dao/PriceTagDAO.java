package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.CopyTagTemp;
import cn.springmvc.model.InsertList;
import cn.springmvc.model.PriceTag;
import cn.springmvc.model.RequestParams;
import cn.springmvc.model.TagNum;
import cn.springmvc.model.TagNum;

public interface PriceTagDAO {

	// 添加价签
	public int insertPriceTag(PriceTag pt);
	
	// 获得所有价签
	public List<PriceTag> selectAllPriceTags();
	
	// 删除价签
	public int deletePriceTag(String id);
	
	// 更新价签
	public int updatePriceTag(PriceTag pt);
	
	// 根据商品编码更新价签
	public int updatePriceTagByGoodsNo(PriceTag pt);
	
	// 查询价签
	public List<PriceTag> selectPriceTagsByParams(RequestParams rp);
	
	// 价签总数
	public String getpriceTagsAll(RequestParams rp);
	
	// 删除价签总数
	public String getTagsAll();
	// 获得单个价签
	public PriceTag selectPriceTagsById(String id);
	
	// 获得所有已删除价签
	public List<PriceTag> selectAllDeletedPriceTags(RequestParams rp);
	
	// 复位删除价签
	public int rollbackDeletedPriceTag(String id);

	
	public List<TagNum> getNoDetail(String shopId);

	public int updateTag(CopyTagTemp tagTemp);

	public String checkIfList(String string, String goodsNo);

	public int insertTagListDelite(InsertList insertList);


	
}
