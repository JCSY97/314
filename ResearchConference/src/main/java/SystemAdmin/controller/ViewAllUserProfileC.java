package sysadmin.controller;

import javax.servlet.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import sysadmin.entity.UserAccount;
import java.util.List;
import sysadmin.entity.UserProfile;


@WebServlet("/viewUserProfile")

public class ViewAllUserProfileC extends HttpServlet{
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		viewAllProfileController(request, response);
	}
	
	
	protected void viewAllProfileController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			List<UserProfile> userProf = UserProfile.selectAllUserAccounts();
			request.setAttribute("userProfileList", userProf);
			RequestDispatcher dis = request.getRequestDispatcher("/UserProfilePage.jsp");
			dis.forward(request, response);
		}catch (Exception ex) {
			log(ex.toString());
		}
		
	}
	
	
}
