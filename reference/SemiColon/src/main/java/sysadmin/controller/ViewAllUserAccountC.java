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
import sysadmin.entity.UserAccount;


@WebServlet("/viewUserAccount")

public class ViewAllUserAccountC extends HttpServlet{
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		viewAllUserController(request, response);
	}
	
	
	protected void viewAllUserController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			List<UserAccount> userAcc = UserAccount.selectAllUserAccounts();
			request.setAttribute("userAccountList", userAcc);
			RequestDispatcher dis = request.getRequestDispatcher("/UserAccountPage.jsp");
			dis.forward(request, response);
		}catch (Exception ex) {
			log(ex.toString());
		}
		
	}
	
	
}
