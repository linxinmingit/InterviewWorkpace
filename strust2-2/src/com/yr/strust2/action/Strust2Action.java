package com.yr.strust2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yr.strust2.dao.BaseDao;
import com.yr.strust2.pojo.User;

public class Strust2Action extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private String userName;
    private String password;
    private BaseDao baseDao;

    public String execute() {

//        if (userName.equals("admin") && password.equals("123")) {
//            return SUCCESS;
//        } else {
//            return ERROR;
//        }
    	baseDao = new BaseDao();
    	User user = baseDao.getUserByUserNameAndPassWords(userName, password);
        if (userName.equals(user.getUsername()) && password.equals(user.getPasswords())) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }
    public String save()
    {
    	baseDao = new BaseDao();
//    	HttpServletResponse response = ServletActionContext.getResponse();
    	HttpServletRequest request = ServletActionContext.getRequest();
    	User user = new User(request.getParameter("username"),request.getParameter("passwords"),request.getParameter("url"));
    	baseDao.save(user);
    	request.setAttribute("user", user);
    	return INPUT;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
