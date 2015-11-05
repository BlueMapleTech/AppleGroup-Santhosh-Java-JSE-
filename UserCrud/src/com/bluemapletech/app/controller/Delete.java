package com.bluemapletech.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluemapletech.app.model.UserModel;
import com.bluemapletech.app.service.UserService;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
		 Cookie ck[]=request.getCookies();  
		   String name=ck[0].getValue();
		   UserService us=new UserService();
		   UserModel user=new UserModel();
		   user.setName(name);
		  boolean b= us.delete(user);
		  if(b==true)
		  {
			  out.print("user has been deleted");
		  }
		  else
		  {
			  out.print("deleted unsucess");
		  }
		  RequestDispatcher rd=request.getRequestDispatcher("list1.html");
         	rd.forward(request,response );
	    
  }
  catch(Exception e)
  {
	  System.out.print(e);
  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
