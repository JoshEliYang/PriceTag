package cn.springmvc.model;

public class SkuCheckDetail {

	private int id;
	
	private int skuCheckId;
	
	private String goodsNo;
	
	private String goodsName;
	
	private int num;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSkuCheckId() {
		return skuCheckId;
	}

	public void setSkuCheckId(int skuCheckId) {
		this.skuCheckId = skuCheckId;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public SkuCheckDetail() {
		super();
	}

	public SkuCheckDetail(int id, int skuCheckId, String goodsNo,
			String goodsName, int num) {
		super();
		this.id = id;
		this.skuCheckId = skuCheckId;
		this.goodsNo = goodsNo;
		this.goodsName = goodsName;
		this.num = num;
	}

	@Override
	public String toString() {
		return "SkuCheckDetail [id=" + id + ", skuCheckId=" + skuCheckId
				+ ", goodsNo=" + goodsNo + ", goodsName=" + goodsName
				+ ", num=" + num + "]";
	}
}
