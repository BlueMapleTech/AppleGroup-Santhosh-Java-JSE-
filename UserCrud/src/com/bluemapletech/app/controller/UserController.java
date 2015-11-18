package com.bluemapletech.app.controller;

//package com.bluemapletech.app.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bluemapletech.app.dao.UserDao;
import com.bluemapletech.app.model.UserModel;
import com.bluemapletech.app.service.UserService;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserModel user = new UserModel();

	/**
	 * @throws Exception
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,

	HttpServletResponse response) throws ServletException, IOException {
		String action1 = request.getParameter("action");
		String name = request.getParameter("userId");
		Cookie ck1 = new Cookie("name1", name);
		response.addCookie(ck1);

		if (action1.equalsIgnoreCase("delete")) {
			try {
				UserService us = new UserService();
				us.deleteUser(name);
				UserDao dao = new UserDao();
				request.setAttribute("users", dao.getAllUsers());
				RequestDispatcher rd = request
						.getRequestDispatcher("listofuser.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (action1.equalsIgnoreCase("edit")) {
			try {
				HttpSession hs = request.getSession();
				hs.setAttribute("action", name);

				RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				out.print(e);
			}
		}

		else

		if (action1.equalsIgnoreCase("update")) {
			try {
				HttpSession hs = request.getSession(true);
				String m = (String) hs.getAttribute("action");
				System.out.print("username" + m);
				Cookie ck2[] = request.getCookies();
				String n = ck2[0].getValue();
				System.out.println("admin name" + n);
				UserModel user = new UserModel();
				response.setContentType("text/html");
				user.setName(m);
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
				user.setUpdatedby(n);
				user.setUpdateddate(today);
				UserService us = new UserService();
				user = us.getUserById(user);
				request.setAttribute("user", user);
				RequestDispatcher rd = request
						.getRequestDispatcher("link.html");
				rd.forward(request, response);

			} catch (Exception e) {
				out.print(e);
			}

		} else {

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action1");
		if (action.equals("signup")) {
			try {
				UserModel user = new UserModel();
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				user.setName(request.getParameter("name"));
				user.setPass(request.getParameter("pass"));
				user.setEmail(request.getParameter("email"));
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
				user.setCreatedby(request.getParameter("name"));
				user.setUpdatedby(request.getParameter("name"));
				user.setCreateddate(today);
				user.setUpdateddate(today);

				UserService us = new UserService();
				boolean a = us.adduser(user);
				if (a == true) {
					out.print("registered sucess");
				} else {
					out.println("registered un sucess");
				}
				RequestDispatcher rd = request
						.getRequestDispatcher("index.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else

		if (action.equalsIgnoreCase("login")) {
			try {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();

				UserService us = new UserService();
				user.setName(request.getParameter("name"));
				us.logging(user);
				String name = request.getParameter("name");
				String pass = request.getParameter("pass");
				// out.print(name+pass);
				String name1 = user.getName();
				String pass1 = user.getPass();
				String email = user.getEmail();
				int id = user.getId();
				// out.print(name1 + pass1 + email + id);
				if ((name.equals(name1) || (name.equals(email)))
						&& (pass.equals(pass1)) && (id == 1)) {
					out.print(" Admin login sucess");
					Cookie ck2 = new Cookie("admin", name1);
					response.addCookie(ck2);
					RequestDispatcher rd = request
							.getRequestDispatcher("link.html");
					rd.include(request, response);

				} else if ((name.equals(name1)) && (pass.equals(pass1))
						&& (id == 2)) {
					out.print("userlogin sucess");
					Cookie ck = new Cookie("name", name);
					response.addCookie(ck);

					RequestDispatcher rd = request
							.getRequestDispatcher("list1.html");
					rd.forward(request, response);
				} else {
					out.print("login unsucess");
					RequestDispatcher rd = request
							.getRequestDispatcher("index.jsp");
					rd.include(request, response);

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else

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
				user.setUpdatedby(name);
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
