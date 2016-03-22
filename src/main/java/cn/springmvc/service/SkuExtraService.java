package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.GoodsInfo;

public interface SkuExtraService {
	public List<GoodsInfo> getGoodsByNo(String goodsNo)throws Exception;
}
