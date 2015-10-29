package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.db.DBConnectionManager;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
public class Listener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	   
    	  ServletContext ctx = servletContextEvent.getServletContext();
          
          String url = ctx.getInitParameter("DBURL");
          String u = ctx.getInitParameter("DBUSER");
          String p = ctx.getInitParameter("DBPWD");
           
          DBConnectionManager dbManager = new DBConnectionManager(url, u, p);
          ctx.setAttribute("DBManager", dbManager);
          System.out.println("Database connection initialized for Application."); 
        
    }
	
    
    
    
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	  ServletContext ctx = servletContextEvent.getServletContext();
          DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute("DBManager");
          dbManager.closeConnection();
          System.out.println("Database connection closed for Application.");
               
    
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    
}
