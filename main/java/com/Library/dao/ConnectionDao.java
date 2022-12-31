package com.Library.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDao {

	private static Connection con;
	
	public static Connection getConnection()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}
	
}
