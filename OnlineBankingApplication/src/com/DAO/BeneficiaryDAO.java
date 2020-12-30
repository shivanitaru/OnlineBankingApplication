package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.Model.BeneficiaryModel;
import com.Model.LoginModel;
import com.Model.RegisterModel;

public class BeneficiaryDAO {
	public static Connection con;
	GetConnection getConnectionMethod = new GetConnection();
	public ResultSet resultSet;
	public PreparedStatement prepareStatement;

	public int saveBeneficiary(List<BeneficiaryModel> list) {
		con = getConnectionMethod.getConnection();
		BeneficiaryModel l = list.get(0);
		int i = 0;
		try {
			prepareStatement = con.prepareStatement("INSERT INTO BeneficiaryDetails VALUES(?, ?, ?, ?, ?, ?)");
			prepareStatement.setLong(1, l.getAccountNumber());
			prepareStatement.setLong(2, l.getBeneficiaryAccountNumber());
			prepareStatement.setString(3, l.getBeneficiaryName());
			prepareStatement.setString(4, l.getBranchName());
			prepareStatement.setString(5, l.getIFSCCode());
			prepareStatement.setString(6, l.getBankName());

			i = prepareStatement.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return i;
	}

	public long getAccountNumber(String emailId) {

		con = getConnectionMethod.getConnection();
		long accountNumber = 0;
		try {
			prepareStatement = con.prepareStatement("select Account_No from AccountDetails where Email_Id = ?");
			prepareStatement.setString(1, emailId);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				accountNumber = resultSet.getLong(1);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return accountNumber;
	}
	public boolean validateBeneficiaryAccountNumber(long remitterAccountNumber, long beneficiaryAccountNumber) {
		con = getConnectionMethod.getConnection();
		boolean b=false;
		try {
			prepareStatement = con.prepareStatement("select * from BeneficiaryDetails where ACCOUNT_NO=? AND BENEFICIARY_ACCOUNT_NO=?");
			prepareStatement.setLong(1, remitterAccountNumber);
			prepareStatement.setLong(2, beneficiaryAccountNumber);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				b = true;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return b;
	}

	public boolean checkBeneficiaryAccountNumber(long accountNumber, long beneficiaryAccountNumber) {
		con = getConnectionMethod.getConnection();
		boolean b=false;
		try {
			prepareStatement = con.prepareStatement("select * from BeneficiaryDetails where ACCOUNT_NO=? AND BENEFICIARY_ACCOUNT_NO=?");
			prepareStatement.setLong(1, accountNumber);
			prepareStatement.setLong(2, beneficiaryAccountNumber);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				b = true;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return b;
	}
}
