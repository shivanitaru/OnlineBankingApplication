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

import com.DAO.BeneficiaryDAO;
import com.DAO.LoginDAO;
import com.Model.BeneficiaryModel;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * Servlet implementation class AddBeneficiaryController
 */
@WebServlet("/AddBeneficiaryController")
public class AddBeneficiaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBeneficiaryController() {
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
		HttpSession session = request.getSession();
		BeneficiaryDAO BeneficiaryDAOobj = new BeneficiaryDAO();

		String email = (String) session.getAttribute("uname");

		long accountNumber = BeneficiaryDAOobj.getAccountNumber(email);
		long beneficiaryAccountNumber = Long.parseLong(request.getParameter("beneficiaryAccountNo"));
		String beneficiaryName = request.getParameter("beneficiaryName");
		String IFSCCode = request.getParameter("IFSCCode");
		String branchName = request.getParameter("branchName");
		String bankName = request.getParameter("bankName");

		if (accountNumber == beneficiaryAccountNumber) {
			request.setAttribute("invalidBeneficiaryAccountNumberErrorMessage",
					"Invalid beneficiary account number. Cannot add self acount number as beneficiary. Please add some other account number.");
			RequestDispatcher ReqDisObj = request.getRequestDispatcher("/BeneficiaryDetails.jsp");
			ReqDisObj.forward(request, response);
		} else if (BeneficiaryDAOobj.checkBeneficiaryAccountNumber(accountNumber,beneficiaryAccountNumber)) {
			request.setAttribute("alreadyExistBeneficiaryAccountNumberErrorMessage",
					"This beneficiary account already exists. Please add some other account number.");
			RequestDispatcher ReqDisObj = request.getRequestDispatcher("/BeneficiaryDetails.jsp");
			ReqDisObj.forward(request, response);
		} else {
		BeneficiaryModel BeneficiaryModelObj = new BeneficiaryModel();
		BeneficiaryModelObj.setAccountNumber(accountNumber);
		BeneficiaryModelObj.setBeneficiaryAccountNumber(beneficiaryAccountNumber);
		BeneficiaryModelObj.setBeneficiaryName(beneficiaryName);
		BeneficiaryModelObj.setIFSCCode(IFSCCode);
		BeneficiaryModelObj.setBranchName(branchName);
		BeneficiaryModelObj.setBankName(bankName);

		List<BeneficiaryModel> list = new ArrayList<BeneficiaryModel>();
		list.add(BeneficiaryModelObj);
		int i = BeneficiaryDAOobj.saveBeneficiary(list);
		if (i > 0) {
			response.sendRedirect("BeneficiaryDetails.jsp");
		} else {
			request.setAttribute("errorMessage",
					"This email-id is used before. If you already have account please login or use another email-id.");
			RequestDispatcher reqDisObj = request.getRequestDispatcher("/BeneficiaryDetails.jsp");
			reqDisObj.forward(request, response);
		}
	}
	}
}
