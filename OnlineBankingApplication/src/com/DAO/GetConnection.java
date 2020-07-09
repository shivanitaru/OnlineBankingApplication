package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	public static Connection con;
	private String driver="oracle.jdbc.OracleDriver";
    private String url="jdbc:oracle:thin:@localhost:1521:XE";
    private String username="System";
    private String password="123456789";
    
    public Connection getConnection() {
	  try {
	   	 Class.forName(driver);
	   	 con=DriverManager.getConnection(url,username,password);
	   	 //System.out.println("Connection "+con);
	  }
	  catch(Exception e){
	    	System.out.println(e);	
	  }return con;
    }
}
