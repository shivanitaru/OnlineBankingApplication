package com.DAO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.Model.AccountModel;
import com.Model.BranchModel;
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

	public List<RegisterModel> getApplicantDetails() {
		List<RegisterModel> applicantDetails = new ArrayList<RegisterModel>();
		con = getConnectionMethod.getConnection();
		try {
			// prepareStatement = con.prepareStatement("INSERT INTO CustomerRegisterDetails
			// VALUES(?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?, ?, ?,?)");
			// prepareStatement.setString(1,"shivani" );
			// prepareStatement.setString(2,"vijay" );
			// prepareStatement.setString(3,"f" );
			// prepareStatement.setString(4,"13-11-1999" );
			// prepareStatement.setString(5,"hadapsar" );
			// prepareStatement.setString(6,"maha" );
			// prepareStatement.setString(7,"pune" );
			// prepareStatement.setString(8,"411001" );
			// prepareStatement.setString(9,"indian" );
			// prepareStatement.setString(10,"9856857485" );
			// prepareStatement.setString(11,"852563145263" );
			// prepareStatement.setString(12,"8525634152" );
			// prepareStatement.setString(13,"shivani.taru201@gmail.com" );
			// prepareStatement.setString(14,"shgv" );
			// prepareStatement.setString(15,"hadapsar");
			// prepareStatement.setString(16,null);
			// int i = prepareStatement.executeUpdate();
			// System.out.println(i);
			//

			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from CustomerRegisterDetails");

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
			prepareStatement.setString(1,emailId);
			resultSet=prepareStatement.executeQuery();
			if(resultSet.next()) {
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
				//System.out.println("Name:"+r.getCustomerName()+"\nCustFname:"+r.getCustomerFathersName()+"\nGender:"+r.getGender()+"\ndob:"+r.getDateOfBirth()+"\nadd:"+r.getAddress()+"\nstate:"+r.getState()+"\nCity:"+r.getCity()+"\npincode:"+r.getPinCode()+"\nnatoinality:"+r.getNationality()+"\nmob no:"+r.getMobileNumber()+"\naadhar:"+r.getAadharNumber()+"\npan:"+r.getPanCardNumber()+"\nemail:"+r.getEmailId()+"\nacc type:"+r.getAccountType()+"\nbranchname:"+r.getBranchName()+"\nstatus:"+r.getStatus());
			}
			else
			{
				System.out.println("Error:Cannot find in db");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return approvedUserData;
	}

	public void savePermanentData(RegisterModel approvedUserData) {
		// TODO Auto-generated method stub

		UserPersonalModel savePersonalData = new UserPersonalModel();
		UserAddressModel saveAddressData = new UserAddressModel();
		UserIdentityModel saveIdentityData = new UserIdentityModel();
		LoginModel saveLoginData = new LoginModel();
		AccountModel saveAccountData = new AccountModel();
		BranchModel getBranchData = new BranchModel();
		
	}
}
