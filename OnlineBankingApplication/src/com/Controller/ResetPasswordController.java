package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.LoginDAO;
import com.Model.LoginModel;

/**
 * Servlet implementation class ResetPasswordController
 */
@WebServlet("/ResetPasswordController")
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResetPasswordController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoginModel updatePassword = new LoginModel();
		updatePassword.setEmailId((String) session.getAttribute("toMail"));
		updatePassword.setPassword(request.getParameter("password"));
		System.out.println(updatePassword.getEmailId() + " " + updatePassword.getPassword());
		LoginDAO loginobj = new LoginDAO();
		int i = loginobj.updatePassword(updatePassword);
		if (i == 1) {
			System.out.println("password changed");
		} else
			System.out.println("password not changed");
		response.sendRedirect("LoginPage.jsp");
	}

}
