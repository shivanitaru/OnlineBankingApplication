package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.LoginDAO;
import com.Model.LoginModel;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		System.out.println(username);
		System.out.println(password);

		LoginModel LoginModelObj = new LoginModel();
		LoginModelObj.setEmailId(username);
		LoginModelObj.setPassword(password);
		System.out.println(username);
		System.out.println(password);

		List<LoginModel> list = new ArrayList<LoginModel>();
		list.add(LoginModelObj);
		LoginDAO LoginDaoObj = new LoginDAO();
		boolean b = LoginDaoObj.validate(list);

		if (b) {
			LoginModel l = list.get(0);
			String emailId = l.getEmailId();
			String CustomerName = LoginDaoObj.GetName(emailId);
			System.out.println(CustomerName);
			HttpSession session = request.getSession();
			session.setAttribute("CustName", CustomerName);
			session.setAttribute("uname", username);
			response.sendRedirect("HomePage.jsp");
		} else {
			request.setAttribute("errorMessage",
					"Invalid username or password. Please enter correct login credentials.");
			RequestDispatcher ReqDisObj = request.getRequestDispatcher("/LoginPage.jsp");
			ReqDisObj.forward(request, response);
		}
	}

}
