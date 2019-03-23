package cn.yr.strust2.filter;

public class User {
	private Integer id;
	private String username;
	private String passwords;
	private Double height;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	
	public User() {
		super();
	}
	public User(Integer id, String username, String passwords, Double height) {
		super();
		this.id = id;
		this.username = username;
		this.passwords = passwords;
		this.height = height;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwords=" + passwords + ", height=" + height + "]";
	}
	
}
