package cn.springmvc.model.priceTagInsert;

public class GoodsParam {
	String goodsNo;
	String unit;
	String specifications;
	String goodsOrigin;

	@Override
	public String toString() {
		return "GoodsParam [goodsNo=" + goodsNo + ", unit=" + unit
				+ ", specifications=" + specifications + ", goodsOrigin="
				+ goodsOrigin + "]";
	}

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
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

}
