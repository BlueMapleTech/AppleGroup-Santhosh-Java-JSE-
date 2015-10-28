package com.bluemaple.app.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String a = request.getParameter("name");
			out.print("welcome" + " " + a);
			out.print("<form action='MyServlet1' method='post'>");
			out.print("<input type='hideden' name='name' value='" + a + "'>");
			out.print("<input type='submit' value='go'>");
			out.print("</form>");
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
