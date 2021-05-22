package Testing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forgotpassword")
public class forgotpassword extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String user =request.getParameter("username");
	   String Securityanswer =request.getParameter("Securityanswer");
	   
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 	Connection connection  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/loginusers","root","admin");
		  Statement statement =   connection.createStatement();
		  ResultSet rs =   statement.executeQuery("select * from registeredusers where Username ='" + user + "'");
		  if(rs.next())
		  {
			String Expectedanswer =  rs.getString("Securityquestion");
			String password =  rs.getString("Userpassword");
			if(Expectedanswer.contentEquals(Securityanswer)) 
			{
				System.out.println(password);
			}
		  }
		  
		    
		
		} 
	catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}