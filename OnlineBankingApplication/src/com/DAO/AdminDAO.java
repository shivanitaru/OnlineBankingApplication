package com.DAO;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.catalina.authenticator.SavedRequest;

import com.Controller.GeneratePassword;
import com.Model.AccountModel;
import com.Model.BranchModel;
import com.Model.EmailModel;
import com.Model.LoginModel;
import com.Model.RegisterModel;
import com.Model.UserAddressModel;
import com.Model.UserIdentityModel;
import com.Model.UserPersonalModel;

public class AdminDAO {
	public static Connection con;
	GetConnection getConnectionMethod = new GetConnection();
	public Statement statement;
	public ResultSet resultSet;
	public PreparedStatement prepareStatement;
	public int status;

	public List<RegisterModel> getApplicantDetails() {
		List<RegisterModel> applicantDetails = new ArrayList<RegisterModel>();
		con = getConnectionMethod.getConnection();
		try {

			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from CustomerRegisterDetails where Status='Pending'");

			while (resultSet.next()) {
				RegisterModel r = new RegisterModel();
				r.setCustomerName(resultSet.getString(1));
				r.setCustomerFathersName(resultSet.getString(2));
				r.setGender(resultSet.getString(3));
				r.setDateOfBirth(resultSet.getDate(4));
				r.setAddress(resultSet.getString(5));
				r.setState(resultSet.getString(6));
				r.setCity(resultSet.getString(7));
				r.setPinCode(resultSet.getInt(8));
				r.setNationality(resultSet.getString(9));
				r.setMobileNumber(resultSet.getLong(10));
				r.setAadharNumber(resultSet.getLong(11));
				r.setPanCardNumber(resultSet.getString(12));
				r.setEmailId(resultSet.getString(13));
				r.setAccountType(resultSet.getString(14));
				r.setBranchName(resultSet.getString(15));
				r.setStatus(resultSet.getString(16));
				applicantDetails.add(r);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return applicantDetails;
	}

	public RegisterModel getApprovedData(String emailId) {

		RegisterModel approvedUserData = new RegisterModel();
		con = getConnectionMethod.getConnection();
		try {
			statement = con.createStatement();
			prepareStatement = con.prepareStatement("select * from CustomerRegisterDetails where Email_Id=?");
			prepareStatement.setString(1, emailId);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				approvedUserData.setCustomerName(resultSet.getString(1));
				approvedUserData.setCustomerFathersName(resultSet.getString(2));
				approvedUserData.setGender(resultSet.getString(3));
				approvedUserData.setDateOfBirth(resultSet.getDate(4));
				approvedUserData.setAddress(resultSet.getString(5));
				approvedUserData.setState(resultSet.getString(6));
				approvedUserData.setCity(resultSet.getString(7));
				approvedUserData.setPinCode(resultSet.getInt(8));
				approvedUserData.setNationality(resultSet.getString(9));
				approvedUserData.setMobileNumber(resultSet.getLong(10));
				approvedUserData.setAadharNumber(resultSet.getLong(11));
				approvedUserData.setPanCardNumber(resultSet.getString(12));
				approvedUserData.setEmailId(resultSet.getString(13));
				approvedUserData.setAccountType(resultSet.getString(14));
				approvedUserData.setBranchName(resultSet.getString(15));
				approvedUserData.setStatus(resultSet.getString(16));
				 System.out.println("Name:"+approvedUserData.getCustomerName()+"\nCustFname:"+approvedUserData.getCustomerFathersName()+"\nGender:"+approvedUserData.getGender()+"\ndob:"+approvedUserData.getDateOfBirth()+"\nadd:"+approvedUserData.getAddress()+"\nstate:"+approvedUserData.getState()+"\nCity:"+approvedUserData.getCity()+"\npincode:"+approvedUserData.getPinCode()+"\nnatoinality:"+approvedUserData.getNationality()+"\nmobno:"+approvedUserData.getMobileNumber()+"\naadhar:"+approvedUserData.getAadharNumber()+"\npan:"+approvedUserData.getPanCardNumber()+"\nemail:"+approvedUserData.getEmailId()+"\nacctype:"+approvedUserData.getAccountType()+"\nbranchname:"+approvedUserData.getBranchName()+"\nstatus:"+approvedUserData.getStatus());
			} else {
				System.out.println("Error:Cannot find in db");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return approvedUserData;
	}

	public EmailModel savePermanentData(RegisterModel approvedUserData) {

		UserPersonalModel savePersonalData = new UserPersonalModel();
		UserAddressModel saveAddressData = new UserAddressModel();
		UserIdentityModel saveIdentityData = new UserIdentityModel();
		LoginModel saveLoginData = new LoginModel();
		AccountModel saveAccountData = new AccountModel();
		BranchModel getBranchData = new BranchModel();
		EmailModel emailData = new EmailModel();
		savePersonalData.setCustomerName(approvedUserData.getCustomerName());
		savePersonalData.setCustomerFathersName(approvedUserData.getCustomerFathersName());
		savePersonalData.setDateOfBirth(approvedUserData.getDateOfBirth());
		savePersonalData.setGender(approvedUserData.getGender());
		savePersonalData.setNationality(approvedUserData.getNationality());
		savePersonalData.setMobileNumber(approvedUserData.getMobileNumber());
		savePersonalData.setEmailId(approvedUserData.getEmailId());
		int savePersonal = insertUserPersonalData(savePersonalData);
		if (savePersonal > 0)
			System.out.println("Data successfully stored in Customer Personal Details table");
		else
			System.out.println("Failed to store data in Customer Personal Details table");

		saveAddressData.setAddress(approvedUserData.getAddress());
		saveAddressData.setState(approvedUserData.getState());
		saveAddressData.setCity(approvedUserData.getCity());
		saveAddressData.setPinCode(approvedUserData.getPinCode());
		saveAccountData.setEmailId(approvedUserData.getEmailId());
		int saveAddress = insertUserAddressData(saveAddressData);
		if (saveAddress > 0)
			System.out.println("Data successfully stored in Customer Address Details table");
		else
			System.out.println("Failed to store data in Customer Address Details table");

		saveIdentityData.setAadharNumber(approvedUserData.getAadharNumber());
		saveIdentityData.setPanCardNumber(approvedUserData.getPanCardNumber());
		saveIdentityData.setEmailId(approvedUserData.getEmailId());
		int saveIdentity = insertUserIdentityData(saveIdentityData);
		if (saveIdentity > 0)
			System.out.println("Data successfully stored in Customer Identity Details table");
		else
			System.out.println("Failed to store data in Customer Identity Details table");

		saveLoginData.setEmailId(approvedUserData.getEmailId());
		saveLoginData.setPassword(GeneratePassword.generatePassword());
		System.out.println(saveLoginData.getPassword());
		int saveLogin = insertLoginData(saveLoginData);
		if (saveLogin > 0)
			System.out.println("Data successfully stored in Login details table");
		else
			System.out.println("Failed to store data in Login details table");

		saveAccountData.setAccountNumber(generateAccountNo());
		saveAccountData.setAccountHolderName(approvedUserData.getCustomerName());
		saveAccountData.setAccountType(approvedUserData.getAccountType());
		saveAccountData.setBalance(5000);
		saveAccountData.setBranchName(approvedUserData.getBranchName());
		saveAccountData.setEmailId(approvedUserData.getEmailId());
		int saveAccount = insertAccountData(saveAccountData);
		if (saveAccount > 0)
			System.out.println("Data successfully stored in Account Details table");
		else
			System.out.println("Failed to store data in Account Details table");

		getBranchData.setBranchName(approvedUserData.getBranchName());
		int getBranch = retrieveBranchData(getBranchData);
		if (getBranch > 0)
			System.out.println("Data successfully retrieved from Branch Details table");
		else
			System.out.println("Failed to retrieved data from Branch Details table");

		emailData.setAccountHolderName(saveAccountData.getAccountHolderName());
		emailData.setEmailId(saveAccountData.getEmailId());
		emailData.setPassword(saveLoginData.getPassword());
		emailData.setBranchName(getBranchData.getBranchName());
		emailData.setIFSCCode(getBranchData.getIFSCCode());
		emailData.setMICRCode(getBranchData.getMICRCode());
		emailData.setBalance(saveAccountData.getBalance());
		emailData.setAccountNumber(saveAccountData.getAccountNumber());
		
		return emailData;
	}

	private int insertUserPersonalData(UserPersonalModel savePersonalData) {
		status = 0;
		System.out.println("in personal1");
		con = getConnectionMethod.getConnection();
		try {
			prepareStatement = con.prepareStatement("INSERT INTO CustomerPersonalDetails VALUES(?, ?, ?, ?, ?, ?, ?)");
			System.out.println("in personal2");
			prepareStatement.setString(1, savePersonalData.getCustomerName());
			prepareStatement.setString(2, savePersonalData.getCustomerFathersName());
			prepareStatement.setString(3, savePersonalData.getDateOfBirth());
			prepareStatement.setString(4, savePersonalData.getGender());
			prepareStatement.setString(5, savePersonalData.getNationality());
			prepareStatement.setLong(6, savePersonalData.getMobileNumber());
			prepareStatement.setString(7, savePersonalData.getEmailId());
			System.out.println("in personal3");
			status = prepareStatement.executeUpdate();
			System.out.println("in personal4");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	private int insertUserAddressData(UserAddressModel saveAddressData) {
		status = 0;
		con = getConnectionMethod.getConnection();
		try {
			prepareStatement = con.prepareStatement("INSERT INTO CustomerAddressDetails VALUES(?, ?, ?, ?, ?)");
			prepareStatement.setString(1, saveAddressData.getAddress());
			prepareStatement.setString(2, saveAddressData.getState());
			prepareStatement.setString(3, saveAddressData.getCity());
			prepareStatement.setInt(4, saveAddressData.getPinCode());
			prepareStatement.setString(5, saveAddressData.getEmailId());
			status = prepareStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	private int insertUserIdentityData(UserIdentityModel saveIdentityData) {
		status = 0;
		con = getConnectionMethod.getConnection();
		try {
			prepareStatement = con.prepareStatement("INSERT INTO CustomerIdentityDetails VALUES(?, ?, ?)");
			prepareStatement.setLong(1, saveIdentityData.getAadharNumber());
			prepareStatement.setString(2, saveIdentityData.getPanCardNumber());
			prepareStatement.setString(3, saveIdentityData.getEmailId());
			status = prepareStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Status identity " + status);

		return status;
	}

	private int insertLoginData(LoginModel saveLoginData) {
		status = 0;
		con = getConnectionMethod.getConnection();
		try {
			prepareStatement = con.prepareStatement("INSERT INTO LoginDetails VALUES(?, ?)");
			prepareStatement.setString(1, saveLoginData.getEmailId());
			prepareStatement.setString(2, saveLoginData.getPassword());
			status = prepareStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Status Login " + status);
		return status;
	}

	private int insertAccountData(AccountModel saveAccountData) {
		status = 0;
		con = getConnectionMethod.getConnection();
		try {
			prepareStatement = con.prepareStatement("INSERT INTO AccountDetails VALUES(?, ?, ?, ?, ?, ?)");
			prepareStatement.setInt(1, saveAccountData.getAccountNumber());
			prepareStatement.setString(2, saveAccountData.getAccountHolderName());
			prepareStatement.setString(3, saveAccountData.getAccountType());
			prepareStatement.setLong(4, saveAccountData.getBalance());
			prepareStatement.setString(5, saveAccountData.getBranchName());
			prepareStatement.setString(6, saveAccountData.getEmailId());
			status = prepareStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Status Account " + status);
		return status;
	}

	private int generateAccountNo() {
		int accountNumber = 2700000;

		con = getConnectionMethod.getConnection();
		try {
			statement = con.createStatement();
			prepareStatement = con.prepareStatement("select * from AccountDetails");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				accountNumber++;
			}
			accountNumber++;
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Accunt no generate " + accountNumber);
		return accountNumber;
	}

	private int retrieveBranchData(BranchModel getBranchData) {
		con = getConnectionMethod.getConnection();
		status = 0;
		try {
			statement = con.createStatement();
			prepareStatement = con.prepareStatement("select * from BranchDetails where Branch_Name=?");
			prepareStatement.setString(1, getBranchData.getBranchName());
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				getBranchData.setIFSCCode(resultSet.getString(2));
				getBranchData.setMICRCode(resultSet.getString(3));
				System.out.println("branchname:" + getBranchData.getBranchName() + "ifsc:" + getBranchData.getIFSCCode()
						+ "micr:" + getBranchData.getMICRCode());
				status = 1;
			} else {
				System.out.println("Error:Cannot find in db");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
}
