package cn.springmvc.daoLvdi;

import java.util.List;

import cn.springmvc.model.CopyTagTemp;
import cn.springmvc.model.InsertList;
import cn.springmvc.model.SearchPriceTag;
import cn.springmvc.model.SelectPriceTag;
import cn.springmvc.model.TagNum;


public interface SearchPriceTagDAO {
	
	public List<SearchPriceTag> searchPriceTagInfoByA(SelectPriceTag taginfo);

	public String getCountPriceTag(SelectPriceTag taginfo);

	public List<CopyTagTemp> getNoDetail(List<TagNum> tSNum);

	public List<InsertList> searchListDetail(String ecg, String goodsNo);

	/*public List<InsertList> searchListDetail(String string, String goodsNo);*/
	
}
