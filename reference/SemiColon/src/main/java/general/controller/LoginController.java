package general.controller;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import sysadmin.entity.UserAccount;;


@WebServlet ("/login")

public class LoginController extends HttpServlet{
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		loginUser(request, response);
	}
	
	protected void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		String password= request.getParameter("password");
		int userProfileID = Integer.parseInt(request.getParameter("profile")) ;
		UserAccount userAccount = new UserAccount(userProfileID);
		
		log(username);
		log(password);
		log(request.getParameter("profile"));
		userAccount.setUsername(username);
		userAccount.setPassword(password);
		
		HttpSession session = request.getSession();
		
		if (userAccount.login()) {
			session.setAttribute("username", username);
			session.setAttribute("profile", userAccount.getUserProfile().getProfile());
			
			if (userProfileID == 1) {
				response.sendRedirect("HomePageAdmin.jsp");
				
			}else if (userProfileID == 2) {
				response.sendRedirect("HomePageReviewer.jsp");
			}
		}
		else {
			session.setAttribute("error", "Login failed. Incorrect username or password.");
			response.sendRedirect("index.jsp");
		}
		
		

		
	}
	
	
	
}
