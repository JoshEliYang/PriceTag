package cn.springmvc.model;

public class Select {

	private String id;
	
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Select() {
		super();
	}

	public Select(String id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
}
