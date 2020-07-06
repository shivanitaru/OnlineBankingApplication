package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			try(PrintWriter out=response.getWriter()){
			
			response.setContentType("text/html;charset=UTF-8");
			String customerName = request.getParameter("name");
			String customerFathersName = request.getParameter("fname");
			String gender = request.getParameter("gender");
			Date dateOfBirth = Date.valueOf(request.getParameter("dob"));
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			int pincode = Integer.parseInt(request.getParameter("pincode"));
			String nationality = request.getParameter("nationality");
			long mobileNumber = Long.parseLong(request.getParameter("mobile"));
			long aadharNumber = Long.parseLong(request.getParameter("aadhar"));
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
			r.setAadharNumber(aadharNumber);
			r.setPanCardNumber(pancardNumber);
			r.setEmailId(email);
			r.setAccountType(accountType);
			r.setBranchName(branchName);
			r.setStatus(status);
			
			List<RegisterModel>lst=new ArrayList<RegisterModel>();
			lst.add(r);
			System.out.println(r.getDateOfBirth());
			RegisterDAO rd=new RegisterDAO();
			int c=rd.savedata(lst);
			if(c>0)
			{
				response.sendRedirect("LoginPage.jsp");
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
}
