package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.RegisterDAO;
import com.Model.RegisterModel;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {

			response.setContentType("text/html;charset=UTF-8");
			String customerName = request.getParameter("FirstName") + " " + (String) request.getParameter("MiddleName")
					+ " " + (String) request.getParameter("LastName");
			String customerFathersName = request.getParameter("FatherFirstName") + " "
					+ (String) request.getParameter("FatherMiddleName") + " "
					+ (String) request.getParameter("FatherLastName");
			String gender = request.getParameter("gender");
			Date dateOfBirth = Date.valueOf(request.getParameter("dob"));
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			int pincode = Integer.parseInt(request.getParameter("pincode"));
			String nationality = request.getParameter("nationality");
			long mobileNumber = Long.parseLong(request.getParameter("mobile"));
			long aadhaarNumber = Long.parseLong(request.getParameter("aadhaar"));
			String pancardNumber = request.getParameter("pancard");
			String email = request.getParameter("email");
			String accountType = request.getParameter("accountType");
			String branchName = request.getParameter("branchName");
			String status = "Pending";

			RegisterModel r = new RegisterModel();
			r.setCustomerName(customerName);
			r.setCustomerFathersName(customerFathersName);
			r.setGender(gender);
			r.setDateOfBirth(dateOfBirth);
			r.setAddress(address);
			r.setCity(city);
			r.setState(state);
			r.setPinCode(pincode);
			r.setNationality(nationality);
			r.setMobileNumber(mobileNumber);
			r.setAadhaarNumber(aadhaarNumber);
			r.setPanCardNumber(pancardNumber);
			r.setEmailId(email);
			r.setAccountType(accountType);
			r.setBranchName(branchName);
			r.setStatus(status);

			List<RegisterModel> lst = new ArrayList<RegisterModel>();
			lst.add(r);
			RegisterDAO rd = new RegisterDAO();
			int c = rd.savedata(lst);
			if (c > 0) {
				response.sendRedirect("RegisterMessage.jsp");
			} else {
				request.setAttribute("errorMessage",
						"This email-id is used before. If you already have account please login or use another email-id.");
				RequestDispatcher reqDisObj = request.getRequestDispatcher("/RegistrationPage.jsp");
				reqDisObj.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
}
