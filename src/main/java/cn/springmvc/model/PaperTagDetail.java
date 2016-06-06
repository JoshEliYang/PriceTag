package cn.springmvc.model;

public class PaperTagDetial {

	private int id;
	
	private int pageTagId;
	
	private int priceTagId;
	
	private int isDelete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageTagId() {
		return pageTagId;
	}

	public void setPageTagId(int pageTagId) {
		this.pageTagId = pageTagId;
	}

	public int getPriceTagId() {
		return priceTagId;
	}

	public void setPriceTagId(int priceTagId) {
		this.priceTagId = priceTagId;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public PaperTagDetial(int id, int pageTagId, int priceTagId, int isDelete) {
		super();
		this.id = id;
		this.pageTagId = pageTagId;
		this.priceTagId = priceTagId;
		this.isDelete = isDelete;
	}

	public PaperTagDetial() {
		super();
	}

	@Override
	public String toString() {
		return "PaperTagDetial [id=" + id + ", pageTagId=" + pageTagId
				+ ", priceTagId=" + priceTagId + ", isDelete=" + isDelete + "]";
	}
}
