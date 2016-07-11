package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import com.Connection.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SignupController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
	PrintWriter out=response.getWriter();
	String FirstName,LastName,Email,Password;
		Connection con;
		
		FirstName=request.getParameter("FirstName");
		LastName=request.getParameter("LastName");
		Email=request.getParameter("Email");
		Password=request.getParameter("Password");
		try
		{
		con=ConnectionManager.getConnection();
		
		PreparedStatement pst=con.prepareStatement("INSERT INTO Login values (?,?,?,?)");
			pst.setString(1, FirstName);
			pst.setString(2, LastName);
			pst.setString(3, Email);
			pst.setString(4, Password);
			int i=pst.executeUpdate();
			
			if(FirstName.isEmpty()||LastName.isEmpty()||Email.isEmpty()||Password.isEmpty())
			{
				RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
				out.println("<font color=red>Please fill all the fields</font>");
				rd.include(request, response);
			}
			
			
			else if(i>0)
			{
				
				out.println(" Registered ");
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
				
			}
			else
			{
				out.println("Error.jsp");
			}
			
			
		}
		catch (Exception e) {
			response.sendRedirect("Error.jsp");
			
			
		}
		
		
		
	}

}
