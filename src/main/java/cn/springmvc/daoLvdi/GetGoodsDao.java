package cn.springmvc.daoLvdi;

import java.util.List;

import cn.springmvc.model.RefrePrcModel;

public interface GetGoodsDao {
	public List<RefrePrcModel> getGoodsId(List<String> list);
}
