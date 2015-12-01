package com.bluemapletach.app.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.net.SyslogAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bluemapletach.app.model.MovieDetail;
import com.bluemapletach.app.model.TimeDetails;
import com.bluemapletach.app.model.UserDetails;
//import com.bluemapletach.app.service.ReserveServiceImp;
import com.bluemapletach.app.service.ServiceInterface;

@Controller
public class ReserveController {
	@Autowired
	ServiceInterface service;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView registration() {
		// returning the controller into registration page
		System.out.println("Registration");
		ModelAndView model = new ModelAndView();
		model.setViewName("insert");
		return model;

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute UserDetails userDetails) {
		// insert the detail into database
		System.out.println("insert Controller");
		service.insert(userDetails);
		String msg = "Registration sucessfully Completed";
		return new ModelAndView("home", "msg", msg);

	}

	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public ModelAndView checklog(@RequestParam("username") String name, @RequestParam("password") String pass)
			throws Exception {
		// checking login

		UserDetails userDetails = new UserDetails();
		userDetails.setUsername(name);
		userDetails.setPassword(pass);
		service.checklog(userDetails);
		String msg = userDetails.getMsg();
		if (msg.equals("adminrole")) {
			return new ModelAndView("detail", "name", name);

		} else if (msg.equals("userrole")) {

		} else if (msg.equals("invalid")) {
			String msg1 = "username and password does not matched";
			return new ModelAndView("home", "msg", msg1);
		} else {

		}

		return null;

	}

	@RequestMapping(value = "/hom")
	public ModelAndView display() {
		String msg = "welcome back....";
		return new ModelAndView("home", "msg", msg);

	}

	@RequestMapping(value = "/edit")
	public ModelAndView detail(@RequestParam("name") int movie_id) {

		 System.out.println(movie_id);
		 MovieDetail movie=service.detail(movie_id);
		 
		int id = movie.getMovie_id();
		//System.out.println(id);
		return new ModelAndView("movielist","name",id);

	}

	@RequestMapping(value = "/mlist", method = RequestMethod.POST)
	public ModelAndView movieListInsert(@ModelAttribute MovieDetail movieDetail) {
		System.out.println("detail");
		service.movieListInsert(movieDetail);
		String msg = "edited sucessfully";
		return new ModelAndView("detail", msg, msg);
	}

	@RequestMapping(value = "/llists")
	public ModelAndView listOfmovie() {

		List<MovieDetail> details = service.listOfmovie();
		System.out.println(details);
        
		return new ModelAndView("detail", "details", details);
	}

	@RequestMapping(value = "/edittime")
	public ModelAndView movieTiming(@RequestParam("id") int timing_id) {
		int msg=timing_id;
		return new ModelAndView("timelist","msg",msg);
	}


	@RequestMapping(value = "/ltime", method = RequestMethod.POST)
	public ModelAndView movieTime(@ModelAttribute TimeDetails timeDetails) {
		System.out.println("detail");
		service.movieTime(timeDetails);
		ModelAndView model=new ModelAndView();
		model.setViewName("detail");
		return model ;
	}

	@RequestMapping(value = "/timelist")
	public ModelAndView timeList() {
		List<TimeDetails> timeDetails = service.timeList();
		System.out.println(timeDetails);

		return new ModelAndView("detail","timel",timeDetails);
		
	}

}
