package cn.springmvc.model;

/**
 * This model only contains a part of data in DB.
 * (Because SkuExtra API just need goodsNo and goodsName)
 * @author johsnon
 *
 */
public class GoodsInfo {
	String goods_no;
	String goods_name;

	public String getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

}
