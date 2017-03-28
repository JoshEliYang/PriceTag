package cn.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.RefrePrcDao;
import cn.springmvc.daoLvdi.GetGoodsDao;
import cn.springmvc.model.RefrePrcModel;
import cn.springmvc.service.RefrePrcService;

@Service
public class RefrePrcServiceImpl implements RefrePrcService {
	@Autowired
	RefrePrcDao reDao;
	@Autowired
	GetGoodsDao goodsDao;
	
	public List<String> select() {
		return reDao.select();
	}

	public List<RefrePrcModel> selectCargoId(List<String> list) {
		List<RefrePrcModel> cargoList = goodsDao.getGoodsId(list);
		return cargoList;
	}

//	@SuppressWarnings("null")
//	public Map<String, Object> selectCargoId(List<String> list) {
//		List<String> errGoods = null;
//		List<RefrePrcModel> cargoList = goodsDao.getGoodsId(list);
//		for(int i = 0; i < list.size(); i ++){
//			for(int j = 0; j < cargoList.size(); j++){
//				if(list.get(i) != cargoList.get(j).getGoodsNo()){
//					errGoods.add(list.get(i));
//				}
//			}
//		}
//		Map<String, Object> res = null;
//		res.put("rList", cargoList);
//		res.put("fList", errGoods);
//		return res;
//	}
	
	public int update(List<RefrePrcModel> list) {
		for(int i = 0; i < list.size(); i ++){
			reDao.update(list.get(i).getGoodsNo(), "http://g-super.glcp.com.cn/gapp/category/goodList/spxq/index.htm?goodsXq_cid=" + list.get(i).getCargoId() + "&cargo_num=" + list.get(i).getCargoNum());
			System.out.println("成功更新第" + i + "条");
		}
		return 0;
	}
}
