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

import com.DAO.AdminDAO;
import com.Model.AccountModel;
import com.Model.BranchModel;
import com.Model.EmailModel;
import com.Model.LoginModel;
import com.Model.RegisterModel;

/**
 * Servlet implementation class SendEmailServlet
 */
@WebServlet("/SendEmailServlet")
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDAO adminobj = new AdminDAO();

	public void getEmail(String email) {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String receiverAddress = request.getParameter("emailId");
		String accountStatus = request.getParameter("status");
		String bodyMessage = "Dear Customer,\n\t", subject = "New Account request ";
		if (accountStatus.equalsIgnoreCase("Approved")) {
			EmailModel emailData = accountApproved(receiverAddress);
			System.out.println(accountStatus);
			subject += "approved";
			bodyMessage += "Your new account has been created in our Bank. Please note the following account details and DO NOT share it with anyone.\n\n\tAccount Holder's Name : "
					+ emailData.getAccountHolderName() + "\n\n\tRegistered Mail Id : " + emailData.getEmailId()
					+ "\n\n\tPassword : " + emailData.getPassword() + "\n\n\tAccount No : "
					+ emailData.getAccountNumber() + "\n\n\tBranch Name : " + emailData.getBranchName()
					+ "\n\n\tInitial Balance : " + emailData.getBalance()
					+ "\n\nHope you like our services!\n\nSincere thanks,\nBank.";
			System.out.println("bodymessage" + bodyMessage);
			sendMail(receiverAddress, subject, bodyMessage);
		} else if (accountStatus.equalsIgnoreCase("Rejected")) {
			System.out.println(accountStatus);
			accountRejected(receiverAddress, accountStatus);
			subject += "rejected";
			bodyMessage += "We are sorry to inform you that your request to create new account in our bank has been rejected due to invalid information. \nPlease register again with valid information.\n\nSincere thanks,\nBank.";
			System.out.println("bodymessage" + bodyMessage);
			sendMail(receiverAddress, subject, bodyMessage);
		}
		response.sendRedirect("AdminController");
	}

	private void sendMail(String receiverAddress, String subject, String bodyMessage) {
		final String username = "vini.mehta78@gmail.com";
		final String password = "qgtvqkizrzaurqwp";
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

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private EmailModel accountApproved(String receiverAddress) {
		RegisterModel approvedUserData = adminobj.getApprovedData(receiverAddress);
		EmailModel emailData = adminobj.savePermanentData(approvedUserData);
		return emailData;
	}

	private void accountRejected(String receiverAddress, String accountStatus) {
		int updateTemp = adminobj.updateTempData(receiverAddress, accountStatus);
		if (updateTemp > 0)
			System.out.println("Data successfully updated from Customer Register Details table");
		else
			System.out.println("Failed to update data from Customer Register Details table");
	}
}
