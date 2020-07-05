package com.DAO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import com.Model.RegisterModel;

public class AdminDAO{
	public static Connection con;
	GetConnection getConnectionMethod=new GetConnection();
	public Statement s1;
	public ResultSet rs1;
	public PreparedStatement ps1;
	public List<RegisterModel> getApplicantDetails(){
		List<RegisterModel> applicantDetails=new ArrayList<RegisterModel>();
		con=getConnectionMethod.getConnection();
		try{
//			ps1 = con.prepareStatement("INSERT INTO CustomerRegisterDetails VALUES(?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?, ?, ?,?)");
//			ps1.setString(1,"shivani" );
//			ps1.setString(2,"vijay" );
//			ps1.setString(3,"f" );
//			ps1.setString(4,"13-11-1999" );
//			ps1.setString(5,"hadapsar" );
//			ps1.setString(6,"maha" );
//			ps1.setString(7,"pune" );
//			ps1.setString(8,"411001" );
//			ps1.setString(9,"indian" );
//			ps1.setString(10,"9856857485" );
//			ps1.setString(11,"852563145263" );
//			ps1.setString(12,"8525634152" );
//			ps1.setString(13,"shivani.taru201@gmail.com" );
//			ps1.setString(14,"shgv" );
//			ps1.setString(15,"hadapsar");
//			ps1.setString(16,null);
//			int i = ps1.executeUpdate();
//			System.out.println(i);
//			

			s1=con.createStatement();
			rs1=s1.executeQuery("select * from CustomerRegisterDetails");
			
			while(rs1.next()){
				RegisterModel r = new RegisterModel();
				r.setCustomerName(rs1.getString(1));				
				r.setCustomerFathersName(rs1.getString(2));
				r.setGender(rs1.getString(3));
				r.setDateOfBirth(rs1.getDate(4));
				r.setAddress(rs1.getString(5));
				r.setState(rs1.getString(6));
				r.setCity(rs1.getString(7));
				r.setPinCode(rs1.getInt(8));
				r.setNationality(rs1.getString(9));
				r.setMobileNo(rs1.getLong(10));
				r.setAadharNo(rs1.getLong(11));
				r.setPanCardNo(rs1.getString(12));				
				r.setEmailId(rs1.getString(13));				
				r.setAccountType(rs1.getString(14));				
				r.setBranchName(rs1.getString(15));	
				applicantDetails.add(r);
			}	
            con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return applicantDetails;
	}
}
