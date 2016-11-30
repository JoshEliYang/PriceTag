package cn.springmvc.model;

public class TagNum {

	String goodsNo;

	String shopId;
	
	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "TagNum [goodsNo=" + goodsNo + ", shopId=" + shopId + "]";
	}

	public TagNum() {
		super();
	}

	public TagNum(String goodsNo, String shopId) {
		super();
		this.goodsNo = goodsNo;
		this.shopId = shopId;
	}


	
	
}
