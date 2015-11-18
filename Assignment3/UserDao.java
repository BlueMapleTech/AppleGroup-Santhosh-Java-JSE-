package com.bluemapletech.app.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.bluemapletech.app.model.UserModel;
import com.mysql.jdbc.Connection;
public class UserDao {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br1 = new BufferedReader(isr);

	String name;
	String pass;

	public void connection() throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

	}

	public void insert(UserModel um) throws SQLException {
		System.out.println("user details:" + um.toString());
		Connection con = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/user", "root", "admin");
		Statement stmt = (Statement) con.createStatement();
		stmt.executeUpdate("insert into userdetail1(uname,upass,email,sex,contact) values('"
				+ um.getUserName()
				+ "','"
				+ um.getPassword()
				+ "','"
				+ um.getEmail()
				+ "','"
				+ um.getSex()
				+ "','"
				+ um.getContactNo() + "')");

	}

	public ArrayList<UserModel> list() throws Exception, ClassNotFoundException {
		ArrayList<UserModel> arraylist = new ArrayList<UserModel>();
		{


			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user", "root", "admin");

			java.sql.Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT uname,upass,email,sex,contact FROM userdetail1 ");

			while (rs.next()) {
				UserModel um = new UserModel();
				um.setUserName(rs.getString(1));
				um.setPassword(rs.getString(2));
				um.setEmail(rs.getString(3));
				um.setSex(rs.getString(4));
				um.setContactNo(rs.getString(5));
				arraylist.add(um);
			}

		}
		return arraylist;
	}
	public void update(UserModel um) throws SQLException {
		System.out.println("user details:" + um.toString());
		Connection con = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/user", "root", "admin");
		Statement stmt = (Statement) con.createStatement();
		{
		String query = "UPDATE userdetail1 SET uname='" + um.getUserName()
				+ "',upass='" + um.getPassword() + "',email='"
				+ um.getEmail() + "',sex='" + um.getSex() + "',contact='"
				+ um.getContactNo() + "' where uname= '"+um.getUserName()+"'";
		stmt.executeUpdate(query);
		}
	}

	public void delete(UserModel um) throws Exception {
		Connection con = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/user", "root", "admin");
		Statement stmt = (Statement) con.createStatement();
		String query = "delete from user.userdetail1 where uname= '"+ um.getUserName()+"'";
		stmt.executeUpdate(query);

	}

	public UserModel login1(UserModel um) throws SQLException {
	   	Connection con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user", "root", "admin");
			Statement stmt = (Statement) con.createStatement();

			String sql = "SELECT * FROM userdetail1 WHERE uname='" + um.getUserName()+"'";
			ResultSet rs = stmt.executeQuery(sql);
             
		while(rs.next()) {
			um.setUserName(rs.getString("uname"));
			um.setPassword(rs.getString("upass"));
			
		}	
					return um;
	}}

