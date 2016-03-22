package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.daoLvdi.SkuExtraDao;
import cn.springmvc.model.GoodsInfo;
import cn.springmvc.service.SkuExtraService;

@Service
public class SkuExtraServiceImpl implements SkuExtraService {
	@Autowired
	public SkuExtraDao dao;
	
	public List<GoodsInfo> getGoodsByNo(String goodsNo) throws Exception {
		return dao.getGoodsByNo(goodsNo);
	}

}
