package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.Model.LoginModel;

public class LoginDAO {
	
	public static Connection con;
	GetConnection getConnectionMethod=new GetConnection();
	public ResultSet rs1;
	public PreparedStatement ps1;
	
	public boolean validate(List<LoginModel>list) {
		con=getConnectionMethod.getConnection();
		LoginModel l=list.get(0);
		boolean b = false;
		
		try{
			ps1=con.prepareStatement("select * from LoginDetails where Email_Id=? AND Password=?");
			ps1.setString(1,l.getEmailId());
			ps1.setString(2,l.getPassword());
			rs1=ps1.executeQuery();
			if(rs1.next()){
				b=true;
			}
			else
			{
				b=false;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return b;
	}
}
