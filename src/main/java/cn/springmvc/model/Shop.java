package cn.springmvc.model;

public class Shop {
	
	private int id;
	
	private String shopId;
	
	private String shopName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Shop() {
		super();
	}

	public Shop(int id, String shopId, String shopName) {
		super();
		this.id = id;
		this.shopId = shopId;
		this.shopName = shopName;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", shopId=" + shopId + ", shopName="
				+ shopName + "]";
	}
}
