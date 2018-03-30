package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	private static final String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root&password=secret";

	private static Connection conn = null;
	
	
	public static Connection getConnection () {
		
		try {
			if(conn == null || conn.isClosed())
				conn = DriverManager.getConnection(jdbcURL);
		} catch (SQLException e) {
			System.out.println("Non è possibile aprire la connessione con il DB");
//			e.printStackTrace();
		}
		
		return conn;
	}

}
