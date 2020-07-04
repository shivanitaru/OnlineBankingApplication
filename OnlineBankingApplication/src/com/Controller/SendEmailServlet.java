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
 * Servlet implementation class SendEmailServlet
 */
@WebServlet("/SendEmailServlet")
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
public void getEmail(String email){}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		GeneratePassword generate = new GeneratePassword();
		String ReceiverAddress=request.getParameter("emailId");
	System.out.println("Add="+ReceiverAddress);
    	final String username = "vini.mehta78@gmail.com";
        final String password = "qgtvqkizrzaurqwp";
        String bodyMessage="Hii...You created new Account in our Bank\n Your password is : "+generate.generatePassword();
        Properties prop = new Properties();
 		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); 
         
         Session session = Session.getInstance(prop,
                 new javax.mail.Authenticator() {
                     protected PasswordAuthentication getPasswordAuthentication() {
                         return new PasswordAuthentication(username, password);
                     }
                 });

         try {

             Message message = new MimeMessage(session);
             message.setFrom(new InternetAddress(username));
             message.setRecipients(
                     Message.RecipientType.TO,
                     InternetAddress.parse(ReceiverAddress)
             );
             message.setSubject("New Account request approved");
             message.setText(bodyMessage);

             Transport.send(message);

             System.out.println("Done");

         } catch (MessagingException e) {
             e.printStackTrace();
         }
	}

}
