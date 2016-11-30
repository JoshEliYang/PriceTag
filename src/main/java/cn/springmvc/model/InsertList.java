package cn.springmvc.model;
public class InsertList {

	private String shopId;
	
	private String goodsNo;
	
	private String goodsName;
	
	private String unit;
	
	private String specifications;
	
	private String goodsOrigin;
	
	private int salesPrice;
	
	private int propmPrice;
	
	private int marketPrice;
	
	private String qrCode;
	
	private int isDelete;

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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getGoodsOrigin() {
		return goodsOrigin;
	}

	public void setGoodsOrigin(String goodsOrigin) {
		this.goodsOrigin = goodsOrigin;
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

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "InsertList [shopId=" + shopId + ", goodsNo=" + goodsNo
				+ ", goodsName=" + goodsName + ", unit=" + unit
				+ ", specifications=" + specifications + ", goodsOrigin="
				+ goodsOrigin + ", salesPrice=" + salesPrice + ", propmPrice="
				+ propmPrice + ", marketPrice=" + marketPrice + ", qrCode="
				+ qrCode + ", isDelete=" + isDelete + "]";
	}

	public InsertList() {
		super();
	}

	public InsertList(String shopId, String goodsNo, String goodsName,
			String unit, String specifications, String goodsOrigin,
			int salesPrice, int propmPrice, int marketPrice, String qrCode,
			int isDelete) {
		super();
		this.shopId = shopId;
		this.goodsNo = goodsNo;
		this.goodsName = goodsName;
		this.unit = unit;
		this.specifications = specifications;
		this.goodsOrigin = goodsOrigin;
		this.salesPrice = salesPrice;
		this.propmPrice = propmPrice;
		this.marketPrice = marketPrice;
		this.qrCode = qrCode;
		this.isDelete = isDelete;
	}


	
	
	
}
