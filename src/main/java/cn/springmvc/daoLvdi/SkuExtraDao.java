package cn.springmvc.daoLvdi;

import java.util.List;

import cn.springmvc.model.GoodsInfo;

public interface SkuExtraDao {
	public List<GoodsInfo> getGoodsByNo(String goodsNo)throws Exception;
}
