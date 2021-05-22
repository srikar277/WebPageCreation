package Testing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registationpage extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response  ) throws IOException 
	{
		
		String Username = request.getParameter("UserID");
		String fname = request.getParameter("firstname");
		String mname = request.getParameter("middlename");
		String lname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String phoneno = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		System.out.println(Username +" "+ fname +" "+ mname +" "+ lname +" "+ gender +" "+ phoneno +" "+  
				address +" "+  email +" "+  password  );
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection =	DriverManager.getConnection("jdbc:mysql://localhost:3306/loginusers","root","admin");
			String URL = "INSERT INTO registeredusers values (?, ?, ?, ?,?, ?, ?, ?,?)";
			
			PreparedStatement prepareStatement = connection.prepareStatement(URL);
			prepareStatement.setString(1, lname);
			prepareStatement.setString(2, fname);
			prepareStatement.setString(3, address);
			prepareStatement.setString(4, phoneno);
			prepareStatement.setString(5, gender);
			prepareStatement.setString(6, Username);
			prepareStatement.setString(7, password);
			prepareStatement.setString(8, mname);		
			prepareStatement.setString(9, email);
		    prepareStatement.executeUpdate();
			System.out.println("sdfasf");
			response.sendRedirect("/WebPageCreation/RegistrationConfirmed.html");
			
			
	     	}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
