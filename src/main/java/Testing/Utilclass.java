package Testing;

import java.sql.Connection;
import java.sql.DriverManager;

public class Utilclass {
	
	public Connection ConnectDB() {
 
		try	{
		       Class.forName("com.mysql.jdbc.Driver");
	           Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginusers","root","admin");
	           return Connection;
		    }
		catch(Exception e) 
		{
			   e.printStackTrace();
			  return null;
		}
	}
}
