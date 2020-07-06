package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.Model.RegisterModel;

public class RegisterDAO {
	
	public static Connection con;
	GetConnection getConnectionMethod=new GetConnection();
	public Statement s1;
	public ResultSet rs1;
	public PreparedStatement ps1;
	
	public int savedata(List<RegisterModel>lst) {
		int i=0;
		int cnt=0;
		con=getConnectionMethod.getConnection();
		RegisterModel r=lst.get(0);
		try
		{
			ps1 = con.prepareStatement("INSERT INTO CustomerRegisterDetails VALUES(?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?, ?, ?,?)");
			ps1.setString(1,r.getCustomerName());
			ps1.setString(2,r.getCustomerFathersName());
			ps1.setString(3,r.getGender());
			ps1.setString(4,r.getDateOfBirth());
			ps1.setString(5,r.getAddress());
			ps1.setString(6,r.getState());
			ps1.setString(7,r.getCity());
			ps1.setInt(8,r.getPinCode());
			ps1.setString(9,r.getNationality());
			ps1.setLong(10,r.getMobileNumber());
			ps1.setLong(11,r.getAadharNumber());
			ps1.setString(12,r.getPanCardNumber());
			ps1.setString(13,r.getEmailId());
			ps1.setString(14,r.getAccountType());
			ps1.setString(15,r.getBranchName());
			ps1.setString(16,r.getStatus());
			
			i=ps1.executeUpdate();
			con.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		if(i>0) {
			cnt=1;
		}
		
		return cnt;
		
	}

}
