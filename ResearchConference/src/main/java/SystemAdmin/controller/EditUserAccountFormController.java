package sysadmin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sysadmin.entity.*;


@WebServlet (urlPatterns="/editUserAccountForm")
public class EditUserAccountFormController extends HttpServlet{
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		editUserAccount(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	protected void editUserAccount (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    int currentID = Integer.parseInt(request.getParameter("id")) ;
	    UserAccount tempUser = new UserAccount();
	    tempUser.setId(currentID);
	    tempUser = tempUser.getEditInfo();
        List<UserProfile> tempProfileList = UserProfile.selectAllUserAccounts();

        // RequestDispatcher dispatcher = request.getRequestDispatcher("UserAccountEdit.jsp");
        request.setAttribute("userAccount", tempUser);
        request.setAttribute("userProfileList", tempProfileList);
        RequestDispatcher dis = request.getRequestDispatcher("UserAccountEdit.jsp");
        dis.forward(request, response);
	}
	
	
	
}
