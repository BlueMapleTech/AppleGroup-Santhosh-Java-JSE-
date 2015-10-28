package com.bluemapletech.app.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession hp=request.getSession(true);
		String n=(String) hp.getAttribute("uname");
		String m=(String) hp.getAttribute("upass");
		out.print("name="+" "+n);
		out.print("password"+" "+m);
		 Date c = new Date(hp.getCreationTime());
		out.print("Date="+c);
		Date d=new Date(hp.getLastAccessedTime());
		out.print("last date="+d);
	}catch(Exception e)
	{
		System.out.println(e);
	}
	
	
	
	}

}
