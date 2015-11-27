package com.bluemapletach.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemapletach.app.Dao.DaoInterface;
import com.bluemapletach.app.model.MovieDetail;
import com.bluemapletach.app.model.TimeDetails;
import com.bluemapletach.app.model.UserDetails;

@Service
public class ReserveServiceImp implements ServiceInterface {
	@Autowired
	DaoInterface dao;

	public UserDetails insert(UserDetails userDetails) {

		System.out.println("insert method");
		dao.insert(userDetails);
		return userDetails;

	}

	public UserDetails checklog(UserDetails userDetails) throws Exception {
		String name1 = userDetails.getUsername();
		String pass1 = userDetails.getPassword();
		dao.checklog(userDetails);
		int role = userDetails.getRoleid1();
		String name = userDetails.getUsername();
		String pass = userDetails.getPassword();
		if ((name1.equals(name)) && (pass1.equals(pass)) && (role == 1)) {
			System.out.println("admin role");
			String msg = "adminrole";
			userDetails.setMsg(msg);
		} else if ((name1.equals(name)) && (pass1.equals(pass)) && (role == 2)) {
			System.out.println("userrole");
			String msg = "userrole";
			userDetails.setMsg(msg);
		} else {
			String msg = "invalid";
			userDetails.setMsg(msg);
		}

		return userDetails;
	}

	public MovieDetail movieListInsert(MovieDetail movieDetail)
	{
		dao.movieListInsert(movieDetail);
		return movieDetail;
		
	}
	public List<MovieDetail> listOfmovie()
	{
		System.out.println("service");
		return dao.listOfmovie();
	}
	public MovieDetail detail(int movie_id)
	{
		return dao.detail(movie_id);
	}
	public TimeDetails movieTime(TimeDetails timeDetails)
	{
		return dao.movieTime(timeDetails);
	}
	public List<TimeDetails> timeList()
	{
		return dao.timeList();
	}
}
