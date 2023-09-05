package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	
	private static Connection connection;
	
	public static Connection fetchDBConnection() throws ClassNotFoundException, SQLException
	{
		System.out.println("connnnn nottttt null ");
		if(connection==null) {
		System.out.println("connnnnnnnnnn nullll");
	
	 //connection=DriverManager.getConnection("jdbc:postgresql://192.168.13.126:42022/stag_jnk_eservices_dev","laservice","laservice");
	connection = DriverManager.getConnection("jdbc:postgresql://10.210.0.173:42022/stag_jnk_eservices_dev","jkeservices", "jkdbjk#");
	// j&k production
	 // connection=DriverManager.getConnection("jdbc:postgresql://192.168.0.69:5975/jkes_sl_db","jkeservices","db@jkes49");
		}else
		{
			System.out.println("in else part");
			connection.close();
			connection = DriverManager.getConnection("jdbc:postgresql://10.210.0.173:42022/stag_jnk_eservices_dev","jkeservices", "jkdbjk#");
			//connection=DriverManager.getConnection("jdbc:postgresql://192.168.13.126:42022/stag_jnk_eservices_dev","laservice","laservice");
			// j&k production
			// connection=DriverManager.getConnection("jdbc:postgresql://192.168.0.69:5975/jkes_sl_db","jkeservices","db@jkes49");
		}
	    return connection;

	}

}
