package cn.springmvc.model;

public class CopyTagTemp {

	String goodsNo;
	
	String shopId;
	
	int salesPrice;
	int propmPrice;
	int marketPrice;
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	public int getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}
	public int getPropmPrice() {
		return propmPrice;
	}
	public void setPropmPrice(int propmPrice) {
		this.propmPrice = propmPrice;
	}
	public int getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(int marketPrice) {
		this.marketPrice = marketPrice;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	@Override
	public String toString() {
		return "CopyTagTemp [goodsNo=" + goodsNo + ", shopId=" + shopId
				+ ", salesPrice=" + salesPrice + ", propmPrice=" + propmPrice
				+ ", marketPrice=" + marketPrice + "]";
	}
	public CopyTagTemp() {
		super();
	}
	public CopyTagTemp(String goodsNo, String shopId, int salesPrice,
			int propmPrice, int marketPrice) {
		super();
		this.goodsNo = goodsNo;
		this.shopId = shopId;
		this.salesPrice = salesPrice;
		this.propmPrice = propmPrice;
		this.marketPrice = marketPrice;
	}

}
