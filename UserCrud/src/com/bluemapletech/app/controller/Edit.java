package com.bluemapletech.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluemapletech.app.model.UserModel;
import com.bluemapletech.app.service.UserService;

/**
 * Servlet implementation class Edit
 */
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action1");
		if (action.equals("update")) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			try {
				Cookie ck[] = request.getCookies();
				String name = ck[0].getValue();
				UserModel user = new UserModel();
				response.setContentType("text/html");
				user.setName(name);
				user.setPass(request.getParameter("pass"));
				user.setContact(request.getParameter("contact"));
				user.setFname(request.getParameter("fname"));
				user.setLname(request.getParameter("lname"));
				user.setSex(request.getParameter("sex"));
				user.setAddr(request.getParameter("addr"));
				String Id = request.getParameter("role");
				if (Id.equals("admin")) {
					user.setId(1);
				} else {
					user.setId(2);
				}
				Date date = new Date();
				String today = date.toString();
				// user.setCreatedby(request.getParameter("name"));
				user.setUpdatedby(name);
				// user.setCreateddate(today);
				user.setUpdateddate(today);

				UserService us = new UserService();
				boolean a = us.update(user);
				if (a == true) {
					out.print("updated sucess");
				} else {
					out.println("updated unsucess");
				}
				RequestDispatcher rd2 = request
						.getRequestDispatcher("list1.html");
				rd2.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

		}

	}

}
