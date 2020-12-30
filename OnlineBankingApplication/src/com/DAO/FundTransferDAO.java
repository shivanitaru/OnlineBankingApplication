package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.Model.BeneficiaryModel;
import com.Model.FundTransferModel;
import com.Model.LoginModel;
import com.Model.RegisterModel;

public class FundTransferDAO {
	public static Connection con;
	GetConnection getConnectionMethod = new GetConnection();
	public ResultSet resultSet;
	public PreparedStatement prepareStatement;
	public Statement statement;

	public int transfer(List<FundTransferModel> list) {
		con = getConnectionMethod.getConnection();
		FundTransferModel l = list.get(0);
		int i = 0;
		try {
			prepareStatement = con.prepareStatement(
					"INSERT INTO TransactionDetails VALUES(Transaction_Id.nextval, ?, ?, ?, ?, ?, ?, 'Pending')");
			prepareStatement.setLong(1, l.getRemitterAccountNumber());
			prepareStatement.setLong(2, l.getBeneficiaryAccountNumber());
			prepareStatement.setString(3, l.getBeneficiaryName());
			prepareStatement.setString(4, l.getIFSCCode());
			prepareStatement.setLong(5, l.getAmount());
			prepareStatement.setDate(6, l.getDateOfTransaction());
			i = prepareStatement.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return i;
	}

	public int updateBalance(List<FundTransferModel> list) {
		con = getConnectionMethod.getConnection();
		FundTransferModel l = list.get(0);
		long transactionId = 0;
		int i = 0, j = 0, k = 0;
		try {

			// This will update in remitter table

			prepareStatement = con.prepareStatement("UPDATE AccountDetails set BALANCE = BALANCE-? WHERE ACCOUNT_NO=?");
			prepareStatement.setLong(1, l.getAmount());
			prepareStatement.setLong(2, l.getRemitterAccountNumber());
			i = prepareStatement.executeUpdate();

			// This will update in beneficiary table
			prepareStatement = con.prepareStatement("UPDATE AccountDetails set BALANCE = BALANCE+? WHERE ACCOUNT_NO=?");
			prepareStatement.setLong(1, l.getAmount());
			prepareStatement.setLong(2, l.getBeneficiaryAccountNumber());
			j = prepareStatement.executeUpdate();

			// Get Transaction Id
			statement = con.createStatement();
			resultSet = statement.executeQuery("select MAX(TRANSACTION_ID) from TransactionDetails");
			if (resultSet.next()) {
				transactionId = resultSet.getLong(1);
			}
			System.out.println(transactionId);

			if (i == 1 && j == 1) {
				prepareStatement = con
						.prepareStatement("UPDATE TransactionDetails set STATUS = 'Success' WHERE TRANSACTION_ID=?");
				prepareStatement.setLong(1, transactionId);
				i = prepareStatement.executeUpdate();
				if (i > 0)
					k = 1;
			} else {
				prepareStatement = con
						.prepareStatement("UPDATE TransactionDetails set STATUS = 'Failed' WHERE TRANSACTION_ID=?");
				prepareStatement.setLong(1, transactionId);
				i = prepareStatement.executeUpdate();
				if (i > 0)
					k = 1;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return k;
	}

	

	public boolean validateAmount(long remitterAccountNumber, long amount) {
		con = getConnectionMethod.getConnection();
		boolean b=false;
		try {
			prepareStatement = con.prepareStatement("select * from AccountDetails where ACCOUNT_NO=? ");
			prepareStatement.setLong(1, remitterAccountNumber);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				long balance = resultSet.getLong("BALANCE");
				if(amount<=(balance-1000))
					b=true;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;		
	}
}
