package cn.yr.jdbc;

/**
 * @author Administrator
 *
 */
public class User {
	private Integer id;
	private String name;
	private String pd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPd() {
		return pd;
	}
	public void setPd(String pd) {
		this.pd = pd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pd=" + pd + "]";
	}
}
