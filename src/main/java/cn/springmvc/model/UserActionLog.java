package cn.springmvc.model;

import java.sql.Date;

public class UserActionLog {

	private int id;
	
	private int userId;
	
	private String action;
	
	private Date actionDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public UserActionLog() {
		super();
	}

	public UserActionLog(int id, int userId, String action, Date actionDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.action = action;
		this.actionDate = actionDate;
	}
}
