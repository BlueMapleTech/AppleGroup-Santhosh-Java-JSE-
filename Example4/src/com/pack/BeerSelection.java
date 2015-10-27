package com.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeerSelection
 */
public class BeerSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerSelection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String C=request.getParameter("color");
	out.println("beer color is"+C);
	*/
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String c=request.getParameter("color");
		BeerExpert be=new BeerExpert();
		List<String> result=be.getBrands(c);
		out.println("beer selection advice");
		Iterator<String> it=result.iterator();
		while(it.hasNext())
		{
			out.println("<br/>try:"+it.next());
		}
	
	/*String c=request.getParameter("color");
	BeerExpert be=new BeerExpert();
	List<String> result=be.getBrands(c);
	request.setAttribute("styles",result);
	RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
rd.forward(request, response);
*/	
	}

}
