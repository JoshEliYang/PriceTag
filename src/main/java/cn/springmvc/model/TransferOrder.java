package cn.springmvc.model;

import java.sql.Date;

import com.springmvc.utils.GLCPDateUtils;

/**
 * 
 * @author Edward
 * @description 门店物品调拨单
 * @date 2016年6月12日
 */
public class TransferOrder {

	// 单号
	private int id;
	
	// 申请者
	private String actor;
	
	// 提交申请门店
	private String applyShopId;

	// 处理者
	private String handler;
	
	// 处理申请门店
	private String dealShopId;

	// 申请日期sql.date
	private Date applyDate = GLCPDateUtils.getNowDate();
	
	// 处理日期
	private Date dealDate;
	
	// 0：未取消；1.已取消
	private boolean isDeleted;

	// private String checker;// 审核人

	// private Date checkDate;// 审核日起

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getApplyShopId() {
		return applyShopId;
	}

	public void setApplyShopId(String applyShopId) {
		this.applyShopId = applyShopId;
	}

	public String getDealShopId() {
		return dealShopId;
	}

	public void setDealShopId(String dealShopId) {
		this.dealShopId = dealShopId;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public TransferOrder() {
		// TODO Auto-generated constructor stub
	}

	public TransferOrder(int id, String actor, String applyShopId, String handler, String dealShopId, Date applyDate,
			Date dealDate, boolean isDeleted) {
		super();
		this.id = id;
		this.actor = actor;
		this.applyShopId = applyShopId;
		this.handler = handler;
		this.dealShopId = dealShopId;
		this.applyDate = applyDate;
		this.dealDate = dealDate;
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "TransferOrder [id=" + id + ", actor=" + actor + ", applyShopId=" + applyShopId + ", handler=" + handler
				+ ", dealShopId=" + dealShopId + ", applyDate=" + applyDate + ", dealDate=" + dealDate + ", isDeleted="
				+ isDeleted + "]";
	}

}
