package com.Controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.LoginDAO;
import com.Model.Login;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{	    
			
			Login user = new Login();
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			boolean valid = LoginDAO.validateLogin(user);		    
			if (valid)
			{       
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser",user); 
				
				response.sendRedirect("View.jsp");       		
			}      
			else{		
				
				response.sendRedirect("Error.jsp");
				
			}
		}
					
		catch (Throwable theException) 	    
		{
			System.out.println(theException); 
		}
	}

}
