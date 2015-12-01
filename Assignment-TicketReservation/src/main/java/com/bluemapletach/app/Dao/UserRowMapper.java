package com.bluemapletach.app.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bluemapletach.app.model.UserDetails;

public class UserRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("this is row mapper");
		UserDetails userDetails = new UserDetails();
		userDetails.setUsername(rs.getString("username"));
		userDetails.setPassword(rs.getString("password"));
		userDetails.setRoleid1(rs.getInt("role_roleid"));
		return userDetails;
	}

}
