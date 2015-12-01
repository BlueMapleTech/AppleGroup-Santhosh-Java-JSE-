package com.bluemapletach.app.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bluemapletach.app.model.MovieDetail;
import com.bluemapletach.app.model.TimeDetails;
import com.bluemapletach.app.model.UserDetails;

@Repository
public class ReserveDao implements DaoInterface {
	public UserDetails userDetails;
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	private JdbcTemplate getJdbcTemplate() {

		return jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public UserDetails insert(UserDetails userDetails) {
		// inserting the value into database
		System.out.println("dao method");
		String sql = "INSERT INTO user "
				+ "(username,password,email,firstname,lastname,address,createdby,updatedby,createddate,updateddate,role_roleid) VALUES (?, ?, ?,?,?,?,?,?,?,?,?)";

		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql,
				new Object[] { userDetails.getUsername(), userDetails.getPassword(), userDetails.getEmail(),
						userDetails.getFirstname(), userDetails.getLastname(), userDetails.getAddress(),
						userDetails.getUsername(), userDetails.getUsername(), userDetails.getDate(),
						userDetails.getDate(), userDetails.getRoleid() });

		return userDetails;

	}

	public UserDetails checklog(UserDetails userDetails) throws Exception {
		// selecting the name and password to check login
		System.out.println("dao log checking");
		String name1 = userDetails.getUsername();
		String sql = "SELECT * FROM user WHERE username = ?";
		// UserRowMapper implementation
		UserDetails userDetails1 = (UserDetails) getJdbcTemplate().queryForObject(sql, new Object[] { name1 },
				new UserRowMapper());
		int role = userDetails1.getRoleid1();
		String name = userDetails1.getUsername();
		String pass = userDetails1.getPassword();
		userDetails.setRoleid1(role);
		userDetails.setUsername(name);
		userDetails.setPassword(pass);
		return userDetails;

	}

	public MovieDetail movieListInsert(MovieDetail movieDetail) {
		System.out.println(movieDetail.getMovie_id());
		int movie_id = movieDetail.getMovie_id();
		String sql = "UPDATE  movie SET moviename=?,release_date=?,no_of_show=?,updateddate=? WHERE movie_id=?";
		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql, movieDetail.getMoviename(), movieDetail.getRelease_date(), movieDetail.getNo_of_show(),
				movieDetail.getDate(), movieDetail.getMovie_id());

		return movieDetail;

	}

	public List<MovieDetail> listOfmovie() {
		System.out.println("dao method");
		String sql = "select * from movie";
		List<MovieDetail> movieDetail = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(MovieDetail.class));

		System.out.println(movieDetail);

		return movieDetail;

	}

	public MovieDetail detail(int movie_id) {
		System.out.println(movie_id);
		String sql = "SELECT * FROM movie WHERE movie_id = ?";
		MovieDetail userDetails1 = (MovieDetail) getJdbcTemplate().queryForObject(sql, new Object[] { movie_id },
		new MovieRowMapper());
		int id = userDetails1.getMovie_id();
		System.out.println(id);
		MovieDetail movie = new MovieDetail();
		String name = userDetails1.getMoviename();
		String release = userDetails1.getRelease_date();
		String no = userDetails1.getNo_of_show();
		movie.setMovie_id(id);
		movie.setMoviename(name);
		movie.setRelease_date(release);
		movie.setNo_of_show(no);

		return movie;

	}
	public TimeDetails movieTime(TimeDetails timeDetails)
	{
		
		System.out.println(timeDetails.getTiming_id());
		int timing_id = timeDetails.getTiming_id();
		String sql = "UPDATE  timing SET timing=?,updateddate=? WHERE timing_id=?";
		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql, timeDetails.getTiming(),timeDetails.getDate(), timeDetails.getTiming_id());

		return timeDetails;
		
	}
	public List<TimeDetails> timeList()
	{

		System.out.println("dao method");
		String sql = "select * from timing";
		List<TimeDetails> timeDetails = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(TimeDetails.class));

		System.out.println(timeDetails);

		return timeDetails;

	}
}
