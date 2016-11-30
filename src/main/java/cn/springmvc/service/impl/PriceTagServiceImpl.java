package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.PriceTagDAO;
import cn.springmvc.daoLvdi.SearchPriceTagDAO;
import cn.springmvc.model.CopyTagTemp;
import cn.springmvc.model.InsertList;
import cn.springmvc.model.PriceTag;
import cn.springmvc.model.RequestParams;
import cn.springmvc.model.SearchPriceTag;
import cn.springmvc.model.SelectPriceTag;
import cn.springmvc.model.TagNum;
import cn.springmvc.model.priceTagInsert.GoodsParam;
import cn.springmvc.model.priceTagInsert.PriceTagPacks;
import cn.springmvc.service.PriceTagService;

@Service
public class PriceTagServiceImpl implements PriceTagService {

	@Autowired
	private PriceTagDAO priceTagDao;
	@Autowired
	private SearchPriceTagDAO searchPriceTagDao;

	// 添加价签
	public int insertPriceTag(PriceTag pt) throws Exception {
		try {
			priceTagDao.insertPriceTag(pt);
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
		return 0;
	}

	public List<PriceTag> selectAllPriceTags() throws Exception {
		return priceTagDao.selectAllPriceTags();
	}

	// 删除价签
	public int deletePriceTag(String id) throws Exception {
		try {
			// 判断价签是否存在
			PriceTag pt = priceTagDao.selectPriceTagsById(id);
			if (pt == null) {
				return -2;
			}
			priceTagDao.deletePriceTag(id);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	// 更新价签
	public int updatePriceTag(PriceTag pt) throws Exception {
		try {
			// 判断价签是否存在
			int id = pt.getId();
			PriceTag priceTag = priceTagDao.selectPriceTagsById(String
					.valueOf(id));
			if (priceTag == null) {
				return -2;
			}

			priceTagDao.updatePriceTag(pt);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 0;
	}

	// 查询单个价签
	public PriceTag selectPriceTagById(String id) throws Exception {
		return priceTagDao.selectPriceTagsById(id);
	}

	// 条件搜索价签
	public List<PriceTag> selectPriceTagsByParams(RequestParams rp)
			throws Exception {
		return priceTagDao.selectPriceTagsByParams(rp);
	}

	// 根据商品编码更新价签
	public int updatePireceTagByGoodsNo(PriceTag pt) throws Exception {
		try {
			String goodsNo = pt.getGoodsNo();
			if (goodsNo == null || goodsNo.equals("")) {
				return -2;
			}

			priceTagDao.updatePriceTagByGoodsNo(pt);
		} catch (Exception ex) {
			return -1;
		}
		return 0;
	}

	// 获得所有已删除价签
	public List<PriceTag> selectAllDeletePriceTags(RequestParams rp)
			throws Exception {
		return priceTagDao.selectAllDeletedPriceTags(rp);
	}

	// 复位已删除价签
	public int rollbackDeletedPriceTag(String id) throws Exception {
		try {
			// 判断价签是否存在
			PriceTag pt = priceTagDao.selectPriceTagsById(id);
			if (pt == null) {
				return -2;
			}
			priceTagDao.rollbackDeletedPriceTag(id);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	public String getpriceTagsAll(RequestParams rp) throws Exception {
		// TODO Auto-generated method stub
		return priceTagDao.getpriceTagsAll(rp);
	}

	public String getdeleteTagsAll() throws Exception {
		// TODO Auto-generated method stub
		return priceTagDao.getTagsAll();
	}

	/*
	 * public List<SearchPriceTag> searchPriceTagInfo(SelectPriceTag taginfo)
	 * throws Exception { return
	 * searchPriceTagDao.searchPriceTagInfoByA(taginfo); }
	 */

	public String getCountPriceTag(SelectPriceTag taginfo) throws Exception {
		// TODO Auto-generated method stub
		return searchPriceTagDao.getCountPriceTag(taginfo);
	}

	public List<SearchPriceTag> searchPriceTagInfo(SelectPriceTag taginfo)
			throws Exception {
		// TODO Auto-generated method stub
		return searchPriceTagDao.searchPriceTagInfoByA(taginfo);

	}

	public String insertPriceTagg(PriceTagPacks param) {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		for (int i = 0;i < param.getShops().size();i++){
			for(int j = 0;j<param.getGoods().size();j++){
				
				String a = param.getShops().get(i);
				String b = param.getGoods().get(j).getGoodsNo();
				//priceTagDao.checkIfList(param.getGoods().get(j).getGoodsNo(),param.getShops().get(i));
				

				String flag = priceTagDao.checkIfList(param.getShops().get(i),param.getGoods().get(j).getGoodsNo());
	
				
				if(flag.equals("0")){
					
					count = count +1;
					List<InsertList> list = null;
					
					list =  searchPriceTagDao.searchListDetail(param.getEcg(),param.getGoods().get(j).getGoodsNo());
					
					list.get(0).setQrCode("http://g-super.glcp.com.cn/gapp/category/goodList/spxq/index.htm?goodsXq_cid="+list.get(0).getQrCode());
					list.get(0).setUnit(param.getGoods().get(j).getUnit());
					list.get(0).setSpecifications(param.getGoods().get(j).getSpecifications());
					list.get(0).setGoodsOrigin(param.getGoods().get(j).getGoodsOrigin());
					list.get(0).setShopId(param.getShops().get(i));
					
					List<InsertList> lidst = list;
					
					
					int v =  priceTagDao.insertTagListDelite(list.get(0));
					
					
					//List<InsertList> lisst =  searchPriceTagDao.searchListDetail(param.getEcg(),param.getGoods().get(j).getGoodsNo());
					
					//priceTagDao.insertList(param.getShops().get(i),param.getGoods().get(j).getGoodsNo());
				
				}
			
			}
		}
		
		//param.getGoods().get(0).get
		return String.valueOf(count);
	}

	public String syncPriceTag(String shopId) {
		int result = 0;

		int results = 0;
		List<TagNum> tSNum = priceTagDao.getNoDetail(shopId);

		List<CopyTagTemp> tagTemp = searchPriceTagDao.getNoDetail(tSNum);

		for (int i = 0; i < tagTemp.size(); i++) {
			tagTemp.get(i).setShopId(shopId);
		}

		// List<CopyTagTemp> temp = new ArrayList<CopyTagTemp>();

		long st = System.currentTimeMillis();
		
		try {
			for (int i = 0; i < tagTemp.size(); i++) {
				CopyTagTemp copyTagTemp = new CopyTagTemp();
				copyTagTemp.setShopId(tagTemp.get(i).getShopId());
				copyTagTemp.setGoodsNo(tagTemp.get(i).getGoodsNo());
				copyTagTemp.setMarketPrice(tagTemp.get(i).getMarketPrice());
				copyTagTemp.setPropmPrice(tagTemp.get(i).getPropmPrice());
				copyTagTemp.setSalesPrice(tagTemp.get(i).getSalesPrice());
				// temp.add(copyTagTemp);
				result = priceTagDao.updateTag(copyTagTemp);

				if (result == 1) {
					results += result;
				}

			}
			// result = priceTagDao.updateTag(tagTemp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		long ed = System.currentTimeMillis();
		System.out.println(ed - st);

		return String.valueOf(results);
	}
}
