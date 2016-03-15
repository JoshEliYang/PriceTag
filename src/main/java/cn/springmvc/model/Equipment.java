package cn.springmvc.model;

public class Equipment {
	
	private int id;

	private String equName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEquName() {
		return equName;
	}

	public void setEquName(String equName) {
		this.equName = equName;
	}

	public Equipment() {
		super();
	}

	public Equipment(int id, String equName) {
		super();
		this.id = id;
		this.equName = equName;
	}
}
