package cn.springmvc.model.priceTagInsert;

import java.util.List;

public class PriceTagPacks {
	List<GoodsParam> goods;
	List<String> shops;
	String ecg;
	public List<GoodsParam> getGoods() {
		return goods;
	}
	public void setGoods(List<GoodsParam> goods) {
		this.goods = goods;
	}
	public List<String> getShops() {
		return shops;
	}
	public void setShops(List<String> shops) {
		this.shops = shops;
	}
	public String getEcg() {
		return ecg;
	}
	public void setEcg(String ecg) {
		this.ecg = ecg;
	}
	@Override
	public String toString() {
		return "PriceTagPacks [goods=" + goods + ", shops=" + shops + ", ecg="
				+ ecg + "]";
	}
	public PriceTagPacks(List<GoodsParam> goods, List<String> shops, String ecg) {
		super();
		this.goods = goods;
		this.shops = shops;
		this.ecg = ecg;
	}
	public PriceTagPacks() {
		super();
	}

	

/*	@Override
	public String toString() {
		return "PriceTagPacks [goods=" + goods + ", shops=" + shops + "]";
	}

	public List<GoodsParam> getGoods() {
		return goods;
	}

	public void setGoods(List<GoodsParam> goods) {
		this.goods = goods;
	}

	public List<String> getShops() {
		return shops;
	}

	public void setShops(List<String> shops) {
		this.shops = shops;
	}*/

}
