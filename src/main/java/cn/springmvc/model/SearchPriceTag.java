package cn.springmvc.model;

public class SearchPriceTag {

	private String id;
	
	private int salesPrice;
	
	private int propmPrice;
	
	private int marketPrice;
	
	private String goodsNo;
	
	private String goodsName;
	
	private String gcType;
	
	

	public String getGcType() {
		return gcType;
	}

	public void setGcType(String gcType) {
		this.gcType = gcType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Override
	public String toString() {
		return "SearchPriceTag [id=" + id + ", salesPrice=" + salesPrice
				+ ", propmPrice=" + propmPrice + ", marketPrice=" + marketPrice
				+ ", goodsNo=" + goodsNo + ", goodsName=" + goodsName + "]";
	}

	public SearchPriceTag() {
		super();
	}

	public SearchPriceTag(String id, int salesPrice, int propmPrice,
			int marketPrice, String goodsNo, String goodsName) {
		super();
		this.id = id;
		this.salesPrice = salesPrice;
		this.propmPrice = propmPrice;
		this.marketPrice = marketPrice;
		this.goodsNo = goodsNo;
		this.goodsName = goodsName;
	}
	
	
}
