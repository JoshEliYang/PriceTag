package cn.springmvc.model;

public class Difference {
	String name;
	int param1;
	int param2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParam1() {
		return param1;
	}

	public void setParam1(int param1) {
		this.param1 = param1;
	}

	public int getParam2() {
		return param2;
	}

	public void setParam2(int param2) {
		this.param2 = param2;
	}
	
	public Difference(){
		super();
	}

	public Difference(String name, int param1, int param2) {
		super();
		this.name = name;
		this.param1 = param1;
		this.param2 = param2;
	}
	
}
