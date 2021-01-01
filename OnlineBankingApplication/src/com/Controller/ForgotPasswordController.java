package com.Controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ForgotPasswordDAO;

/**
 * Servlet implementation class ForgotPasswordController
 */
@WebServlet("/ForgotPasswordController")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String receiverAddress = request.getParameter("emailId");
		
		ForgotPasswordDAO ForgotPasswordDAOobj = new ForgotPasswordDAO();
		if(!ForgotPasswordDAOobj.validateEmailId(receiverAddress)){
			request.setAttribute("invalidEmailIdErrorMessage",
					"This Email-Id is not registered with Bank of Pune. Please enter a valid Email-Id.");
			RequestDispatcher ReqDisObj = request.getRequestDispatcher("/ForgotPassword.jsp");
			ReqDisObj.forward(request, response);
		}

		String subject = "Bank account reset password link";
		String bodyMessage = "Dear customer,\n"
				+ "We heard that you lost your Bank account password. Sorry about that!\n"
				+ "But don’t worry! You can now reset your password by clicking the below link or copying and pasting it into your browser:\n\n"
				+ "http://localhost:8097/OnlineBankingApplication/ResetPassword.jsp\n\n\n"
				+ "If you didn't request this, please ignore this email. If you experience any difficulty using our services, please visit our website.\n"
				+ "http://localhost:8097/OnlineBankingApplication/HomePage.jsp\n\n"
				+ "Your password won't change until you access the link above and create a new one.\n\n"
				+ "\nHappy banking!\n\nRegards,\nBank of Pune.";
		
		SendEmailServlet SendEmailServletobj = new SendEmailServlet(); 
		SendEmailServletobj.sendMail(receiverAddress, subject, bodyMessage);
		response.sendRedirect("/OnlineBankingApplication/ResetPasswordMailSent.jsp");
	}
}
