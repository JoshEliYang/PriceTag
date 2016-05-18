package cn.springmvc.model;

public class User {

	private int id;
	
	private String username;
	
	private String password;
	
	private String shopId;
	
	private String role;
	
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
		super();
	}

	public User(int id, String username, String password, String shopId,
			String role,String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.shopId = shopId;
		this.role = role;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", shopId=" + shopId + ", role=" + role + ", email" + email + "]";
	}
	
}
