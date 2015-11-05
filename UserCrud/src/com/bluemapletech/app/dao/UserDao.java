package com.bluemapletech.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bluemapletech.app.connection.Database;
import com.bluemapletech.app.model.UserModel;

public class UserDao {
	// @SuppressWarnings("unused")
	private Connection connection;
	UserModel user = new UserModel();

	public UserDao()  {
		try{
		connection = Database.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	boolean a = false;

	public boolean adduser(UserModel user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into details(username, password, email, contactno,firstname,lastname,sex,addr,createdby,updatedby,createddate,updateddate,role_role_id) values (?, ?, ?, ?,?,?,?,?,?,?,?,?,? )");
			// Parameters start with 1
			a = true;
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPass());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getContact());
			preparedStatement.setString(5, user.getFname());
			preparedStatement.setString(6, user.getLname());
			preparedStatement.setString(7, user.getSex());
			preparedStatement.setString(8, user.getAddr());
			preparedStatement.setString(9, user.getCreatedby());
			preparedStatement.setString(10, user.getUpdatedby());
			preparedStatement.setString(11, user.getCreateddate());
			preparedStatement.setString(12, user.getUpdateddate());
			preparedStatement.setInt(13, user.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;

	}

	public UserModel logging(UserModel user) {
		// TODO Auto-generated method stub
		try {

			Statement stmt = (Statement) connection.createStatement();

			String sql = "SELECT * FROM details WHERE username='"
					+ user.getName() + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				user.setName(rs.getString("username"));
				user.setPass(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setId(rs.getInt("role_role_id"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		// return user;
		return user;
	}

	public List<UserModel> getAllUsers() {
		List<UserModel> users = new ArrayList<UserModel>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from details");
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setUser_id(rs.getInt("user_id"));
				user.setName(rs.getString("username"));
				user.setPass(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setContact(rs.getString("contactno"));
				user.setFname(rs.getString("firstname"));
				user.setLname(rs.getString("lastname"));
				user.setSex(rs.getString("sex"));
				user.setAddr(rs.getString("addr"));
				user.setCreatedby(rs.getString("createdby"));
				user.setUpdatedby(rs.getString("updatedby"));
				user.setCreateddate(rs.getString("createddate"));
				user.setUpdateddate(rs.getString("updateddate"));
				user.setId(rs.getInt("role_role_id"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public void deleteUser(String name) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from details where username=?");
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public UserModel getUserById(UserModel user) throws SQLException {

		Statement stmt = (Statement) connection.createStatement();
		{
			String query = "UPDATE details SET password='" + user.getPass()
					+ "',contactno='" + user.getContact() + "',firstname='"
					+ user.getFname() + "',lastname='" + user.getLname()
					+ "',sex='" + user.getSex() + "',addr='" + user.getAddr()
					+ "',updatedby='" + user.getUpdatedby() + "',updateddate='"
					+ user.getUpdateddate() + "' ,role_role_id='"
					+ user.getId() + "'where username= '" + user.getName()
					+ "'";
			stmt.executeUpdate(query);

		}
		return user;
	}

	boolean a1 = false;

	public boolean update(UserModel user) throws SQLException {

		Statement stmt = (Statement) connection.createStatement();
		
			String query = "UPDATE details SET password='" + user.getPass()
					+ "',contactno='" + user.getContact() + "',firstname='"
					+ user.getFname() + "',lastname='" + user.getLname()
					+ "',sex='" + user.getSex() + "',addr='" + user.getAddr()
					+ "',updatedby='" + user.getUpdatedby() + "',updateddate='"
					+ user.getUpdateddate() + "' ,role_role_id='"
					+ user.getId() + "'where username= '" + user.getName()
					+ "'";
			stmt.executeUpdate(query);
			a1 = true;
		
		return a1;

	}

	boolean b = false;

	public boolean delete(UserModel user) throws SQLException {

		Statement stmt = (Statement) connection.createStatement();
		String query = "delete from details where username= '" + user.getName()
				+ "'";
		stmt.executeUpdate(query);
		b = true;
		return b;

	}

}