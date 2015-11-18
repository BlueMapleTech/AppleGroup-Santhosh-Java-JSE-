package com.pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            PrintWriter out=response.getWriter();
            java.util.Date today=new java.util.Date();
            for(int i=0;i<15;i++)
            {
           String a=Integer.toString((int)(Math.random()*15));
            out.print("  "+a);
            } 
           out.println("<html>"+"<body>"+
            "<h1 align=center>today date</h1>>"+"<br/>"+"<p align=center>"+"         "+today+"</p>"+"</body>"+"</html>");
		
	
	}

}
