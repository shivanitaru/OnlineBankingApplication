package com.Controller;

import java.io.IOException;
import java.sql.Date;
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
import com.DAO.FundTransferDAO;
import com.Model.BeneficiaryModel;
import com.Model.FundTransferModel;
import com.sun.org.apache.bcel.internal.generic.F2I;

/**
 * Servlet implementation class FundTransferController
 */
@WebServlet("/FundTransferController")
public class FundTransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FundTransferController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long millis = System.currentTimeMillis();

		FundTransferDAO FundTransferDAOobj = new FundTransferDAO();

		long remitterAccountNumber = Long.parseLong(request.getParameter("remitterAccountNo"));
		long beneficiaryAccountNumber = Long.parseLong(request.getParameter("beneficiaryAccountNo"));
		String beneficiaryName = request.getParameter("beneficiaryName");
		String IFSCCode = request.getParameter("IFSCCode");
		long amount = Long.parseLong(request.getParameter("amount"));
		Date dateOfTransaction = new Date(millis);

		// Get account number
		HttpSession session = request.getSession();
		BeneficiaryDAO BeneficiaryDAOobj = new BeneficiaryDAO();
		String email = (String) session.getAttribute("uname");
		long accountNumber = BeneficiaryDAOobj.getAccountNumber(email);

		if (accountNumber != remitterAccountNumber) {
			request.setAttribute("invalidRemitterAccountNumberErrorMessage",
					"Invalid remitter account number. Please enter your bank account number.");
			RequestDispatcher ReqDisObj = request.getRequestDispatcher("/FundTransfer.jsp");
			ReqDisObj.forward(request, response);
		} else if (remitterAccountNumber == beneficiaryAccountNumber) {
			request.setAttribute("invalidBeneficiaryAccountNumberErrorMessage",
					"Invalid beneficiary account number. Please enter correct beneficiary account number.");
			RequestDispatcher ReqDisObj = request.getRequestDispatcher("/FundTransfer.jsp");
			ReqDisObj.forward(request, response);
		}else if(!BeneficiaryDAOobj.validateBeneficiaryAccountNumber(remitterAccountNumber, beneficiaryAccountNumber)){
			request.setAttribute("beneficiaryDoesNotExistErrorMessage",
					"This beneficiary account does not exist in your beneficiary list. Please add this beneficiary in your beneficiary list.");
			RequestDispatcher ReqDisObj = request.getRequestDispatcher("/FundTransfer.jsp");
			ReqDisObj.forward(request, response);
		}
		else if (!FundTransferDAOobj.validateAmount(remitterAccountNumber, amount)) {
			request.setAttribute("invalidAmountErrorMessage",
					"Insufficient balance. Minimum balance of Rs 1000 should be in your account. Please enter amount accordingly.");
			RequestDispatcher ReqDisObj = request.getRequestDispatcher("/FundTransfer.jsp");
			ReqDisObj.forward(request, response);
		} else {
			FundTransferModel FundTransferModelObj = new FundTransferModel();
			FundTransferModelObj.setRemitterAccountNumber(remitterAccountNumber);
			FundTransferModelObj.setBeneficiaryAccountNumber(beneficiaryAccountNumber);
			FundTransferModelObj.setBeneficiaryName(beneficiaryName);
			FundTransferModelObj.setIFSCCode(IFSCCode);
			FundTransferModelObj.setAmount(amount);
			FundTransferModelObj.setDateOfTransaction(dateOfTransaction);
			// System.out.println(FundTransferModelObj.getRemitterAccountNumber()+"
			// "+FundTransferModelObj.getBeneficiaryAccountNumber()+"
			// "+FundTransferModelObj.getBeneficiaryName()+"
			// "+FundTransferModelObj.getIFSCCode()+"
			// "+FundTransferModelObj.getAmount()+"
			// "+FundTransferModelObj.getDateOfTransaction());
			List<FundTransferModel> list = new ArrayList<FundTransferModel>();
			list.add(FundTransferModelObj);
			int i = FundTransferDAOobj.transfer(list);
			if (i > 0) {
				int j = FundTransferDAOobj.updateBalance(list);
				if (j > 0) {
					response.sendRedirect("TransactionSuccess.jsp");
				} else {
					response.sendRedirect("TransactionFailed.jsp");
				}
			} else {
				request.setAttribute("errorMessage",
						"This email-id is used before. If you already have account please login or use another email-id.");
				RequestDispatcher reqDisObj = request.getRequestDispatcher("/FundTransfer.jsp");
				reqDisObj.forward(request, response);
			}
		}
	}

}
