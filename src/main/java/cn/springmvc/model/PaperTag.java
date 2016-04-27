package cn.springmvc.model;

import java.sql.Date;

import com.springmvc.utils.GLCPDateUtils;

public class PaperTag {

	private int id;
	
	private Date creationDate = GLCPDateUtils.getNowDate();
	
	private String memo;
	
	private int isDelete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public PaperTag(int id, Date creationDate, String memo, int isDelete) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.memo = memo;
		this.isDelete = isDelete;
	}

	public PaperTag() {
		super();
	}

	@Override
	public String toString() {
		return "PaperTag [id=" + id + ", creationDate=" + creationDate
				+ ", memo=" + memo + ", isDelete=" + isDelete + "]";
	}
}
