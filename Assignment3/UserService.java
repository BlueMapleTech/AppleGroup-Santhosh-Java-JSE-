package com.bluemapletech.app.service;

import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

import com.bluemapletech.app.dao.UserDao;
import com.bluemapletech.app.model.UserModel;

public class UserService {
	UserDao ud = new UserDao();

	public void add(UserModel um) {

		try {
			ud.insert(um);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void update(UserModel um) throws Exception {
		ud.update(um);
	}

	public ArrayList<UserModel> activity1() throws ClassNotFoundException,
			Exception {
		return ud.list();

	}

	public void delete(UserModel um) {
		try {
			ud.delete(um);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserModel login1(UserModel um) throws SQLException {
		return ud.login1(um);
	}
}