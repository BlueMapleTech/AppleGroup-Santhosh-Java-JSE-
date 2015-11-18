package com.bluemapletech.app.service;

import com.bluemapletech.app.dao.UserDao;
import com.bluemapletech.app.model.UserModel;

public class UserService {
	UserDao dao = new UserDao();
	
	public boolean adduser(UserModel user) throws Exception {
		//UserDao dao = new UserDao();
		return dao.adduser(user);

	}

	public UserModel logging(UserModel user) throws Exception {
		UserDao dao = new UserDao();
		return dao.logging(user);

	}

	public void deleteUser(String name) throws Exception {
		UserDao dao = new UserDao();
		dao.deleteUser(name);

	}

	public Object getAllUsers() throws Exception {
		UserDao dao = new UserDao();

		return dao.getAllUsers();
	}

	public UserModel getUserById(UserModel user) throws Exception {
		UserDao ud = new UserDao();
		return ud.getUserById(user);

	}

	public boolean update(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		return dao.update(user);

	}

	public boolean delete(UserModel user) throws Exception {
		UserDao dao = new UserDao();
		return dao.delete(user);
	}

}
