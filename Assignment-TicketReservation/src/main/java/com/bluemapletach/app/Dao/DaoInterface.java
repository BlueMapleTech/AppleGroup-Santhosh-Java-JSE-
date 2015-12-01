package com.bluemapletach.app.Dao;

import java.util.List;

import com.bluemapletach.app.model.MovieDetail;
import com.bluemapletach.app.model.TimeDetails;
import com.bluemapletach.app.model.UserDetails;

public interface DaoInterface {

	public UserDetails insert(UserDetails userDetails);

	public UserDetails checklog(UserDetails userDetails) throws Exception;

	public MovieDetail movieListInsert(MovieDetail movieDetail);

	public List<MovieDetail> listOfmovie();

	public MovieDetail detail(int movie_id);

	public TimeDetails movieTime(TimeDetails timeDetails);

	public List<TimeDetails> timeList();

}
