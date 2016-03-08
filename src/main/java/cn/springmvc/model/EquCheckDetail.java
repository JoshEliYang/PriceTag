package cn.springmvc.model;

public class EquCheckDetail {

	private int id;
	
	private int equCheckId;
	
	private String equName;
	
	private int num;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEquCheckId() {
		return equCheckId;
	}

	public void setEquCheckId(int equCheckId) {
		this.equCheckId = equCheckId;
	}

	public String getEquName() {
		return equName;
	}

	public void setEquName(String equName) {
		this.equName = equName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public EquCheckDetail() {
		super();
	}

	public EquCheckDetail(int id, int equCheckId, String equName, int num) {
		super();
		this.id = id;
		this.equCheckId = equCheckId;
		this.equName = equName;
		this.num = num;
	}

	@Override
	public String toString() {
		return "EquCheckDetail [id=" + id + ", equCheckId=" + equCheckId
				+ ", equName=" + equName + ", num=" + num + "]";
	}
}
