package connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSQL {

	private static ConnectionSQL dbConfig = null;
	
	private ConnectionSQL() {};
	
	public static ConnectionSQL conecion () {
		
		if (dbConfig == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbConfig =  (ConnectionSQL) DriverManager.getConnection("URL","usuario","password");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dbConfig;
	}
}
