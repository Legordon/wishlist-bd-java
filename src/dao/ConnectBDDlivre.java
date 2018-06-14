package dao;

import java.sql.*;

public class ConnectBDDlivre {

	private static ConnectBDDlivre singleton = null;
	private static Connection connection = null;
	final static String driver = "org.gjt.mm.mysql.Driver";
	final static String url = new String("jdbc:mysql://localhost/wishlist");
	final static String login = "root";
	final static String password = "";
	
	
	
	private ConnectBDDlivre() {
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
		} catch(SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if(singleton == null) {
			singleton = new ConnectBDDlivre();
		}
		
		return connection;
	}
	
	
	public static void close() {
		try {
			if(singleton == null) {
				connection.close();
			} 
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
