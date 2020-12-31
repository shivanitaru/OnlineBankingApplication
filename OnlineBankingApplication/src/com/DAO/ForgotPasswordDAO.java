package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ForgotPasswordDAO {
	public static Connection con;
	GetConnection getConnectionMethod = new GetConnection();
	public ResultSet resultSet;
	public PreparedStatement prepareStatement;

	public boolean validateEmailId(String emailId) {
		con = getConnectionMethod.getConnection();
		boolean b = false;

		try {
			System.out.println(emailId);
			prepareStatement = con.prepareStatement("select * from LoginDetails where Email_Id=?");
			prepareStatement.setString(1,  emailId);
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
