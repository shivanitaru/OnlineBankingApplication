package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.Model.ChangePasswordModel;
import com.Model.LoginModel;

public class ChangePasswordDAO {

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
	
	public boolean updatePassword(String email, String newPassword) {
		con = getConnectionMethod.getConnection();
		boolean b = false;
		try {
			prepareStatement = con.prepareStatement("Update LoginDetails set Password = ? where Email_Id = ?");
			prepareStatement.setString(1, newPassword);
			prepareStatement.setString(2, email);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next())
				b = true;
			else
				b = false;
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}
}
