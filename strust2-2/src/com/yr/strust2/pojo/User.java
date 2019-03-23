package com.yr.strust2.pojo;

public class User {
	private Integer id;
	private String username;
	private String passwords;
	private String url;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String passwords, String url) {
		super();
		this.username = username;
		this.passwords = passwords;
		this.url = url;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwords=" + passwords + ", url=" + url + "]";
	}

}
