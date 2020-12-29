package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.Model.LoginModel;
import com.Model.RegisterModel;

public class LoginDAO {

	public static Connection con;
	GetConnection getConnectionMethod = new GetConnection();
	public ResultSet resultSet;
	public PreparedStatement prepareStatement;

	public boolean validate(List<LoginModel> list) {
		con = getConnectionMethod.getConnection();
		LoginModel l = list.get(0);
		boolean b = false;

		try {
			prepareStatement = con.prepareStatement("select * from LoginDetails where Email_Id=? AND Password=?");
			prepareStatement.setString(1, l.getEmailId());
			prepareStatement.setString(2, l.getPassword());
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				b = true;
			} else {
				b = false;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return b;
	}

	public int updatePassword(LoginModel updatePassword) {
		con = getConnectionMethod.getConnection();
		int status = 0;
		try {
			prepareStatement = con.prepareStatement("Update LoginDetails set Password = ? where Email_Id = ?");
			prepareStatement.setString(1, updatePassword.getPassword());
			prepareStatement.setString(2, updatePassword.getEmailId());
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next())
				status = 1;
			else
				System.out.println("Error:Cannot find in db");
			con.close();
			System.out.println(status);
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public String GetName(String emailId) {
		con = getConnectionMethod.getConnection();
		String CustomerName = "";
		try {
			prepareStatement = con
					.prepareStatement("select Customer_Name from CustomerPersonalDetails where Email_Id = ?");
			prepareStatement.setString(1, emailId);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				CustomerName = resultSet.getString(1);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return CustomerName;
	}

}
