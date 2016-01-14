package cn.springmvc.model;

public class RequestParams {

	private String origin;
	
	private String shopId;
	
	private String keyWord;

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

	public RequestParams(String origin, String shopId, String keyWord) {
		super();
		this.origin = origin;
		this.shopId = shopId;
		this.keyWord = keyWord;
	}

	public RequestParams() {
		super();
	}
}
