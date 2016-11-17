package cn.springmvc.model;

public class RequestParams {

	private String origin;

	private String shopId;

	private String keyWord;

	private int limit;
	
	private int offset;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public RequestParams(String origin, String shopId, String keyWord,
			int limit, int offset) {
		super();
		this.origin = origin;
		this.shopId = shopId;
		this.keyWord = keyWord;
		this.limit = limit;
		this.offset = offset;
	}

	public RequestParams() {
		super();
	}

}
