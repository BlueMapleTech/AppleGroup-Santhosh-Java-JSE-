package com.pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String a,b;
	a=request.getParameter("name");
	b=request.getParameter("pass");
	if(a.equals("santhosh")&&b.equals("12345"))
	{
		//out.print("login sucess");
	RequestDispatcher rd=request.getRequestDispatcher("MyServlet3");
	rd.forward(request, response);
	}
	else
	{
		out.println("login unsucess");

		RequestDispatcher rd=request.getRequestDispatcher("/index.html");
		rd.include(request, response);

	}
		
	}

}
