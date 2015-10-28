package com.pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    RequestDispatcher rd=request.getRequestDispatcher("link.html");
	    rd.include(request, response);
		String a=request.getParameter("name");
		String b=request.getParameter("pass");
		if((a.equals("santhosh"))&&(b.equals("12345")))
		{
			out.print("login sucess");
			out.print("welcome"+a);
			  Cookie ck=new Cookie("name",a);  
	            response.addCookie(ck);  
	        
		}
		else
		{
			out.print("login failed");
			RequestDispatcher rd1=request.getRequestDispatcher("Login.html");
		    rd1.include(request, response);
		}
		out.close();
		

	
	}

}
