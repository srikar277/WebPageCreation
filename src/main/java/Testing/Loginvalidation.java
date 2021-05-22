package Testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Loginvalidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ResultSet rs;
	   String user =request.getParameter("uname");
		String pwd =request.getParameter("pwd");
		try{
			Class.forName("com.mysql.jdbc.Driver");
	        Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginusers","root","admin");
		  Statement stmt  = Connection.createStatement(); 
		  rs=stmt.executeQuery("select * from Registeredusers where Username='"+user+"'");
		  if(rs.next())
		  {
			String Username =   rs.getString("Username");
			String Userpassword =   rs.getString("Userpassword");
			if(Username.equals(user) && Userpassword.equals(pwd) )
			{
			  System.out.println(user +"  "+ pwd);
			  System.out.println("if condition");
			  response.sendRedirect("/WebPageCreation/Homepageofmyworld.html");
			}
			else if(Username.equals(user) && !Userpassword.equals(pwd))	
			{
				System.out.println("else if condition");
			    response.sendRedirect("/WebPageCreation/loginpage.html");
			}
			
			  }		
		  else {
				response.sendRedirect("/WebPageCreation/Registrationpage.html");}
					}
	     catch(Exception e) 
	     {
		  System.out.println(e);
	     }
			}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
