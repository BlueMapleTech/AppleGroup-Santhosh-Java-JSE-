package com.db;

import java.sql.Connection;

public class DBConnectionManager {
	 String dbURL;
     String user;
     String password;
    private Connection con;
     
    public DBConnectionManager(String url, String u, String p){
        this.dbURL=url;
        this.user=u;
        this.password=p;
        //create db connection now
         
    }
     
    public Connection getConnection(){
    	System.out.println("connection sucess");
        return this.con;
    }
     
    public void closeConnection(){
        //close DB connection here
    }

}
