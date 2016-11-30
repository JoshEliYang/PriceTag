package cn.springmvc.model;

public class SelectPriceTag {
	
	private String goodsNo;
	
	private int offset;
	
	private int limit;

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	
	
	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "SelectPriceTag [goodsNo=" + goodsNo + ", offset=" + offset
				+ ", limit=" + limit + "]";
	}

	public SelectPriceTag() {
		super();
	}

	public SelectPriceTag(String goodsNo, int offset, int limit) {
		super();
		this.goodsNo = goodsNo;
		this.offset = offset;
		this.limit = limit;
	}


	
	
	
	
}
