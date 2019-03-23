package com.yr.strust2.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.yr.strust2.pojo.User;

public class BaseDao {
	private static Connection connection = null;
	private static PreparedStatement pre = null;
	private static ResultSet res = null;
	
	public static void main(String[] args) {
		User user = new BaseDao().getUserByUserNameAndPassWords("¡÷ˆŒ√Ù","1125");
		System.out.println(user.toString());
	}
	@Before
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.63:3306/array", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
//	@After
//	public static void closeAll(Connection conn, PreparedStatement prepar, ResultSet resu, Statement stat) {
//
//		try {
//			if (resu != null) {
//				resu.close();
//			}
//			if (prepar != null) {
//				prepar.close();
//			}
//			if (stat != null) {
//				stat.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
	@Test
	public User getUserByUserNameAndPassWords(String account,String pd)
	{
		User user = null;
		try {
			connection = BaseDao.getConnection();
			pre = (PreparedStatement) connection.prepareStatement("select * from user  where userName = ? and passworde = ? ");
			pre.setString(1, account);
			pre.setString(2, pd);
			res = pre.executeQuery();
			while(res.next())
			{
				user = new User();
				user.setId(res.getInt("id"));
				user.setPasswords(res.getString("passworde"));
				user.setUsername(res.getString("userName"));
				user.setUrl(res.getString("url"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}
	public void save(User user)
	{
		try {
			connection = BaseDao.getConnection();
			pre = (PreparedStatement) connection.prepareStatement("insert into user(userName,passwords,url) values(?,?,?)");
			pre.setString(1, user.getUsername());
			pre.setString(2, user.getPasswords());
			pre.setString(3, user.getUrl());
			pre.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}

