package com.bluemapletach.app.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bluemapletach.app.model.MovieDetail;
import com.bluemapletach.app.model.UserDetails;

public class MovieRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		MovieDetail userDetails = new MovieDetail();
		userDetails.setMovie_id(rs.getInt("movie_id"));
		userDetails.setMoviename(rs.getString("moviename"));
		userDetails.setRelease_date(rs.getString("release_date"));
		userDetails.setNo_of_show(rs.getString("no_of_show"));
		return userDetails;
	
		
	}

}
