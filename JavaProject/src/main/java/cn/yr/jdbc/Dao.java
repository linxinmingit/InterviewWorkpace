package cn.yr.jdbc;

import java.util.List;

public interface Dao {
	public List<User> getUserList();
	public User getUserById(Integer id);
	public int save(User user);
	public int update(User user);
	public void delete(Integer id);
}
