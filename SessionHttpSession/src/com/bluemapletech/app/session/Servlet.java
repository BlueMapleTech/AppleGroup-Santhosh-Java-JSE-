package com.bluemapletech.app.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try
	{
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String a=request.getParameter("name");
	String b=request.getParameter("pass");
	out.print("<br>name="+" "+a);
	out.print("<br>password="+" "+b);
	HttpSession hs=request.getSession();
	hs.setAttribute("uname", a);
	hs.setAttribute("upass", b);
	out.print("<a href='MyServlet1'>view details</a>");
	out.close();
	}
	catch(Exception e)
	{PrintWriter out=response.getWriter();
     out.print(e);		
	}
}
}