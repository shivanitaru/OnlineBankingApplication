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

import com.DAO.ChangePasswordDAO;
import com.Model.ChangePasswordModel;
import com.Model.LoginModel;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePasswordController")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("uname");
		System.out.println(email);
		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmNewPassword = request.getParameter("confirmNewPassword");
			

		LoginModel LoginModelObj = new LoginModel();
		LoginModelObj.setEmailId(email);
		LoginModelObj.setPassword(currentPassword);
		System.out.println("test1");

		List<LoginModel> list = new ArrayList<LoginModel>();
		list.add(LoginModelObj);
		
		/*ChangePasswordModel ChangePasswordModelObj = new ChangePasswordModel();
		ChangePasswordModelObj.setCurrentPassword(currentPassword);
		ChangePasswordModelObj.setNewPassword(newPassword);
		ChangePasswordModelObj.setConfirmNewPassword(confirmNewPassword);
		
		List<ChangePasswordModel> list = new ArrayList<ChangePasswordModel>();
		list.add(ChangePasswordModelObj);*/

		ChangePasswordDAO ChangePasswordDaoObject = new ChangePasswordDAO();
		boolean b1 = ChangePasswordDaoObject.validate(list);
		
		if(b1){
			if(newPassword.equals(confirmNewPassword)){
				boolean b2 = ChangePasswordDaoObject.updatePassword(email, newPassword);
				if(b2){
					
					response.sendRedirect("ChangePasswordSuccess.jsp");

				}
				
			}
			else{
				request.setAttribute("errorMessage",
						"New Password & Confirm New Password do not match. Please enter again.");
				RequestDispatcher ReqDisObj = request.getRequestDispatcher("/ChangePassword.jsp");
				ReqDisObj.forward(request, response);
				
			}
				
		}
		else {
			request.setAttribute("errorMessage",
					"Invalid current password. Please enter the Correct Current Password. ");
			RequestDispatcher ReqDisObj = request.getRequestDispatcher("/ChangePassword.jsp");
			ReqDisObj.forward(request, response);
		}
					
	}

}
