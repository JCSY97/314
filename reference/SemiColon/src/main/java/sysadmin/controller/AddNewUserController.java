package sysadmin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sysadmin.entity.*;

@WebServlet (urlPatterns = {"/newUserForm", "/newUserAccount"})
public class AddNewUserController extends HttpServlet{
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		addNewUserLoginForm(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		try {
			submitNewUser(request, response);
			
		}catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	protected void addNewUserLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		List<UserProfile> userProf = UserProfile.selectAllUserAccounts();
		request.setAttribute("userProfileList", userProf);
		RequestDispatcher dis = request.getRequestDispatcher("/UserAccountNew.jsp");
		dis.forward(request, response);
	}
	
	protected void submitNewUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String status = "active";
		int userProfileID = Integer.parseInt(request.getParameter("userProfile"));
		UserProfile userProfile = new UserProfile(userProfileID);
		UserAccount userAccount = new UserAccount(name ,username, password, status, userProfile);
		
		
		HttpSession session = request.getSession();
		if (userAccount.checkUserNameExist()) {
			session.setAttribute("message", "Fail to create User ");
			response.sendRedirect("newUserAccount");
			
		}else {
			userAccount.submitNewUser();
			session.setAttribute("message", "Successfully create a User");
			response.sendRedirect("HomePageAdmin.jsp");
		}
		
		
	}
}
