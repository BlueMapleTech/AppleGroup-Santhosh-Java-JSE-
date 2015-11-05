package com.bluemapletech.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout1
 */
public class Logout1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("link.html");
		rd.include(request,response );
		Cookie ck2=new Cookie("name","");  
	    ck2.setMaxAge(0);  
	    response.addCookie(ck2);  
	    Cookie ck1=new Cookie("name","");  
	    ck1.setMaxAge(0);  
	    response.addCookie(ck1);  
		HttpSession hs=request.getSession();
		String name = null;
		hs.setAttribute("action", name);
	
	    out.print("logout sucess");
	    RequestDispatcher rd1=request.getRequestDispatcher("index.jsp");
		rd1.forward(request,response );
		

		
		
		
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
