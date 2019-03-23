package cn.yr.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository(value = "daoImpl")
public class DaoImpl implements Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		List<User> lists = (List<User>) jdbcTemplate.query("select * from users",rowMapper);
		return lists;
	}

	public User getUserById(Integer id) {
		String sql = "SELECT * FROM users WHERE id = ?";
//		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	public int save(User user) {
		// TODO Auto-generated method stub
		int count = jdbcTemplate.update("insert into users(name,passWords) values(?,?)", user.getName(),user.getPd());
		return count;
	}

	public int update(User user) {
		// TODO Auto-generated method stub
		int count = jdbcTemplate.update("update users set name = ? ,passWords = ? where id = ?" , user.getName(),user.getPd(),user.getId());
		return count;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete * from users where id = ?", id);
	}

}
