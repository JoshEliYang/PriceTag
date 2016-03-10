package cn.springmvc.model;

import java.sql.Date;

import com.springmvc.utils.GLCPDateUtils;

public class SkuCheck {

	private int id;
	
	private String shopId;
	
	private String actor;
	
	private Date creationDate = GLCPDateUtils.getNowDate();
	
	private String checker;
	
	private Date checkDate;

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

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public SkuCheck(int id, String shopId, String actor, Date creationDate,
			String checker, Date checkDate) {
		super();
		this.id = id;
		this.shopId = shopId;
		this.actor = actor;
		this.creationDate = GLCPDateUtils.getNowDate();
		this.checker = checker;
		this.checkDate = checkDate;
	}

	public SkuCheck() {
		super();
	}

	@Override
	public String toString() {
		return "SkuCheck [id=" + id + ", shopId=" + shopId + ", actor=" + actor
				+ ", creationDate=" + creationDate + ", checker=" + checker
				+ ", checkDate=" + checkDate + "]";
	}
}
