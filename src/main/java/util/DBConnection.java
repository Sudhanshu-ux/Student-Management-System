package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static final String url="jdbc:mysql://localhost:3306/studentdb";
	private static final String password="root";
	private static final String user="root";
	
	public static Connection getConnection() {
		Connection conn=null;
		
		try {
			conn=DriverManager.getConnection(url,user,password);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return conn;
		
	}

}
