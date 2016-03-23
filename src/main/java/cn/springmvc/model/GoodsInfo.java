package cn.springmvc.model;

/**
 * This model only contains a part of data in DB. (Because SkuExtra API just
 * need goodsNo and goodsName)
 * 
 * @author johsnon
 *
 */
public class GoodsInfo {
	String cargo_no;
	String cargo_name;
	float purchase_price;
	float market_price;
	float shop_price;


	public String getCargo_no() {
		return cargo_no;
	}

	public void setCargo_no(String cargo_no) {
		this.cargo_no = cargo_no;
	}

	public String getCargo_name() {
		return cargo_name;
	}

	public void setCargo_name(String cargo_name) {
		this.cargo_name = cargo_name;
	}

	public float getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(float purchase_price) {
		this.purchase_price = purchase_price;
	}

	public float getMarket_price() {
		return market_price;
	}

	public void setMarket_price(float market_price) {
		this.market_price = market_price;
	}

	public float getShop_price() {
		return shop_price;
	}

	public void setShop_price(float shop_price) {
		this.shop_price = shop_price;
	}

}
