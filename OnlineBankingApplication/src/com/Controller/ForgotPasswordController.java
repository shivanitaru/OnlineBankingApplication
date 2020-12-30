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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("toMail", receiverAddress);

		String subject = "Bank account password reset link";
		String bodyMessage = "Dear customer,\n"
				+ "We heard that you lost your Bank account password. Sorry about that!\n"
				+ "But don’t worry! You can now reset your password by clicking the below link or copying and pasting it into your browser:\n\n"
				+ "http://localhost:8097/OnlineBankingApplication/ResetPassword.jsp\n\n"
				+ "If you didn't request this, please ignore this email. If you experience any difficulty, please visit our website.\n"
				+ "http://localhost:8097/OnlineBankingApplication/HomePage.jsp\n"
				+ "Your password won't change until you access the link above and create a new one.\n\n"
				+ "Thank you,\n" + "Bank";
		final String username = "vini.mehta78@gmail.com";
		final String password = "stjtyoknzieatkaw";
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverAddress));
			message.setSubject(subject);
			message.setText(bodyMessage);

			Transport.send(message);

			System.out.println("Done");
			response.sendRedirect("/OnlineBankingApplication/ResetPasswordMailSent.jsp");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
